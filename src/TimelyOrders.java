import java.util.ArrayList;
import java.util.Scanner;

public class TimelyOrders {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int Q = scan.nextInt();
		RequestCalc requestCalc = new RequestCalc();
		for (int i = 0; i < Q; i++) {
			int type = scan.nextInt();
			int weigh = scan.nextInt();
			int timestamp = scan.nextInt();
			if (type == 1) {
				requestCalc.addRequest(new Request(type, weigh, timestamp));
			} else if (type == 2) {
				requestCalc.addRequest(new Request(type, weigh, timestamp));
				requestCalc.calculate();
				requestCalc.clear();
			}
		}
		requestCalc.clear();
		requestCalc = null;
		scan.close();
	}
	
	
	private static class RequestCalc {
		ArrayList<Request> requests = new ArrayList<>();
		
		public void addRequest(Request request) {
			requests.add(request);
		}
		
		public void clear() {
			requests.clear();
		}
		
		public void calculate() {
			Request KType = requests.get(requests.size() - 1);
			if (KType.isType2()) {
				int startTime = KType.timestamp - KType.weight;
				int finishTime = KType.timestamp; 
				if (startTime >= 0) {
					int totalWeight = 0;
					for (Request request : requests) {
						if (request.isType1()) {
							if (request.timestamp >= startTime && 
									request.timestamp <= finishTime) {
								totalWeight+= request.weight;
							}
						}
					}
					System.out.println(totalWeight);
				}
			}
			
		}
		
	}
	
	private static class Request implements RequestType{
		Type requestType;
		int weight; // last k time in case of type 2 
		int timestamp;
		
		Request(int q, int w, int t) {
			if (q == 1) {
				requestType = Type.Type_1;
			} else if (q == 2) {
				requestType = Type.Type_2;
			} else {
				requestType = Type.InComplete;
			}
			weight = w;
			timestamp = t;
		}

		@Override
		public boolean isType1() {
			return requestType.isType1();
		}

		@Override
		public boolean isType2() {
			return requestType.isType2();
		}

		@Override
		public boolean isIncomplete() {
			return requestType.isIncomplete();
		}
	}
	
	private enum Type implements RequestType {
		
		Type_1(1), Type_2(2), InComplete();
		int q = -1;
		
		Type() {
			q = -1;
		}
		
		Type(int n) {
			q = n;
		}
		
		public boolean isType1() {
			return q == 1;
		}
		public boolean isType2() {
			return q == 2;
		}
		public boolean isIncomplete() {
			return q == -1;
		}
	}
	
	interface RequestType {
		boolean isType1();
		boolean isType2();
		boolean isIncomplete();
	}
}

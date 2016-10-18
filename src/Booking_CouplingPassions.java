import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Booking_CouplingPassions {
	// 2
	// 3 surfing yoga walking
	// 3 wine relaxation beach
	// 3
	// amsterdam 52.374030 4.889690 4 museums canals nightlife walking
	// sagres 37.129665 -8.669586 3 beach surfing relaxation
	// biarritz 43.480120 -1.555580 6 surfing nightlife beach food wine walking
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int guest_count = scanner.nextInt();
		scanner.nextLine();
		Set<String> guestPassions = new HashSet<>();
		for (int i = 0; i < guest_count; i++) {
			int guestpassion = scanner.nextInt();
			for (int j = 0; j < guestpassion; j++) {
				guestPassions.add(scanner.next());
			}
		}
		// for (String passion : guestPassions) {
		// System.out.println(passion);
		// }
		int destination_count = scanner.nextInt();
		ArrayList<Destination> destinations = new ArrayList<>();
		for (int i = 0; i < destination_count; i++) {
			Destination destination = new Destination();
			destination.name = scanner.next();
			destination.lat = scanner.nextFloat();
			destination.lon = scanner.nextFloat();
			int dpassions = scanner.nextInt();
			for (int j = 0; j < dpassions; j++) {
				destination.passions.add(scanner.next());
			}
//			System.out.println(destination);
			destinations.add(destination);
		}
		ArrayList<Destination> shadowList = (ArrayList<Destination>) destinations.clone();

		int maxPassions = 0;
		int secondMaxpassions = 0;
		Set<String> tempPassions = new HashSet<>();

		SelectedDestinations selectedDestinations1 = null;
		SelectedDestinations selectedDestinations2 = null;

		tempPassions.addAll(destinations.get(0).passions);
		tempPassions.addAll(destinations.get(1).passions);
		maxPassions = tempPassions.size();
		tempPassions.removeAll(guestPassions);
		maxPassions = maxPassions - tempPassions.size();
		secondMaxpassions = maxPassions;

		for (Destination destination1 : destinations) {
			for (Destination destination2 : shadowList) {
				if (destination1.equals(destination2)) {
					continue;
				}
				tempPassions.clear();
				tempPassions.addAll(destination1.passions);
				tempPassions.addAll(destination2.passions);
				int tempMaxpassions = tempPassions.size();
				tempPassions.removeAll(guestPassions);
				int matchedPassions = tempMaxpassions - tempPassions.size();

				if (matchedPassions >= maxPassions) {
					secondMaxpassions = maxPassions;
					maxPassions = matchedPassions;
					selectedDestinations1 = new SelectedDestinations(
														destination1,
														destination2);
				} else if (matchedPassions > secondMaxpassions) {
					secondMaxpassions = matchedPassions;
					selectedDestinations2 = new SelectedDestinations(
							destination1,
							destination2);
				}
			}
		}
		if (selectedDestinations2 != null) {
			if (selectedDestinations1.getDistanceBwDest() <
					selectedDestinations2.getDistanceBwDest()) {
				printNamesByOrder(selectedDestinations1.destination1.name
						, selectedDestinations1.destination2.name);

			} else {
				printNamesByOrder(selectedDestinations2.destination1.name
						, selectedDestinations2.destination2.name);

			}
			
			
		} else if (selectedDestinations1 != null){
			printNamesByOrder(selectedDestinations1.destination1.name
								, selectedDestinations1.destination2.name);
		}

		scanner.close();
	}
	
	private static void printNamesByOrder(String name1, String name2) {
		int compare = name1.compareToIgnoreCase(name2);
		if(compare < 0){
			System.out.println(name1 + " " + name2);
		} else {
			System.out.println(name2 + " " + name1);
		}
	}

	private static class Destination {
		String name;
		float lat;
		float lon;
		ArrayList<String> passions;

		Destination() {
			passions = new ArrayList<>();
		}

		@Override
		public boolean equals(Object obj) {
			return name.equals(((Destination) obj).name);
		}

		@Override
		public int hashCode() {
			return name.hashCode();
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return name;
		}
	}

	private static class SelectedDestinations {
		Destination destination1;
		Destination destination2;

		public SelectedDestinations(Destination destination1, Destination destination2) {
			this.destination1 = destination1;
			this.destination2 = destination2;
		}
		
		public double getDistanceBwDest() {
			return distance(destination1.lat, destination2.lat, destination1.lon, destination2.lon, 0.0, 0.0);
		}
	}

	private static double distance(double lat1, double lat2, double lon1, double lon2, double el1, double el2) {

		final int R = 6371; // Radius of the earth

		Double latDistance = Math.toRadians(lat2 - lat1);
		Double lonDistance = Math.toRadians(lon2 - lon1);
		Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // convert to meters

		double height = el1 - el2;

		distance = Math.pow(distance, 2) + Math.pow(height, 2);

		return Math.sqrt(distance);
	}
}

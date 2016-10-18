import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.stream.Stream;

public class VMWARE_IdentifyComments {
	public static void main(String[] args) {
		try {
			String line = "";
			String paragraph = "";
			String comments = "";
			boolean start_comment = false;
			

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(isr);
//			Stream<String> stream = bufferedReader.lines();
//			Iterator<String> iterator = stream.iterator();
//			while(iterator.hasNext()) {
//				System.out.println(iterator.next());
//			}
			do {
				line = bufferedReader.readLine();
				bufferedReader.lines();
				paragraph = paragraph + line + "\n";
			} while (!line.equals(""));
			isr.close();
			bufferedReader.close();
			System.out.println(paragraph);

		} catch (IOException ioException) {
			ioException.printStackTrace();
		}

	}
}

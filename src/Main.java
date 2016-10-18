import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	int a = 5;
	int com = 0xE_23D5_37;
	float pi = 3.14f;
	
	
	public static void main(String[] args) throws Exception{
		System.out.println("Hey");
//			try {
//				throw new EOFException();
//			} catch (IOException e) {
//				try {
//					throw e;
//				} catch (FileNotFoundException e2) {
//					
//				}
//			}
		
		try {
			if (.3 > .5) {
				throw new IOException("Cannot Copy File");
			} else {
				Exception ex = new Exception("Copy");
				System.out.println(ex.getMessage());
			}
		} catch(Exception e) {
			
		}
	}
}

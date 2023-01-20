package day04;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ReaderTest02 {

	public static void main(String[] args) {
		
		try(FileReader reader = new FileReader("test.txt"); PrintWriter pw = new PrintWriter("write.txt")) {
			int read = 0;
			char[] buffer = new char[256];
			while((read = reader.read(buffer)) != -1) {
				System.out.print(buffer);
				//pw.write(buffer);
				//pw.flush();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}

package day04;

import java.io.FileReader;
import java.io.IOException;

public class ReaderTest01 {

	public static void main(String[] args) {
		try(FileReader reader = new FileReader("test.txt")) {
			int read = 0;
			while((read = reader.read()) != -1) {
				System.out.print((char)read);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}

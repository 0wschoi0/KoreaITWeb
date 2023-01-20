package day04;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreamReaderTest {

	public static void main(String[] args) {
//		stream --> char 기반으로 변경
		FileInputStream fin = null;
		InputStreamReader is = null;
		
		try {
			fin = new FileInputStream("test.txt");
//			stream --> char
//			InputStreamReader(inputStream, char-set);
//			char-set을 주지 않는다면 시스템 환경에 따른 text-encoding 자동으로 부여.
//			encoding은 읽는 파일을 기준으로 맞춰서 써야함. 그렇지 않으면 Text가 깨질 수 있음.
			is = new InputStreamReader(fin, "UTF-8");
			
			int read = 0;
			while((read = is.read())!= -1) {
				System.out.print((char)read);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(is != null) {
					is.close();
				}
				if(fin != null) {
					fin.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}

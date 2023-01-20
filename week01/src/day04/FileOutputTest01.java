package day04;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputTest01 {

	public static void main(String[] args) {
		FileOutputStream fout = null;
		try {
			String str = "안녕하세요.";
//			FileOutputStream(파일을 포함한 경로, 덮어쓰기 기능 On/Off 기본은 Off) (true = 이어쓰기, false = 덮어쓰기.)
			fout = new FileOutputStream("write.txt", false);
			fout.write(97);
			fout.write("\n".getBytes());
			fout.write(str.getBytes());
			fout.write("\n".getBytes());
			fout.write('B'+ 1);
			System.out.println("파일 생성 완료.");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fout != null) {
					fout.close();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}

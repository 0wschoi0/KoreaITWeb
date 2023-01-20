package day03;

import java.io.*;

public class FileInputTest02 {

	public static void main(String[] args) throws IOException {
//		 파일을 읽어봅시다.
		FileInputStream fin = null;
		try{
			fin = new FileInputStream("test.txt");
			int read = 0;
			byte[] buffer = new byte[50];
//			-1은 문서의 마지막을 의미.
//			바이트 배열을 이용하여 파일을 읽을 수 있다.
//			read()와 같이 문장 끝에 다다르면 -1 리턴
//			buffer 배열에 읽은 데이터를 저장.
			while((read = fin.read(buffer)) != -1) {
//				배열, 시작, 읽은 개수.
//				읽은 개수를 배열의 길이 만큼하게 되면, 기존 배열을 덧쓰이게 된다.
				System.out.write(buffer, 0 , read);
				System.out.println();
				//System.out.print(new String(buffer, 0, read));
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fin != null) {
					fin.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}

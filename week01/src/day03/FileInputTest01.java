package day03;

import java.io.*;

public class FileInputTest01 {

	public static void main(String[] args) throws IOException {
//		 파일을 읽어봅시다.
		FileInputStream fin = null;
		try{
			fin = new FileInputStream("test.txt");
			int a;
//			-1은 문서의 마지막을 의미.
			while((a = fin.read()) != -1) {
//				문서를 byte 기반(정수, 아스키코드표에 의한 치환)으로 읽어드려서
//				출력할 때 다시 문자형으로 강제형변환(아스키 코드표에 의한 변환)
				//System.out.print(Character.toChars(a));
				System.out.print((char)a);
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

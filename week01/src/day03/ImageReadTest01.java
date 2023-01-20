package day03;

import java.io.*;

public class ImageReadTest01 {

	public static void main(String[] args) throws IOException {
//		 파일을 읽어봅시다.
		FileInputStream fin = null;
		try{
			fin = new FileInputStream("images.jpeg");
			int read = 0;
//			이미지 읽기 전 시작 시간 
			long startTime = System.currentTimeMillis(); // 현재시간을 1/1000초 단위로 나타냄.
			while((read = fin.read()) != -1) {
				// 이미지 읽
				
			}
//			이미지 읽은 후 종료 시간 
			long endTime = System.currentTimeMillis();  // 현재시간을 1/1000초 단위로 나타냄.
			double term = (double)(endTime - startTime) / 1000;
			System.out.println("걸린 시간: " + term + "초.");
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

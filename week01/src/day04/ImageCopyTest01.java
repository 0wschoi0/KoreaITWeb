package day04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCopyTest01 {

	public static void main(String[] args) {
		FileInputStream fin = null;
		FileOutputStream fout = null;
		
		try {
			fin = new FileInputStream("images.jpeg");
			fout = new FileOutputStream("imagesCopied.jpeg", false);
			int read = 0;
			//int able = 0;
			byte[] able = new byte[fin.available()];
			long start = System.currentTimeMillis();
			//while((able = fin.read()) != -1) {
			while((read = fin.read(able)) != -1) {
				fout.write(able, 0, read);
			}
			double term = (double)(System.currentTimeMillis() - start) / 1000;
			System.out.println("걸린 시간: "+term+"초.");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
//				1개 이상의 IO를 닫을 때에는 나중에 만든 것부터 닫는게 좋다.
				if(fout != null) {
					fout.close();
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

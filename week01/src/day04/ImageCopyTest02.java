package day04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCopyTest02 {

	public static void main(String[] args) {
//		기반스트림 
		FileInputStream fin = null;
		FileOutputStream fout = null;
//		보조스트림 
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		
		try {
			fin = new FileInputStream("images.jpeg");
			fout = new FileOutputStream("imagesCopied.jpeg", false);
			bin = new BufferedInputStream(fin);
			bout = new BufferedOutputStream(fout);
			
			int read = 0;
			
			long start = System.currentTimeMillis();
			while((read = bin.read()) != -1) {
				bout.write(read);
			}
			double term = (double)(System.currentTimeMillis() - start) / 1000;
			System.out.println("걸린 시간: "+term+"초.");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
//				1개 이상의 IO를 닫을 때에는 나중에 만든 것부터 닫는게 좋다.
				if(bout != null) {
					bout.close();
				}
				if(bin != null) {
					bin.close();
				}
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

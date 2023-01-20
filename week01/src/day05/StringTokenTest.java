package day05;

import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class StringTokenTest {
	public static void main (String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("stdinfo.txt");
			br = new BufferedReader(fr);
			
//			String string = "오늘 날씨";
//			string += "는 춥습니다.";
			
//			문자열 결합할때 메모리의 소요를 줄이기 위한 기능.
			StringBuilder sb = new StringBuilder();
			String str = "";
//			BufferedReader 보조스트림은 char 기반이기 때문에
//			버퍼(가상메모리)를 이용하여 문장을 읽는다.
//			따라서 라인단위로 저장해서 가져올 수 있다.
//			라인단위로 문장을 읽어올 수 있다.
			while((str = br.readLine())!= null) {
				//문장 결합 append().
				sb.append(str+"/n");
			}
			System.out.println(sb.toString());
			
//			split을 이용해서 자르기
			String[] stArr = sb.toString().split("/n");
			for(String i : stArr) System.out.println(i);
//			StringTokenizer
			for(String i : stArr) {
				String sentence = i;
//				StringTokenizer(자를 문자, delimiter, 자른 문자 포함여부 - 기본은 미포함 (false)).
//				delimiter는 한문장이 아니라 각각 문장을 자르는 기준이다.
				StringTokenizer token = new StringTokenizer(sentence, ",#!", false);
				
//				자른 문장이 존재하는지
				while(token.hasMoreElements()) {
//					잘린 문장을 출력 nextToken
//					단점: 모두 문자이기 때문에 숫자형은 형변환해서 사용해야함.
					System.out.print(token.nextToken() + " ");
				}
				System.out.println();
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try {
				if(br != null) {
					br.close();
				}
				if(fr != null) {
					fr.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}

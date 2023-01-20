package kr.app.store;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import kr.app.data.Student;
/*
 * 파일을 읽거나 쓴다.
 * */
public class FileStore {
	/*
	 * 파일로부터 학생데이터 읽어오기
	 * */
	public List<Student> getStdInfo(){
		FileReader reader = null;
		BufferedReader bf = null;
		List<Student> list = new ArrayList<>();
		
		try {
			reader = new FileReader("std_info.txt");
			bf = new BufferedReader(reader);
			
			String str = "";
			while((str = bf.readLine()) != null) {
				//데이터를 저장할 학생 객체 선언.
				Student st = new Student();
				// 콤마를 기준으로 데이터를 자르기.
				StringTokenizer token = new StringTokenizer(str, ",");
				//한줄 데이터를 잘라서 각각 넣어주기.
				while(token.hasMoreElements()) {
					//첫번째 학생번호
					st.setStdId(Integer.parseInt(token.nextToken()));
					st.setStName(token.nextToken());
					st.setKor(Integer.parseInt(token.nextToken()));
					st.setEng(Integer.parseInt(token.nextToken()));
					st.setMath(Integer.parseInt(token.nextToken()));
				}
				//학생 데이터 리스트에 저장.
				list.add(st);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			
			try {
				// 버퍼 닫기
				if(bf != null) {
					bf.close();
				}
				if(reader != null) {
					reader.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int addStudent(Student st) {
		// 결과를 리턴할 변수
		int result = -1;
		// 객체가 null이면 그냥 리턴 
		if(st == null) {
			return result;
		}
		// 파일을 읽을 객체 선언
		// true: 이어쓰기 ON
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("std_info.txt", true))){
			// 기본정보 뒤에 붙이기 위해 쓴다.
			bw.newLine();
			bw.append(st.getStdId() + ",");
			bw.append(st.getStName() + ",");
			bw.append(st.getKor() + ",");
			bw.append(st.getEng() + ",");
			// String만 가능해서 문장으로 치환해준다.
			bw.append(String.valueOf(st.getMath()));
			result = 200;
			
		}catch(IOException e){
			result = 500;
			e.printStackTrace();
		}
		return result;
	}
}

package kr.app.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import kr.app.data.Student;
import kr.app.store.FileStore;
/* 
 * 실제 기능을 구현하는 클래스
 * */

public class StdService {
	private Scanner scan;
	private FileStore store;
	
	public StdService() {
		scan = new Scanner(System.in);
		store = new FileStore();
	}
	public void start() {
		/*
		 * 기능 시작 메소드 
		 * */
		System.out.println("****************************");
		System.out.println("*                          *");
		System.out.println("*        학생관리프로그램      *");
		System.out.println("*                          *");
		System.out.println("****************************");
		this.play();
		
	}
	/*
	 * 실제 프로그램 플레이 
	 * */
	private void play() {
		while(true) {
			int choice = menu();
			
			switch(choice) {
			case 1:
				this.getStdInfo();
				break;
			case 2:
				this.addStudent();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				scan.close();
				System.exit(0);
			default:
				System.out.println("없는 메뉴입니다. 다시 선택하세요.");
				break;
			}
		}
	}
	// 메뉴 선택 기능.
	public int menu() {
		int choice = 0;
		try {
			System.out.print("1. 학생 정보 출력 ");
			System.out.print("2. 학생 정보 등록 ");
			System.out.print("3. 프로그램 종료 ");
			choice = scan.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("입력이 잘못되었습니다.");
			scan.nextLine();
		}
		return choice;
	}
	
	// 저장된 학생정보 출력 
	private void getStdInfo(){
		List<Student> list = store.getStdInfo();
		for(Student i : list) {
			// System.out.println(i.toString());
			// 학생 클래스에서 toString()을 override해서 자동으로 출력.
			System.out.println(i);
		}
	}
	private void addStudent() {
		Student st = new Student();
		//기존 학생 정보를 불러온다.
		List<Student> list = store.getStdInfo();
		try {
			System.out.println("학생의 학번을 입력하세요: ");
			st.setStdId(scan.nextInt());
			if(list.contains(st)) {
				System.out.println("이미 등록된 학번입니다.");
			}else {
				System.out.println("학생의 이름을 입력하세요.");
				st.setStName(scan.next());
				System.out.println("학생의 국어점수를 입력하세요.");
				st.setKor(scan.nextInt());
				System.out.println("학생의 영어점수를 입력하세요.");
				st.setEng(scan.nextInt());
				System.out.println("학생의 수학점수를 입력하세요.");
				st.setMath(scan.nextInt());
				
				int result = store.addStudent(st);
				if(result == 200) {
					System.out.println("등록이 성공하였습니다.");
				}else {
					System.out.println("등록이 실패하였습니다. 실패코드: " + result);
				}
			}
			
		}catch(InputMismatchException e) {
			System.out.println("입력이 잘못되었습니다.");
			scan.nextLine();
			e.printStackTrace();
		}
	}
}

package day05;

import java.util.ArrayList;
import java.util.List;

public class CallByTest {
//	일반변수를 파라미터로 하는 메서드.
	public static void add (int x) {
		++x;
	}
//	일반변수를 return 해주는 메서드.
	public static int minus (int x) {
		return --x;
	}
//	객체타입을 파라미터로 하는 메서드.
	public static void addList(List<Integer> list) {
		list.add(10);
	}
	
	public static void main(String[] args) {
		int num = 10;
		List<Integer> examList = new ArrayList<>();
		examList.add(1);
		examList.add(5);
//		메소드 호출 전.
		System.out.println("메소드 호출 전 값: " + num);
		System.out.println("메소드 호출 전 값: " + examList);
		
//		메소드 호출
		CallByTest.add(num);
		CallByTest.addList(examList);
		
//		메소드 호출 후.
		System.out.println("메소드 호출 후 값: " + num);
		System.out.println("메소드 호출 후 값: " + examList);
		
//		추가 메소드 호출 및 결과
		num = CallByTest.minus(num);
		System.out.println("메소드 호출 후 값: " + num);
		
	}

}

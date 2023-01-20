package day01;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Exception03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		try {
			int result = 0;
			System.out.println("숫자 입력: ");
			int val = scan.nextInt();
			result = 100 / val;
			System.out.println("결과: " + result);
		}catch(ArithmeticException e) {
			System.out.println("나눌 수 없습니다.");
		}catch(InputMismatchException e) {
			System.out.println("입력 양식이 잘못되었습니다.");
		}finally {
			System.out.println("예외와 상관없이 실행");
			if(scan != null) {
				scan.close();
			}
		}
		System.out.println("종료.");
	}

}

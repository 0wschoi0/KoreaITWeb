package day01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception01 {

	public static void main(String[] args) {
		int result = 0;
		try (Scanner scan = new Scanner(System.in)) {
			try {
				System.out.println("나눌 숫자 입력: ");
				int val = scan.nextInt();
				result = 10 / val;
				System.out.println("결과: "+ result);
			} catch (ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다.");
			} catch (InputMismatchException e) {
				System.out.println("오류");
			}
		}
		
	}
}

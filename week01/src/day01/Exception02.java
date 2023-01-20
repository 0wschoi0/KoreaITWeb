package day01;

import java.util.Scanner;

public class Exception02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = 0;
		try (Scanner scan = new Scanner(System.in)) {
			try {
				System.out.println("나눌 숫자 입력: ");
				int val = scan.nextInt();
				result = 10 / val;
				System.out.println("결과: "+ result);
			} catch (Exception e) {
				System.out.println("Error: " + e.getClass().getName());
			}
		}
	}
}

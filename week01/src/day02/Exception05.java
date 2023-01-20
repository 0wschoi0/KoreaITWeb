package day02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception05 {

	public static void main(String[] args) {
//		문법적 또는 알고리즘에서의 예외가 아니라,
//		프로그램 규칙상에 발생하는 예외일 경우, 사용자가
//		임의로 예외를 발생 시킬 수 있다.
//		단, 외부가 try-catch 영역이어야 한다.
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("곱하기 할 숫자를 입력하세요: ");
			int gu = scan.nextInt();
			
			if(gu < 1 || gu > 9) {
//				프로그램 규칙 상 원하는 숫자표현이 아님... 하지만 문법적으로 문제가 없음
//				이럴 때 사용자가 임의로 예외를 발생시킨다.
				throw new InputMismatchException("구구단의 허용범위를 넘습니다.");
			}
			for(int i = 1; i < 10; i++) {
				System.out.println(gu + "X" + i + "=" + (gu*i));
			}
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage() == null ? "입력 오류!" : e.getMessage());
		}finally {
			System.out.println("===구구단 종료===");
			scan.close();
		}
		System.out.println("프로그램 종료");
	}

}

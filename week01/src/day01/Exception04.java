package day01;

import java.util.InputMismatchException;

public class Exception04 {
// 	메서드에서 기능을 처리할 때 발생한 예외를
//	직접 처리하지 않고, 호출한 쪽에서 처리하도록 하는 기술이 예외 던지기.
//	throws 던질 예외1, 예외2...
//	예외는 여러개 발생할 수 있기 때문에 던질 때에도 여러 개 던질 수 있다.
	public int devide (int x, int y) throws ArithmeticException, InputMismatchException {
		
		return x/y;
	}
	public static void main(String[] args) {
		Exception04 ex4 = new Exception04();
//	예외 던지기 처리된 메서드를 호출 할 때에는
//	호출한 쪽에서 try-catch 구문으로 예외를 처리해야한다.
		try {
			int result = ex4.devide(10, 0);
			System.out.println("결과: "+ result);
		}catch(ArithmeticException e) {
			System.out.println("나누기 에러");
		}catch(InputMismatchException e) {
			System.out.println("입력 에러");
		}
		
	}

}

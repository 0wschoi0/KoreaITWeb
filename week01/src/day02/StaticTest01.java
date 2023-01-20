package day02;

public class StaticTest01 {

	public int add(int x, int y) {
		return x + y;
	}
	
	public static int minus(int x, int y) {
		return x - y;
	}
	
//	상수는 자주 사용되는 변수 중에 값이 선언된 뒤 바뀌지 않아야 할 변수의 선언을 말한다.
//	static과 final 기호를 붙여서 공유하되 변경되지 않는 변수를 만드는데
//	이를 상수(항상 같은 자리에 같은 값으로 존재하는 수)라고 말한다.
//	상수는 표현상으로 알아볼 수 있도록 변수명을 모두 대문자로 표기한다.
//	변수명을 모두 대문자로 표기하기 때문에 음절의 분리를 알아보기 쉽게 하기 위해서
//	카멜식 대신에 언더스코어 또는 스네이크 라고 불리는 방법으로 음절의 구분을 언더바(_)로 표기한다.
//	superman (카멜식) --> superMan
//	superman (언더스코어) --> super_man
	
	public static final double PI = 3.14;
	public double PI2 = 3.14;
	
	public static void main(String[] args) {
		StaticTest01 test = new StaticTest01();
		
		int addResult = test.add(10, 11);
//		int minusResultTempt = test.minus(10, 2);
		int minusResult = StaticTest01.minus(10, 2);
//		PI = 3.11;
		System.out.println(addResult);
		System.out.println(minusResult);
		
	}

}

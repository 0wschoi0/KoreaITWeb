package kr.app.data;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
 * 학생정보를 담는 데이터 클래스
 * */
public class Student {
	private int stdId;
	private String stName;
	private int kor;
	private int eng;
	private int math;
	
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	// hashcode와 equals를 override하여 객체비교 가능하도록 함.
	
	@Override
	public int hashCode() {
		return this.stdId;
	}
	@Override
	public boolean equals(Object o) {
		boolean isEqual = false;
		
		if(o == null) return isEqual;
		
		if(o instanceof Student) {
			if(this.stdId == ((Student)o).getStdId()) {
				isEqual = true;
			}
		}
		return isEqual;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("학번: "+this.getStdId()+" ");
		sb.append("이름: "+this.getStName()+" ");
		sb.append("국어: "+this.getKor()+" ");
		sb.append("영어: "+this.getEng()+" ");
		sb.append("수학: "+this.getMath()+" ");
		sb.append("평균: "+this.getAvg()+" ");
		sb.append("총점: "+this.getTotal()+" ");
		
		return sb.toString();
	}
	
	//총점 구하기
	public int getTotal() {
		return this.getKor() + this.getEng() + this.getMath();
	}
	//평균 구하기 
	public double getAvg() {
		return new BigDecimal((double)this.getTotal()/3).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	
}
// 수정 및 삭제 숙제 
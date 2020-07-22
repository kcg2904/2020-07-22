package main;

import db.DBClass;
import dto.FoodTB;

public class MainClass {
	public static void main(String[] args) {
		// food_tb 라는 이름으로 DB에 테이블이 만들어져 있고
		// food_tb 에 음식 이름과 가격을 넣어아햠
		
		// 사용자에게 음식이름과 가격을 입력받는 기능
		// 입력 받은 데이터를 테이블에 넣는 기능
		// 데이터를 보여주는 기능
		System.out.println("Hello DB");
		SubClass sub = new SubClass();
		FoodTB dto = sub.input();
		
		System.out.println("음식 : " + dto.getFoodname());
		System.out.println("가격 : " + dto.getPrice());
		//자바 와 디비 연결
		//입력 받은 데이터를 테이블에 넣는 기능
		//테이블의 데이터를 보여주는 기능
//		DBClass.conTest();
//		DBClass.insert(dto.getFoodname(), dto.getPrice());
//		DBClass.select();
	}
}

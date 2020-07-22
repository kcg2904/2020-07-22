package main;

import java.util.Scanner;

import dto.FoodTB;

public class SubClass {
	public FoodTB input() {
		Scanner san = new Scanner(System.in);
		System.out.print("음식이름을 입력하세요 > ");
		String a = san.next();
		System.out.print("음식가격을 입력하세요 > ");
		int b = san.nextInt();
		FoodTB dto = new FoodTB();
		dto.setFoodname(a);
		dto.setPrice(b);
		return dto;
	}
	// 가격을 전달 하는 메소드
//	public int price() {		
//		Scanner san = new Scanner(System.in);
//		System.out.println("가격을 입력하세요 > ");
//		int price = san.nextInt();
//		return price;
//	}
//	// 음식을 전달 하는 메소드
//	public String foodname() {		
//		Scanner san = new Scanner(System.in);
//		System.out.println("음식 이름을 입력하세요 > ");
//		String food = san.next();
//		return food;
//	}
}

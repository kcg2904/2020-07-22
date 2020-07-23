package dalin;

import java.util.Scanner;

import db.Thedeldb;

public class MainClass {
	public static void main(String[] args) {
		SubClass start = new SubClass();
		for (;;) {
			System.out.print("문제 수 정하기 > ");
			try {
			Scanner scan = new Scanner(System.in);
			int a = scan.nextInt();
			start.SubClass(a);
			}catch (Exception e) {
				System.out.println("잘못 입력하셨습니다. 숫자를 입력해주세요");
			}
		}
	}
}

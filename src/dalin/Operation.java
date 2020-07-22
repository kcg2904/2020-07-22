package dalin;

import java.util.ArrayList;
import java.util.Scanner;

import db.Thedeldb;
import dto.ThedelTB;

public class Operation {
	Scanner scan;
	public Operation() {
		scan = new Scanner(System.in);
	}
	
	public static ArrayList<Integer> get() {
		SetNum sn = new SetNum();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a = sn.setNumList();
		Thedeldb.insert(a.get(0), a.get(1));
		return a;
	}
	public int intScan() {
		for (;;) {
			try {
				int intNum = scan.nextInt();
				return intNum;
			} catch (Exception e) {
				System.out.print("잘못 입력하셨습니다. 다시 입력하세요 > ");
			}
		}
	}
	public ThedelTB id() {
		ThedelTB tb = new ThedelTB();
		System.out.print("아이디를 입력하세요 > ");
		String id = scan.next();
		tb.setId(id);
		
		return tb;
	}
	public int opScan() {
		for (;;) {
			try {
				System.out.print("1. 더하기 2. 빼기 3. 곱하기 4. 나누기 0. 종료 > ");
				int op = scan.nextInt();
				return op;
			} catch (Exception e) {
				System.out.println("잘못된 선택지를 입력하셨습니다. 다시입력하세요");
			}
		}
	}

	public int getSum() {
		ArrayList<Integer> a = Operation.get();
		System.out.print(a.get(0) + " 와 " + a.get(1) + "를 더한 값은 ? > ");
		return a.get(0) + a.get(1);
	}

	public int getMul() {
		ArrayList<Integer> a = Operation.get();
		System.out.print(a.get(0) + " 와 " + a.get(1) + "를 곱한 값은 ? > ");
		return a.get(0) * a.get(1);
	}

	public int getDiv() {
		ArrayList<Integer> a = Operation.get();
		for (;;) {
			if (ddul(a.get(0), a.get(1))) {
				break;
			}
			else {
				a = Operation.get();
			}
		}
		System.out.print(a.get(0) + " 와 " + a.get(1) + "를 나눈 값은 ? > ");
		return a.get(0)/a.get(1);
	}

	public int getSub() {
		ArrayList<Integer> a = Operation.get();
		for (;;) {
			if (ddul(a.get(0), a.get(1))) {
				break;
			} else {
				a = Operation.get();
			}
		}
		return a.get(0) - a.get(1);
	}
	public boolean ddul(int a, int b) {
		if (a % b == 0) {
			return true;
		} else {
			return false;
		}
	}
}

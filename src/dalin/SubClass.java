package dalin;

import db.Thedeldb;
import dto.ThedelTB;

public class SubClass extends MainClass {
	public void SubClass(int a) {
		Try try1 = new Try();
		int[][] b = new int[3][a];
		b = try1.Try(a);
			for (int i = 0; i < b[0].length; i++) {
				System.out.println((i + 1) + "번째 문제의 답 : " + b[0][i]);
			}
			Operation op = new Operation();
			ThedelTB TB = op.id();
			String id = Thedeldb.select(TB.getId());
			int hapdb = Thedeldb.ps(TB.getId());
			System.out.println("내가 맞춘 문제의 수 : " + b[2][0]);
			System.out.println("내가 틀린 문제의 수 : " + (b[0].length - b[2][0]));
			hapdb = hapdb + b[2][0];
			int point = Thedeldb.userselect(id);
			if (id != null) {
				// 조건
				Thedeldb.update(hapdb, id);
				System.out.println("나의 누적 점수 : " + point);
			}else {
				System.out.println("없는 아이디 입니다.");
			}
			
	}
}

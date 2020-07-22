package dalin;

import java.util.ArrayList;

import db.Thedeldb;

public class Try  {
	public int[][] Try(int a) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		ArrayList<Integer> listb = new ArrayList<Integer>();
		ArrayList<Boolean> listc = new ArrayList<Boolean>();
		int[][] b = new int[3][a];
		Operation op = new Operation();
		int Snop = op.opScan();
		Thedeldb.delret();
		for (int i = 1; i <= a; i++) {
			if (Snop == 1) {
				int ab = op.getSum(); 
				int num = op.intScan();
				lista.add(ab);
				listb.add(num);
				if (ab == num) {
					listc.add(true);
				} else {
					listc.add(false);
				}
			} else if (Snop == 2) {
				int ab = op.getSub(); 
				int num = op.intScan();
				lista.add(ab);
				listb.add(num);
				if (ab == num) {
					listc.add(true);
				} else {
					listc.add(false);
				}
			} else if (Snop == 3) {
				int ab = op.getMul(); 
				int num = op.intScan();
				lista.add(ab);
				listb.add(num);
				if (ab == num) {
					listc.add(true);
				} else {
					listc.add(false);
				}

			} else if (Snop == 4) {
				int ab = op.getDiv(); 
				int num = op.intScan();
				lista.add(ab);
				listb.add(num);
				if (ab == num) {
					listc.add(true);
				} else {
					listc.add(false);
				}
			} else {
				System.out.println("게임을 종료합니다.");
				System.exit(0);
			}
		}
		
		int hap = 0;
			for (int i = 0; i < a; i++) {
				if (listc.get(i) == true) {
					hap = hap + 1;
				}
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < lista.size(); j++) {
					if (i == 0) {
						b[i][j] = lista.get(j);
					} else if (i == 1) {
						b[i][j] = listb.get(j);
					} else if (i == 2) {
						b[i][0] = hap;
						b[i][1] = hap;
					}
				}
			}

		return b;
	}
}

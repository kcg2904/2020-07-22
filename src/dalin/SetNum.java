package dalin;

import java.util.ArrayList;
import java.util.Random;

import db.Thedeldb;

public class SetNum {
	public ArrayList<Integer> setNumList() {
		ArrayList<Integer> a = new ArrayList<Integer>();
		Random rand = new Random();
		a.add(rand.nextInt(89)+10);
		a.add(rand.nextInt(89)+10);
		return a;
	}
}

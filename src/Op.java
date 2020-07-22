import java.util.Scanner;

public class Op {
	Scanner scan;
	NumVO nv;
	public Op() {
		scan = new Scanner(System.in);
		nv = new NumVO();
	}
	public void a() {
		System.out.print("돈들어간다 > ");
		int scana = scan.nextInt();
		nv.setA(scana);
	}
	public void b() {
		int b = nv.getA() * 10;
		nv.setB(b);
		System.out.println("돈이 10배가 되었다! " + b);
	}
	public void c() {
		int c = nv.getB();
		for(;;) {
		if (c<=0) {
			break;
		}else {
			System.out.print("1. 밥먹기 2.택시타기 3.피씨방가기 4. 노래방가기");
			int rand = scan.nextInt();
			if (rand == 1) {
				System.out.println("밥을 먹었다 밥값 : 5000원");
				c = nv.getB() - 5000;
				nv.setB(c);
			}else if (rand == 2) {
				System.out.println("택시를 탔다 택시값 : 3000원");
				c = nv.getB() - 3300;
				nv.setB(c);
			}else if (rand == 3) {
				System.out.println("피씨방을 갔다 ? 피씨방값 : 10000원");
				c = nv.getB() - 10000;
				nv.setB(c);
			}else if (rand == 4) {
				System.out.println("노래방을 갔다 노래방값 : 2000원");
				c = nv.getB() - 2000;
				nv.setB(c);
			}
		}
		}
		System.out.println("돈이 오버 되버렸습니다. 남은 돈 : " + nv.getB());
	}
}

package zombie;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	Random rn = new Random();
	Scanner sc = new Scanner(System.in);
	private Game() {}
	private static Game instance = new Game();
	public static Game getInstance() {return instance;}
	private Hero h;
	private ArrayList<Unit> enemy = new ArrayList<>();
	
	private void init() {
		h = new Hero("���", 100 , 5, 1, 1);
	}
	
	
	private int chk() {
		for(int i=0; i<enemy.size(); i++) {
			if(h.getPos() == enemy.get(i).getPos()) {
				System.out.println("���� ��Ÿ����!!!");
				return i;
			}
		}
		return -1;
	}
	
	private int die(Unit attack) {
		if(h.getHp()<=0) {
			return 1;
		}
		else if(attack.getHp()<=0) {
			return 2;
		}
		else {
			return 0;
		}
	}
	
	private boolean fight(Unit enemy) {
		while(true) {
			h.print();
			System.out.println("===========VS===========");
			enemy.print();
			System.out.println("[������ �ұ�? ]");
			System.out.printf("1.����\t2.���� %d�� ����\n",h.getCnt());
			int sel = sc.nextInt();
			if(sel==1) {
				h.attack(enemy);
			}
			else if(sel==2) {}
			if(die(enemy)!=0) {
				break;
			}
			System.out.println();
			enemy.attack(h);
			if(die(enemy)!=0) {
				break;
			}
			System.out.println();
		}
			if(die(enemy)==1) {
				System.out.println("����ߴ�....");
			    return false;
			}
			else {
				System.out.println("�¸��ߴ�!");
				return true;
			}
		}
	
	public void map(int a) {
		System.out.println("[���� ���� : "+h.getPos()+" ]");
		System.out.println("[1]: �±��Ѵ�.");
		if(a==1) {
			System.out.println("[2]: ü���� ȸ���Ѵ�.");
			System.out.println("[3]: ���⸦ ��ȭ�Ѵ�.");
		}
	}
	
	public void run() {
		init();
		int act =1;
		while(true) {
			if(h.getPos() >=12) {
				System.out.println("������ �����ߴ�!");
			    break;
			}
			map(act);
			int sel = sc.nextInt();
			if(sel==1) {
				h.setPos(h.getPos()+1);
				int chk = chk();
				if(chk !=-1) {
					boolean a = fight(enemy.get(chk));
					if(a==false) {
						break;
					}
				}
				else {
					System.out.println("�ƹ��ϵ� �Ͼ�� �ʾҴ�.");
				}
				act = 1;
			}
			else if(sel==2 && act == 1) {
				int rnum = rn.nextInt(40)+20;
				h.setHp(h.getHp()+rnum);
				System.out.printf("ü���� %d��ŭ ȸ���ߴ�!",rnum);
				act = 2;
			}
			else if(sel==3 && act == 1) {
				int rnum = rn.nextInt(2)+1;
				if(rnum ==1) {
					rnum = rn.nextInt(3)+1;
					h.setAtt(h.getAtt()+rnum);
					System.out.printf("���ݷ��� %d��ŭ �����ߴ�!",rnum);
				}
				else if(rnum==2) {
					rnum = rn.nextInt(3)+1;
					h.setDef(h.getDef()+rnum);
					System.out.printf("������ %d��ŭ �����ߴ�!",rnum);
				}
			}
		}
	}

}

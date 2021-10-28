package game;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	
	Vector<Player> playerList = new Vector<>();
	Vector<Unit> monList = new Vector<>();
	String path = "game"; // ��Ű���� �̸� ����
	String mons[] = {"UnitWolf","UnitBat","UnitOrc"};
	
	public UnitManager() {
		// name max power
		playerList.add(new Player("����",1000,45));
		playerList.add(new Player("������",800,60));
		playerList.add(new Player("����",500,70));
	}
		
	// ���� ������ �޾Ƽ� ���� ���� 
	public void monsterRnSet(int size) {
		for(int i = 0; i<size; i++) {
			int num = GameManager.rn.nextInt(mons.length);
			try {
				// Ŭ������ �𸦶� 
				Class<?> clazz = Class.forName(path + mons[num]);
				Object obj = clazz.newInstance();
				Unit temp = (Unit)obj;
				int hp = rn.nextInt(100)+100;
				int power = rn.nextInt(10)+10;
				temp.init(hp, power);
				monList.add(temp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

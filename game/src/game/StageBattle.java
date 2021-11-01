package game;

import java.util.Random;
import java.util.Vector;

public class StageBattle extends Stage{
	UnitManager um = new UnitManager();
	 Vector <Player> playerList = null;
	 Vector <Unit> monList = null;
	private int monDead = 0;
	private int playerDead = 0;
	Random rn = new Random();
	
	

	@Override
	public void init() {
		um.monList.clear(); 
		um.monsterRnSet(4);
		playerList = null;
		playerList = um.playerList;
		monList=null;
		monList = um.monList;
		monDead = monList.size();
		playerDead = playerList.size();
	}
	
	public void printChar() {
		System.out.println("===== [ BATTLE ] =====");
		System.out.println("===== [ PLAYER ] =====");
		for(int i = 0; i< playerList.size(); i++) {
			playerList.get(i).printData();
		}
		System.out.println("===== [ MONSTER ] =====");
		for(int i = 0; i< monList.size(); i++) {
			monList.get(i).printData();
		}
	}
	
	public void playerAtt(int index) {
		Player p = playerList.get(index);
		if(p.curhp <=0) return;
		System.out.println("===== [ 메뉴 선택 ] =====");
		System.out.printf("[ %s ] [ 1.어택 ] [ 2.스킬 ]",p.name);
		int sel = GameManager.sc.nextInt();
		if(sel == 1) {
			while(true) {
				int idx = rn.nextInt(monList.size()); // 무작위로 몬스터 고르기
				
				if(monList.get(idx).curhp > 0 ) { // 몬스터의 체력이 0 보다클때만 공격
					p.attack(monList.get(idx));
					break;
				}
			}
		}
		else if(sel==2) {
			// 스킬 구현 
		}
	}
	
	public void monsterAtt(int index) {
		Unit m = monList.get(index);
		if(m.curhp<=0) return;
		while(true) {
			int idx = rn.nextInt(playerList.size());
			if(playerList.get(idx).curhp > 0 ) {
				m.attack(playerList.get(idx));
				break;
			}
		}
	}
	
	public void check_live() {
		int num = 0;
		for(int i=0; i< playerList.size(); i++) {
			if(playerList.get(i).curhp <= 0) {
				num++;
			}
		}
		playerDead = playerList.size() - num;
		num = 0;
		for(int i=0; i< monList.size(); i++) {
			if(monList.get(i).curhp <= 0) {
				num ++;
			}
		}
		monDead = monList.size()-num;
	}
	
	@Override
	public boolean update() {
		boolean run = true;
		int pIdx = 0;
		int mIdx = 0;
		boolean turn = true;
		
		while(run) {
			if(turn) {
				printChar();
				if(pIdx < playerList.size()) { // pIdx가 playerList.size보다 작을경우
					playerAtt(pIdx);
					pIdx++;
				}else {
					turn =! turn;
					pIdx = 0;
				}
			}
			else if(!turn) {
				if(mIdx < monList.size()) {
					monsterAtt(mIdx);
					mIdx++;
				}else {
					turn =!turn;
					mIdx = 0;
				}
			}
			check_live();
			if(monDead <=0 || playerDead <=0) break;
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}

}

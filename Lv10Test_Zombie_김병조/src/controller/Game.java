package controller;

import java.util.ArrayList;
import java.util.Scanner;

import models.Player;
import models.Unit;
import models.Zombie;
import models.ZombieKing;

public class Game {
	private Scanner sc = new Scanner(System.in);
	private boolean isRun;
	private ArrayList<Unit> zombie = new ArrayList<>();
	private Player player;
	
	private static Game instance = new Game();
	public static Game getInstance() {
		return instance;
	}
	
	public void run() {
		// zombie set
		setGame();
		int play = 1;
		while(true) {
			if(player.getPos()>=15) {
				System.out.println("Game Clear");
				break;
			}
			map(play);
			int sel = sc.nextInt();
			if(sel==1) {
				System.out.println("Level up!");
				player.setPos(player.getPos()+1);
				int check = checkZombie();
				if(check != -1) {
					boolean battle = battle(zombie.get(check));
					
					player.attack(zombie.get(check));
					if(die(zombie.get(check))!=0) {
						break;
					}
					if(!battle) {
						System.out.println("Player ���");
						break;
					}
				}
				else {
					System.out.println("�ƹ��ϵ� �Ͼ�� �ʾҴ�.");
				}
				play = 1;
			}
			else if(sel==2 && play ==1) {
				
			}
		}
	}
	
	private void setGame() {
		// name, maxHp, att, def, pos
		this.isRun = true;
		this.player = new Player("����",100,20,10,1);
		zombie.add(new Zombie("����",20,5,2,2));
		zombie.add(new Zombie("���ݽ� ����",40,10,3,4));
		zombie.add(new Zombie("���̽� ����",55,15,4,7));
		zombie.add(new ZombieKing("�����",100,30,4,15,50));
	}
	
	private int checkZombie() {
		for(int i=0; i<zombie.size(); i++) {
			if(player.getPos() == zombie.get(i).getPos()) {
				System.out.println("[���] ���� ���� !!");
				return i;
			}
		}
		return -1;
	}

	private int die(Unit unit) {
		if(player.getCurHp()<=0) {
			return 1;
		} else if(unit.getCurHp() <=0) {
			return 2;
		}else
			return 0;
	}
	
	private void map(int play) {
		System.out.println("[1] �ö󰣴�");
		if(play==1) {
			System.out.println("[2] ü�� ȸ��");
			System.out.println("[3] ���� ��ȭ");
		}
	}
	
	private boolean battle(Unit zombie) {
		while(true) {
			player.print();
			System.out.println("====== VS =======");
			zombie.print();
			System.out.printf("[1].����  [2].����(%d��)\n",this.player.getH());
			int sel = sc.nextInt();
			if(sel==1) {
				this.player.attack(zombie);
			}
			else if(sel==2) {
				player.getHeal();
				
			}
			if(die(zombie) == 1) {
				return false;
			}
			else {
				System.out.println("GAME CLEAR");
				return true;
			}
			
		}
	}
}

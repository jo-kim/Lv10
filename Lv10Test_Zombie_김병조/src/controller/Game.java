package controller;

import java.util.ArrayList;
import java.util.Scanner;

import models.Player;
import models.Unit;
import models.Zombie;
import models.ZombieKing;

public class Game {
	private Scanner sc = new Scanner(System.in);

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
		while (true) {
			if (player.getPos() >= 12) {
				System.out.println("[GAME CLEAR]");
				break;
			}
			map(play);
			System.out.print("선택 : ");
			String input = sc.next();
			int sel = Integer.parseInt(input);
			if (sel == 1) {
				player.setPos(player.getPos() + 1);
				int check = checkZombie();
				if (check != -1) {
					boolean bat = battle(this.zombie.get(check));
					if (bat == false)
						break;
				} else {
					System.out.println("아무일도 일어나지 않았다.");
				}
				play = 1;
			} else if (sel == 2 && play == 1) {
				int rnHp = Unit.rn.nextInt(40) + 20;
				if (rnHp + player.getCurHp() > player.getMaxHp()) {
					rnHp = player.getMaxHp() - player.getCurHp();
				}
				player.setCurHp(player.getCurHp() + rnHp);
				System.out.printf("체력 충전 %d↑↑\n", rnHp);
				play = 2;
			}
		}
	}

	private void setGame() {
		// name, maxHp, att, def, pos

		this.player = new Player("전사", 100, 20, 10, 1);
		zombie.add(new Zombie("약한좀비", 30, 15, 3, 2));
		zombie.add(new Zombie("조금쎈 좀비", 40, 16, 5, 6));
		zombie.add(new Zombie("많이쎈 좀비", 55, 21, 9, 10));
		zombie.add(new ZombieKing("좀비왕", 100, 30, 4, 12, 50));
	}

	private int checkZombie() {
		for (int i = 0; i < zombie.size(); i++) {
			if (player.getPos() == zombie.get(i).getPos()) {
				System.out.println("[경고] 좀비 출현 !!");
				return i;
			}
		}
		return -1;
	}

	private int die(Unit unit) {
		if (player.getCurHp() <= 0) {
			return 1;
		} else if (unit.getCurHp() <= 0) {
			return 2;
		} else
			return 0;
	}

	private void map(int play) {
		System.out.printf("[ 현재 레벨 : %d ]\n", this.player.getPos());
		System.out.println("[1].올라간다");
		if (play == 1) {
			System.out.println("[2].체력 회복");
		}
	}

	private boolean battle(Unit zombie) {
		while (true) {
			player.print();
			System.out.println("\n================ VS ================");
			zombie.print();
			System.out.printf("\n[1].공격  [2].물약(%d개)\n", this.player.getHeal());
			String input = sc.next();
			int sel = Integer.parseInt(input);
			if (sel == 1) {
				this.player.attack(zombie);
				if (zombie.getCurHp() > 0) {
					zombie.attack(player);

				} else {
					System.out.printf("[%s]를 제거하였다!\n", zombie.getName());
					break;
				}
			} else if (sel == 2) {
				player.heal(player);

			}
			if (die(zombie) != 0) {
				break;
			}
			System.out.println();
			zombie.attack(player);
		}

		if (die(zombie) == 1) {
			System.out.println("죽었ㄷ ㅏ....");
			return false;
		} else {
			System.out.println("Level Up !!");
			return true;
		}

	}

}

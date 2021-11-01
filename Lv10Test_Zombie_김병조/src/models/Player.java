package models;

interface Restorable {

}

public class Player extends Unit implements Restorable {
	private int heal = 3;

	public Player(String name, int maxHp, int att, int def, int pos) {
		super(name, maxHp, att, def, pos);
		// TODO Auto-generated constructor stub
	}

	public void heal(Restorable restorable) {
		Unit unit = (Unit) restorable;
		if (this.heal > 0) {
			System.out.println("체력이 회복되었습니다.");
			int hp = this.getCurHp() + 100;
			if (hp > this.getMaxHp())
				hp = this.getMaxHp();
			this.setCurHp(hp);
			System.out.printf("[%s]의 체력 : [%d/%d]\n", unit.getName(), unit.getCurHp(), unit.getMaxHp());
			this.heal--;
		} else {
			System.out.println("물약이 없습니다.");
		}
	}

	public int getHeal() {
		return this.heal;
	}

	@Override
	public void attack(Unit target) {
		if (target instanceof ZombieKing) {
			if (((ZombieKing) target).getShield() > 0) {
				System.out.printf("[%s]의 공격!\n", this.getName());
				int damage = (this.getAtt() - target.getDef()) * (Unit.rn.nextInt(150) + 50) / 100;
				if (damage < 0)
					damage = 0;
				System.out.println("쉴드 공격!");
			//	System.out.printf("[%d]의 데미지를 입었다!\n", damage);
				((ZombieKing) target).setShield(((ZombieKing) target).getShield() - damage);

				if (((ZombieKing) target).getShield() <= 0) {
					System.out.println("쉴드가 산산조각 났다!");
					int hp = ((ZombieKing) target).getShield() + target.getCurHp();
					target.setCurHp(hp);
					System.out.printf("[%s의 남은 HP: %d]\n", target.getName(), target.getCurHp());
				}
			} else {
				super.attack(target);
			}
		} else {
			super.attack(target);
		}

	}

}

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
			System.out.println("ü���� ȸ���Ǿ����ϴ�.");
			int hp = this.getCurHp() + 100;
			if (hp > this.getMaxHp())
				hp = this.getMaxHp();
			this.setCurHp(hp);
			System.out.printf("[%s]�� ü�� : [%d/%d]\n", unit.getName(), unit.getCurHp(), unit.getMaxHp());
			this.heal--;
		} else {
			System.out.println("������ �����ϴ�.");
		}
	}

	public int getHeal() {
		return this.heal;
	}

	@Override
	public void attack(Unit target) {
		if (target instanceof ZombieKing) {
			if (((ZombieKing) target).getShield() > 0) {
				System.out.printf("[%s]�� ����!\n", this.getName());
				int damage = (this.getAtt() - target.getDef()) * (Unit.rn.nextInt(150) + 50) / 100;
				if (damage < 0)
					damage = 0;
				System.out.println("���� ����!");
			//	System.out.printf("[%d]�� �������� �Ծ���!\n", damage);
				((ZombieKing) target).setShield(((ZombieKing) target).getShield() - damage);

				if (((ZombieKing) target).getShield() <= 0) {
					System.out.println("���尡 ������� ����!");
					int hp = ((ZombieKing) target).getShield() + target.getCurHp();
					target.setCurHp(hp);
					System.out.printf("[%s�� ���� HP: %d]\n", target.getName(), target.getCurHp());
				}
			} else {
				super.attack(target);
			}
		} else {
			super.attack(target);
		}

	}

}

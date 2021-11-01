package models;

public class ZombieKing extends Unit {
	private int shield;

	public ZombieKing(String name, int maxHp, int att, int def, int pos, int shield) {
		super(name, maxHp, att, def, pos);
		this.shield = shield;
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	@Override
	public void attack(Unit target) {
		if (Unit.rn.nextInt(100) >= 74) {
			int damage = (this.getAtt() - target.getDef()) * (Unit.rn.nextInt(150) + 50) / 100;
			if (damage <= 0)
				damage = 0;
			System.out.printf("[%s] 의 공격\n", this.getName());
			System.out.printf("[%d] 의 데미지를 입혔습니다!\n", damage);
			target.setCurHp(target.getCurHp() - damage);
			System.out.printf("[%s] 의 남은 체력 : [%d/%d]\n", target.getName(), target.getCurHp(), target.getMaxHp());

		} else {
			super.attack(target);
		}
	}

}

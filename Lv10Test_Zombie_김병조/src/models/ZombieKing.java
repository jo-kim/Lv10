package models;

import java.util.Random;

public class ZombieKing extends Unit implements Attackable{
	private int shield;
	public ZombieKing(String name, int maxHp, int att, int def, int pos,int shield) {
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
		Random rn = new Random();
		int damage = this.getAtt()-target.getDef() *(rn.nextInt(150)+50)/100;
		if(damage<=0) damage = 1;
		target.setCurHp(target.getCurHp()-damage);
		System.out.printf("[%s] ÀÇ ³²Àº Hp : [%d/%d]\n",target.getName(),target.getCurHp(),target.getMaxHp());
		
	}
	

}

package zombie;

public class ZombieKing extends Unit {
	
	private int shield;
	public ZombieKing(String name, int hp, int att, int def, int pos,int shield) {
		super(name, hp, att, def, pos);
		this.shield = shield;
	}
	
	public int getShield() {
		return shield;
	}
	
	public void setShield(int shield) {
		this.shield = shield;
	}
	public void attack(Unit target) {
		if(rn.nextInt(100)>74) {
			int dam = (this.getAtt() - target.getDef())*(rn.nextInt(150)+50)/100;
			if(dam<=0) {dam=1;}
			System.out.println(getName()+"�� �ʻ��!!!");
			System.out.println(dam+"�� ������");
			target.setHp(target.getHp()-dam);
			System.out.println(target.getName()+"�� ���� ü�� : "+ target.getHp());
		}
		else {
			super.attack(target);
		}
	}

	
}

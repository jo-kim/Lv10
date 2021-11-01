package models;

public class Player extends Unit implements Attackable{
	private int heal = 3;
	public Player(String name, int maxHp, int att, int def, int pos) {
		super(name, maxHp, att, def, pos);
		// TODO Auto-generated constructor stub
	}
	public void getHeal() {
		if(this.heal > 0 ) {
			int hp = this.getCurHp()+100;
			if(hp> this.getMaxHp()) hp = this.getMaxHp();
			this.setCurHp(hp);
			System.out.println("ü���� ȸ���Ǿ����ϴ�.");
			this.heal --; 
		}
		else {
			System.out.println("������ �����ϴ�.");
		}
	}
	
	public int getH() {
		return this.heal;
	}
	@Override
	public void attack(Unit target) {
		int damage = this.getAtt() - target.getDef() * (rn.nextInt(150)+50)/100;
		if(damage<=0) damage = 1;
		
		if(target instanceof ZombieKing) {
			if(((ZombieKing) target).getShield()>0) {
				((ZombieKing) target).setShield(((ZombieKing) target).getShield()-damage);
			}
			else {
				System.out.println("���带 �ı��߽��ϴ�.");
				target.setCurHp(target.getCurHp()-damage);
				System.out.printf("[%s] �� ���� Hp : [ %d/%d]\n",target.getName(),target.getCurHp(),target.getMaxHp());
			}
		}
		else {
			target.setCurHp(target.getCurHp()-damage);
		}
		
	}
	
	

}

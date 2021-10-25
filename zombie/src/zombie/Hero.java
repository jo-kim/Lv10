package zombie;

public class Hero extends Unit {
	
	private int cnt = 3; // ����
	public Hero(String name, int hp, int att, int def, int pos) {
		super(name, hp, att, def, pos);
		
	}
	public int getCnt() {
		return this.cnt;
	}
	
	public void drink() {
		if(cnt>0) {
			System.out.println("ȸ������ ���ʴϴ�.");
			System.out.println("ü���� 100ȸ�� �Ǿ����ϴ�.");
			this.setHp(this.getHp()+100);
			System.out.println(this.getName()+"�� ���� ü��: "+this.getHp());
			cnt--;
		}
		else {
			System.out.println("������ �����ϴ�.");
		}
	}
	
	public void attack(Unit target) {
		if(target instanceof ZombieKing) {
			if(((ZombieKing) target).getShield()>0) {
				int dam = (this.getAtt() - target.getDef())*(rn.nextInt(150)+50)/100;
				if(dam<=0) {dam=1;}
				System.out.println(getName()+"�� ����!");
				System.out.println(dam+"�� ������!!");
				((ZombieKing) target).setShield(((ZombieKing) target).getShield()-dam);
				if(((ZombieKing) target).getShield()<=0) {
					System.out.println(target.getName()+"�� ���尡 ��������!");
					((ZombieKing) target).setShield(0);
				}
				System.out.printf("%s�� ���� ü��: %d [���� : %d]\n",target.getName(),target.getHp(),((ZombieKing) target).getShield());
			}
			else {
				super.attack(target);
			}
		}
		else {
			super.attack(target);
		}
	}

}

package zombie;

import java.util.Random;

public abstract class Unit {
	// �ʿ��� ����� ����
	Random rn = new Random();
	private String name;
	private int hp;
	private int att;
	private int def;
	private int pos;
	
	interface Attack{
		public void attack(Unit target);
	}
	public String getName() {
		return this.name;
	}
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAtt() {
		return this.att;
	}
	public void setAtt(int att) {
		this.att = att;
	}
	public int getDef() {
		return this.def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getPos() {
		return this.pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	
	public Unit(String name, int hp, int att, int def, int pos) {
		this.name = name;
		this.hp = hp;
		this.att = att;
		this.def = def;
		this.pos = pos;
	}
	
	public void attack(Unit target) {
		int dam = (this.att - target.def)*(rn.nextInt(150)+50)/100;
		if(dam<=0) {dam=1;}
		System.out.println(name+"�� ����!");
		System.out.println(dam+"�� ����");
		target.setHp(target.getHp()-dam);
		System.out.println(target.name+"�� ���� ü�� : "+target.hp);

	}
	
	
	public void print() {
		System.out.printf("[�̸�] : %s \t [ü��] : %d\n",name,hp);
		System.out.printf("[���ݷ�] : %d \t [����] : %d \t [��ġ] : %d\n",att, def , pos);
	}
}

package zombie;

import java.util.Random;

public abstract class Unit {
	// 필요한 멤버들 저장
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
		System.out.println(name+"의 공격!");
		System.out.println(dam+"의 출혈");
		target.setHp(target.getHp()-dam);
		System.out.println(target.name+"의 남은 체력 : "+target.hp);

	}
	
	
	public void print() {
		System.out.printf("[이름] : %s \t [체력] : %d\n",name,hp);
		System.out.printf("[공격력] : %d \t [방어력] : %d \t [위치] : %d\n",att, def , pos);
	}
}

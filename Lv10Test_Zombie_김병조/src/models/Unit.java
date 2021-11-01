package models;

import java.util.Random;

public class Unit{
	
	private String name;
	private int curHp;
	private int maxHp;
	private int att;
	private int def;
	private int pos;
	public static Random rn = new Random();
	
	public Unit(String name, int maxHp, int att, int def, int pos) {
		this.name = name;
		this.curHp = maxHp;
		this.maxHp = maxHp;
		this.att = att;
		this.def = def;
		this.pos = pos;
	}
	
	public String getName() {
		return this.name;
	}
	public int getCurHp() {
		return this.curHp;
	}
	public void setCurHp(int curHp) {
		this.curHp = curHp;
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
	
	public int getMaxHp() {
		return this.maxHp;
	}

	
	public void print() {
		System.out.printf("[이름] : %s\t[체력] : %d/%d\n[공격력] : %d\t[방어력] : %d\t[위치] : %d"
				,this.name,this.curHp,this.maxHp,this.att,this.def,this.pos);
	}

}

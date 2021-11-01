package models;

import java.util.Random;

interface Attackable {
	public void attack(Unit target);
}

public abstract class Unit {

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
		System.out.printf("[�̸�] : %s\t[ü��] : %d/%d\n[���ݷ�] : %d\t[����] : %d\t[��ġ] : %d", this.name, this.curHp,
				this.maxHp, this.att, this.def, this.pos);
	}

	public void attack(Unit target) {
		int damage = this.att - target.def * (rn.nextInt(150) + 50) / 100;
		if (damage < 0)
			damage = 0;
		System.out.printf("[%s] �� ����\n", this.name);
		System.out.printf("[%d] �� �������� �������ϴ�!\n", damage);
		target.setCurHp(target.getCurHp() - damage);
		System.out.printf("[%s] �� ���� ü�� : [%d/%d]\n", target.getName(), target.getCurHp(), target.getMaxHp());
	}

}

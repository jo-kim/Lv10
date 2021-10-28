package game;

public abstract class Unit {
	int curhp;
	int maxhp;
	int power;
	String name;
	String state = "노말";
	public Unit() {}
	Unit(String na, int max, int pw){
		name = na;
		maxhp = max;
		curhp = max;
		power = pw;
	};
	public void init(int max, int pw) {
		maxhp = max;
		curhp = max;
		power = pw;
	};
	public void init(String na, int max, int pw) {
		name = na;
		maxhp = max;
		curhp = max;
		power =pw;
	}
	public void attack(Unit target) {
		target.curhp -= power;
		System.out.printf("[%s] 가 [%s] 에게 [%d] 의 데미지를 입힙니다.\n",name,target.name,power);
		if(target.curhp<=0) {
			System.out.printf("[%s]를 처치했습니다.\n",target.name);
			target.curhp = 0;
		}
	}
	public void printData() {
		System.out.printf("[%s] [%d / %d ] [ %d ]\n",name,curhp,maxhp,power);
	}
}

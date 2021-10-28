package game;

public abstract class Unit {
	int curhp;
	int maxhp;
	int power;
	String name;
	String state = "³ë¸»";
	public Unit() {}
	Unit(String name, int max, int power){
		name = name;
		maxhp = max;
		
	}
}

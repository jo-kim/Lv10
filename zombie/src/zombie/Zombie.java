package zombie;

import zombie.Unit.Attack;

public class Zombie extends Unit implements Attack{

	public Zombie(String name, int hp, int att, int def, int pos) {
		super(name, hp, att, def, pos);
	
	}

}

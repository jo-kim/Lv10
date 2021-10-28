package game;

public class UnitWolf extends Unit {
	public UnitWolf() {
		name = "늑대";
	}
	public void skill() {
		System.out.println("적 전체에게 공격력의 절반 데미지");
	}
}

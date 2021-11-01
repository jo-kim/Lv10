package game;

public class UnitOrc extends Unit{
	UnitOrc() {
		name = "오크";
	}
	public void skill() {
		System.out.println("한명에게 2배의 데미지 + 기절");
	}
}

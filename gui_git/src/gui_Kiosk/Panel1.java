package gui_Kiosk;

import javax.swing.JButton;

public class Panel1 extends Util{
	// 버튼 누름 동시에  기본1메뉴  상단 버튼 바 통해서 2 3 메뉴로 이동가능
	// 하단에는 주문수량 (개) 총금액 (원)    주문 버튼 
	// menu - 김밥
	// 
	private final int SIZE = 3;
	private JButton gimBap[][] = new JButton[SIZE][SIZE];
	
	
	public Panel1() {
		setLayout(null);
		setBounds(0,0,Frame1.SIZE,Frame1.SIZE);
	}
	
	
	
}

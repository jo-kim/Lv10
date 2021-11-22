package gui_Kiosk;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class Panel1 extends Util{
	// ��ư ���� ���ÿ�  �⺻1�޴�  ��� ��ư �� ���ؼ� 2 3 �޴��� �̵�����
	// �ϴܿ��� �ֹ����� (��) �ѱݾ� (��)    �ֹ� ��ư 
	// menu - ���
	// 
	private final int SIZE = 3;
	private JButton gimBap[][] = new JButton[SIZE][SIZE];
	private String itemName[][] = {{"","",""},{"","",""},{"","",""}};
	private int itemPrice[][] = {{},{},{}};
	public static JButton menu[] = new JButton[3];
	
	private Item item;
	
	private final int MEASURE = 300;
	public Panel1() {
		setLayout(null);
		setBounds(0,0,Frame1.SIZE,Frame1.SIZE);
		setBackground(Color.white);
		setButton();
		setGimbap();
	}

	private void setGimbap() {
		int x = 150;
		int y = 80;
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				this.item = new Item(i+1,MEASURE,MEASURE);
				this.gimBap[i][j] = new JButton(this.item.getIm());
				this.gimBap[i][j].setBounds(x,y,200,200);
				this.gimBap[i][j].setBackground(Color.white);
				this.gimBap[i][j].addActionListener(this);
				add(this.gimBap[i][j]);
				x+=250;
			}
			x = 150;
			y+= 250;
		}
		
	}

	private void setButton() {
		String menuText[] = {"���","�н�","����"};
		
		int x = 50;
		int y = 10;
		for(int i=0; i<this.menu.length; i++) {
			this.menu[i] = new JButton();
			this.menu[i].setBounds(x,y,300,50);
			this.menu[i].setText(menuText[i]);
			this.menu[i].setFont(new Font("����ǹ��� ����",1,30));
			this.menu[i].setBackground(Color.white);
			this.menu[i].addActionListener(this);
			add(this.menu[i]);
			x+=300;
		}
	}
	
	
	
}

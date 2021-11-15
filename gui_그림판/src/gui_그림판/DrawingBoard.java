package gui_�׸���;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;


public class DrawingBoard extends MyUtil{
	
	private ArrayList<GrimRect> rects = new ArrayList<GrimRect>();
	private ArrayList<GrimRect> circles = new ArrayList<GrimRect>();
	private ArrayList<GrimRect> tri = new ArrayList<GrimRect>();
	private GrimRect rect = null; // �ӽð�ü
	private int startX, startY;  // ������ �Ǵ� ��ǥ
	private boolean shift;
	private int type;
	private final int RECT = 0;
	private final int CIRCLE = 1;
	private final int TRI = 2;
	private String [] btnText = {"��","��","��"};
	private JButton[] btn = new JButton[3];
	public DrawingBoard() {
		setLayout(null);
		setBounds(0,0,1000,900);
		
		setButton();
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setFocusable(true);
		addKeyListener(this);
	}
	
	private void setButton() {
		int x = 0;
		int y = 0;
		for(int i=0; i< this.btn.length; i++) {
			this.btn[i] = new JButton();
			this.btn[i].setBounds(x,y,40,40);
			this.setBackground(Color.white);
			this.btn[i].setText(btnText[i]);
			this.btn[i].setFont(new Font("",1,5));
			this.btn[i].setHorizontalAlignment(JLabel.CENTER);
			this.btn[i].addActionListener(this);
			add(this.btn[i]);
			y+=40+3;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			if(target == this.btn[0])
				this.type = this.RECT;
			else if(target == this.btn[1])
				this.type = this.CIRCLE;
			else if(target == this.btn[2])
				this.type = this.TRI;
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_SHIFT) {
			this.shift = true;
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == e.VK_SHIFT) {
			this.shift = false;
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		// sample triangle
		// g.drawPolygon(int[],int[],int);
		// 1. int[] = x��ǥ�� �迭
		// 2. int[] = y��ǥ�� �迭
		// 3. ������ ����
//		int[] xx = new int[3]; // 
//		int[] yy = new int[3];
//		xx[0] = 100;
//		yy[0] = 100;
//		xx[1] = 150; // ���� ��������
//		yy[1] = 200;
//		xx[2] = 50;
//		yy[2] = 200;
//		g.setColor(Color.green);
//		g.drawPolygon(xx,yy,3);
		
		if( this.rect !=null) { // �ӽð�ü -> Ÿ�Կ� ���� �ٸ��� �׷����� ��������
			g.setColor(this.rect.getC());
			if(this.type == this.RECT) {
				g.drawRect(this.rect.getX(), this.rect.getY(), this.rect.getW(),
						this.rect.getH());
			}
			else if(this.type == this.CIRCLE) {
				g.drawRoundRect(this.rect.getX(), this.rect.getY(), this.rect.getW(),
						this.rect.getH(), this.rect.getW(),
						this.rect.getH());
			}
			else if(this.type == this.TRI) {
				int[]xx = new int[3];
				int[]yy = new int[3];
				/*
				 *           0
				 *           
				 *        11    22
				 */
				
				// xx yy(���� ������) // -xx +yy // +xx +yy
				xx[0] = this.rect.getX();
				yy[0] = this.rect.getY();
				
				xx[1] = this.rect.getX() - this.rect.getW()/2;
				yy[1] = this.rect.getY() + this.rect.getH();
				
				xx[2] = this.rect.getX() +this.rect.getW()/2;
				yy[2] = this.rect.getY() + this.rect.getH();
				
				g.drawPolygon(xx, yy, 3);
			}
		}
		// rect
		for(int i=0; i<this.rects.size(); i++) {
			GrimRect r = this.rects.get(i);
			g.setColor(r.getC());
			g.drawRect(r.getX(), r.getY(), r.getW(),
					r.getH());
			
		}
		// circles
		for(int i=0; i<this.circles.size(); i++) {
			GrimRect o = this.circles.get(i);
			g.setColor(o.getC());
			g.drawRoundRect(o.getX(), o.getY(), o.getW(), o.getH(), o.getW(), o.getH());
		}
		
		// tri
		for(int i=0; i<this.tri.size(); i++) {
			GrimRect t = this.tri.get(i);
			int[]xx = new int[3];
			int[]yy = new int[3];
			
			g.setColor(t.getC());
			xx[0] = t.getX();
			yy[0] = t.getY();
			
			xx[1] = t.getX() - t.getW()/2;
			yy[1] = t.getY() + t.getH();
			
			xx[2] = t.getX() + t.getW()/2;
			yy[2] = t.getY() + t.getH();
			
			g.drawPolygon(xx, yy, 3);
		}
		requestFocusInWindow(); // keylistener�� �ʿ� ��Ŀ�� �ٽ��ϰԲ�
		repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		this.startX = e.getX();
		this.startY = e.getY();
	
	}
	
	@Override
	public void mouseReleased(MouseEvent e) { // �׸�����
		this.rect.setC(Color.blue);
		if(this.type == this.RECT) {
		this.rects.add(this.rect);
		
		}
		else if(this.type == this.CIRCLE) {
			this.circles.add(this.rect);
			
		}
		else if(this.type == this.TRI) {
			this.tri.add(this.rect);
		}
		this.rect = null;
		super.mouseReleased(e);
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX(); // �巡�� ���� ��ǥ
		int y = e.getY();
		
		int w = Math.abs(x-startX);  // ���밪
		int h = Math.abs(y-startY);
		
		if(shift)
			w = h; // ���� �ƹ����� �������̵�
		
		int rX = startX;
		int rY = startY;
		if(x < startX)
			rX = startX - w;
		if(y < startY)
			rY = startY - h;
		this.rect = new GrimRect(rX,rY,w,h,Color.red); // ������ǥ�� �������� �׸� �׸��� 
		
		// -- �϶��� startX �� startY�� �ٲ������ startX - w/ startY - h��
	}
}

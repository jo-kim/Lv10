package gui_horse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Content extends Util{
	private final int SIZE = 5;
	private Horse[] horse = new Horse[SIZE];
	private int startX = 50;
	private int startY = 100;
	
	private JButton start = new JButton();
	private JLabel timer = new JLabel();
	private int n;
	private int ms;
	private boolean isRun;
	public Content() {
		setLayout(null);
		setBounds(0,0,1200,800);
		
		setStart();
		setHorse();
		setTimer();
	}

	private void setTimer() {
		this.timer.setBounds(150,20,100,50);
		this.timer.setText("ready");
		this.timer.setHorizontalAlignment(JLabel.CENTER);
		add(this.timer);
		
	}
	
	private void setHorse() {
		int x = startX;
		int y = startY;
		for(int i=0; i<SIZE; i++) {
			this.horse[i] = new Horse(i+1,x,y,150,120);
			y+=130;
		}	
	}
	 @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for(int i=0; i<SIZE; i++) {
			Horse h = this.horse[i];
			g.drawImage(h.getImage().getImage(), h.getX(), h.getY() , null);
			g.drawLine(this.startX, h.getY()+h.getH(), 1200-30, h.getY()+h.getH()); // startx y, end x y
		}
		
		for(int i=0; i<SIZE; i++) {
			Horse h = this.horse[i];
			if(h.getRank() !=0) {
				g.setFont(new Font("",Font.BOLD,25));
				g.drawString(h.getRank()+"µî",900,h.getY()+60 );
				g.setFont(new Font("",0,15));
				g.drawString(h.getRecord(), 900+50,h.getY()+60 );	
			}
		}
		
		try {
			Thread.sleep(50);
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		play();
		repaint();
	}
	 
	private void play() {
		Random rn = new Random();
		if(this.isRun) {
		for(int i=0; i<SIZE; i++) {
			int r = rn.nextInt(10)+1;
			Horse h = this.horse[i];
			if(h.getState() == h.RUN && h.getX()<1050-30) {
				h.setX(h.getX()+r);
			}
			if(h.getX()>=1050-30 && h.getState()==h.RUN) {
				h.setX(1050-30);
				h.setState(h.GOAL);
				n++;
				h.setRank(n);
				h.setRecord(String.format("%4d.%3d", this.ms/1000,this.ms%1000));
			}
		}
		}
		
	}

	private void setStart() {
		this.start.setBounds(50,20,100,50);
		this.start.setText("START");
		this.start.setHorizontalAlignment(JLabel.CENTER);
		this.start.setBackground(Color.white);
		this.start.addActionListener(this);
		add(this.start);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			if(target == this.start) {
				for(int i=0; i<SIZE; i++) {
					this.horse[i].setState(this.horse[i].RUN);
				}
				this.isRun = !this.isRun;
				this.start.setText(this.isRun?"reset":"start");
			}
			if(!this.isRun)
				resetGame();
		}
	}
	private void resetGame() {
		this.timer.setText("Ready");
		this.ms = 0;
		this.n = 0;
		setHorse();
		
	}

	@Override
	public void run() {
		while(true) {
			if(isRun) {
				this.ms ++;
				this.timer.setText(String.format("%4d.%3d", this.ms/1000, this.ms%1000));
			}
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
}

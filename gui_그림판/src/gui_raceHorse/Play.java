package gui_raceHorse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

import gui_±×¸²ÆÇ.MyUtil;


public class Play extends MyUtil implements Runnable{
	private final int SIZE = 5;
	private Horse horse[] = new Horse[SIZE];
	private int startX  = 50;
	private int startY = 100;
	
	private JButton start;
	private JLabel timer = new JLabel("Ready");
	private int ms;
	private boolean isRun;
	public Play() {
		setLayout(null);
		setBounds(0,0,1200,800);
		
		setHorse();
		setStart();
		setTimer();
		
		
	}

	private void setHorse() {
		int x = this.startX;
		int y = this.startY;
		for(int i=0; i<SIZE; i++) {
			this.horse[i] = new Horse(i+1,x,y,150,120);
			y+=130;
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i=0 ;i <SIZE; i++) {
			Horse h = this.horse[i];
			g.drawImage(h.getImage().getImage(), h.getX(),h.getY(),null);
			g.drawLine(this.startX,h.getY()+h.getH(), 1200-30, h.getY()+h.getH());
		}
		play();
		repaint();
	}
	private void play() {
		Random rn = new Random();
		
		for(int i=0; i<SIZE; i++) {
			Horse h =this.horse[i];
			int r = rn.nextInt(10)+1;
			if(h.getState() == h.RUN) {
				h.setX(h.getX()+r);
			}
		}
		
	}

	private void setTimer() {
		this.timer.setBounds(150,50,100,50);
		this.timer.setBackground(Color.white);
		this.timer.setHorizontalAlignment(JLabel.CENTER);
		add(this.timer);
		
	}

	private void setStart() {
		this.start = new JButton();
		this.start.setBounds(50,50,100,50);
		this.start.setText("Start");
		this.start.setBackground(Color.white);
		this.start.setFont(new Font("",Font.BOLD,15));
		this.start.setHorizontalAlignment(JLabel.CENTER);
		this.start.addActionListener(this);
		add(this.start);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			if(target == this.start) {
			 this.isRun = true;
			}
		}
	}

	@Override
	public void run() {
		while(true) {
			if(this.isRun) {
				this.ms++;
				this.timer.setText(String.format("%4d.%3d", this.ms/1000,this.ms%1000));
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		
	}
	
}

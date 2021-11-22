package gui_Kiosk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame1 extends JFrame implements ActionListener{
	
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int w = dm.width;
	public static int h = dm.height;
	public static final int SIZE = 1000;
	
	private Image im = new ImageIcon("image/mainLogo.png").getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
	private JLabel main;
	
	private JButton toGo;
	private Image tooGo = new ImageIcon("image/toGo.png").getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH);
	private JButton here;
	private Image hereImg = new ImageIcon("image/here.png").getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH);
	
	public Panel1 menu = new Panel1();
	
	public Frame1() {
		super("Main");
		setLayout(null);
		setBounds(w/2-SIZE/2 , h/2 -SIZE/2, SIZE, SIZE );
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setMain();
		
		setVisible(true);
		revalidate();
	}
	private void setMain() {
		this.main = new JLabel(new ImageIcon(im));
		this.main.setBounds(240,0,500,500);
		this.main.setVisible(true);
		add(this.main);
		
		this.toGo = new JButton(new ImageIcon(tooGo));
		this.toGo.setBounds(150,500,300,300);
		this.toGo.setBackground(Color.white);
		this.toGo.addActionListener(this);
		add(this.toGo);
		
		this.here = new JButton(new ImageIcon(hereImg));
		this.here.setBounds(550,500,300,300);
		this.here.setBackground(Color.white);
		this.here.addActionListener(this);
		add(this.here);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.toGo || e.getSource() == this.here) {
		
			this.setContentPane(menu);
	}

	
	}
}

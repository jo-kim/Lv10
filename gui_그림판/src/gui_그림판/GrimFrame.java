package gui_±×¸²ÆÇ;

import javax.swing.JFrame;

public class GrimFrame extends JFrame{
	
	public GrimFrame() {
		super("Drawing Board");
		setLayout(null);
		setBounds(100,100,1000,900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new DrawingBoard());
		setVisible(true);
		revalidate();
	}
}

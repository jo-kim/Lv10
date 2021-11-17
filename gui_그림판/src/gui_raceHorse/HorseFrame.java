package gui_raceHorse;

import javax.swing.JFrame;

public class HorseFrame extends JFrame{
	public HorseFrame() {
		super("Race Horse Game");
		setLayout(null);
		setBounds(400,200,1200,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new Play());
		setVisible(true);
		revalidate();
	}
}

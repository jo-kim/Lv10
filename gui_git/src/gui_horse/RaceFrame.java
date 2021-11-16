package gui_horse;

import javax.swing.JFrame;

public class RaceFrame extends JFrame{
	Content con = new Content();
	public RaceFrame() {
		super("Race Horse Game");
		setLayout(null);
		setBounds(400,200,1200,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(con);
		setVisible(true);
		revalidate();
		
		con.run(); // runnable
	}
}

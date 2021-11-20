package gui_signUp;

import javax.swing.JFrame;

public class Frame extends JFrame{
	public Frame() {
		super("Login");
		setLayout(null);
		setBounds(200,200,600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new Panel());
		setVisible(true);
		revalidate();
	}
}

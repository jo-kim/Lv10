package gui_signUp;

import javax.swing.JFrame;


public class JoinFrame extends JFrame {
	
	public JoinFrame() {
		super("SignUp");
		setLayout(null);
		setBounds(200,200,500,500);
		add(new JoinPanel());
		setVisible(true);
		revalidate();
	}

	
	

	
}

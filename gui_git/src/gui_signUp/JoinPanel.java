package gui_signUp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JoinPanel extends Util{
	
	private JButton register;
	private JLabel newId;
	private JLabel newPw;
	private JLabel name;
	private JTextField inputId = new JTextField();
	private JTextField inputPw = new JTextField();
	private JTextField inputName = new JTextField();
	
	JoinFrame joinframe = null;
	public JoinPanel() {
		setLayout(null);
		setBounds(0,0,500,500);
		addRegister();
		addTextField();
		addLabel();
	}
	
	private void addTextField() {
		inputId.setBounds(270,210,150,30);
		inputPw.setBounds(270,270,150,30);
		inputName.setBounds(270,150,150,30);
		add(inputId);
		add(inputPw);
		add(inputName);
	}


	private void addLabel() {
		this.newId = new JLabel("[Sign-Up] Id  ");
		this.newPw = new JLabel("[Sign-Up] Pw  ");
		this.name = new JLabel("[Sign-Up] Name  ");
		this.newId.setBounds(100,200,200,50);
		this.newId.setFont(new Font("Consolas",Font.BOLD,20));
		add(this.newId);
		this.newPw.setBounds(100,260,200,50);
		this.newPw.setFont(new Font("Consolas",Font.BOLD,20));
		add(this.newPw);
		
		this.name.setBounds(100,140,200,50);
		this.name.setFont(new Font("Consolas",Font.BOLD,20));
		add(this.name);
	}
	private void addRegister() {
		this.register = new JButton();
		this.register.setBounds(200,350,100,30);
		this.register.setText("Register");
		this.register.setBackground(new Color(148,218,255));
		this.register.addActionListener(this);
		add(this.register);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// register -> users add;
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			if(target == this.register) {
				this.joinframe = new JoinFrame();
				String id = inputId.getText();
				String pw = inputPw.getText();
				String name = inputName.getText();
				if(!id.equals("") && !pw.equals("")) { // ºóÄ­ ¾Æ´Ò¶§
					addUser(id,pw,name);
//					System.out.println(Panel.users.size());
					joinframe.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Check your Information");
					
				}
				
			}
		}
		
		
	}


	private void addUser(String id , String pw, String name) {
		boolean check = checkUserId(id);
		if(!check) {
		Vector<String> user = new Vector<>();
		user.add(id);
		user.add(pw);
		user.add(name);
		Panel.users.add(user);
		JOptionPane.showMessageDialog(null, "Welcome!");
		
		}
		else {
			JOptionPane.showMessageDialog(null, "Id is already in use.");
		}
		
	}


	private boolean checkUserId(String id) {
		for(int i=0; i<Panel.users.size(); i++) {
			if(Panel.users.get(i).get(0).equals(id))
				return true;
		}
		return false;
	}

}

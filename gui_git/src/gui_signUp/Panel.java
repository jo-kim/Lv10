package gui_signUp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//로그인 & 회원가입
	// ㄴ 메인프레임에 버튼 두개
	// ㄴ 로그인과 회원가입
	// ㄴ 버튼을 누르면  -> 팝업(새로운 프레임)  -> 텍스트 입력
	// ㄴ 회원가입 정보는 Vector에 저장
	

	// User : Vector<String>
	// ㄴ add(id) : 중복예외처리
	// ㄴ add(pw)
	// ㄴ add(name)



public class Panel extends Util{
	public static Vector<Vector<String>> users = new Vector<>();
	 
	
	private JButton login;
	private JButton join;
	private JLabel designLogin;
	private JLabel message;
	private JLabel id;
	private JLabel pw;
	private JTextField ids = new JTextField();;
	private JTextField pws = new JTextField();;
	public Panel() {
		setLayout(null);
		setBounds(0,0,600,600);
		setLogin();
		setJoin();
		setLabel();
		setTextfield();
		
	}

	private void setTextfield() {
		this.ids.setBounds(230,210,150,30);
		this.ids.setFocusable(true);
		this.ids.addKeyListener(this);
		add(this.ids);
		this.pws.setBounds(230,270,150,30);
		this.pws.setFocusable(true);
		this.pws.addKeyListener(this);
		add(this.pws);
		
		
	}

	private void setLabel() {
		this.id = new JLabel("Id  ");
		this.pw = new JLabel("Pw  ");
		this.id.setBounds(160,200,100,50);
		this.id.setFont(new Font("Consolas",Font.BOLD,20));
		add(this.id);
		this.pw.setBounds(160,260,100,50);
		this.pw.setFont(new Font("Consolas",Font.BOLD,20));
		add(this.pw);
		
		this.designLogin = new JLabel("Login");
		this.designLogin.setBounds(220, 80, 150, 100);
		this.designLogin.setFont(new Font("HY견고딕",1,35));
		add(this.designLogin);
		
		this.message = new JLabel("Don't you have ID?");
		this.message.setBounds(160,450,150,30);
		this.message.setFont(new Font("Century Gothic",1,13));
		add(this.message);
		
	}

	private void setJoin() {
		this.join = new JButton();
		this.join.setBounds(300,450,80,30);
		this.join.setText("Sign Up");
		this.join.setFont(new Font("",Font.PLAIN,13));
		this.join.setHorizontalAlignment(JLabel.CENTER);
		this.login.setBackground(new Color(148,218,255));
		this.join.addActionListener(this);
		add(this.join);
	}

	private void setLogin() {
		this.login = new JButton();
		this.login.setBounds(160,350,220,50);
		this.login.setText("LOGIN");
		this.login.setFont(new Font("",Font.BOLD,13));
		this.login.setHorizontalAlignment(JLabel.CENTER);
		this.login.setBackground(new Color(148,218,255));
		this.login.addActionListener(this);
		add(this.login);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			if(target == this.login) {
				login();
				// if id pw O - > Frame login complete
				//          X - > Frame wrong
			}
			else if(target == this.join) {
				new JoinFrame();
			}
		}
	}



	private void login() {
		int check = -1;
		for(int i=0; i<this.users.size(); i++) {
			Vector<String> temp = this.users.get(i);
			if(temp.get(0).equals(ids.getText()) && temp.get(1).equals(pws.getText())) {
				check = i;
			}
		}
		if(check!= -1) {
			JOptionPane.showMessageDialog(null, "Login Complete");
		}
		else {
			JOptionPane.showMessageDialog(null, "Check your information");
		}
		
	}
}

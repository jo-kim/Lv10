package gui_;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
class Listener extends JPanel implements KeyListener,ActionListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
class Death extends JFrame{
	private JLabel text = new JLabel();
	public Death(String str) {
		super("GAME OVER");
		setLayout(null);
		setBounds(400,300,300,200);
		this.text.setBounds(0,0,300,200);
		this.text.setFont(new Font("",Font.BOLD,20));
		this.text.setText(str);
		this.text.setHorizontalAlignment(JLabel.CENTER);
		add(this.text);
		setVisible(true);
		revalidate();
	}
}
class Box{
	
	private int x, y, w, h;
	private Color c;
	public Box(int x, int y, int w, int h, Color c) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
}
class Sgame extends Listener{
	private final int SIZE = 10;
	private Box map[][] = new Box[SIZE][SIZE];
	
	private ArrayList<Box> snake = new ArrayList<Box>();
	private ArrayList<Box> items = new ArrayList<Box>();
	private ArrayList<ArrayList<Integer>> yx = new ArrayList<ArrayList<Integer>>();
	private ArrayList<ArrayList<Integer>> itemYx = new ArrayList<ArrayList<Integer>>();
	
	private final int LEFT = 0;
	private final int DOWN = 1;
	private final int RIGHT = 2;
	private final int UP = 3;
	
	private int dir;
	private boolean death;
	
	private JButton key[] = new JButton[4];
	private JButton reset = new JButton();
	private JLabel title = new JLabel();
	public Sgame() {
		setLayout(null);
		setBounds(0,0,800,600);
		
		setTitle();
		setButton();
		setMap();
		setSnake();
		setItems();	
		
		setFocusable(true);
		addKeyListener(this);
	}

	private void setItems() {
		Random rn = new Random();
		int r = rn.nextInt(SIZE*SIZE/5)+5;
		
		for(int i=0; i<r; i++) {
			int rY = rn.nextInt(SIZE);
			int rX = rn.nextInt(SIZE);
			
			boolean check = false;
			for(int j=0; j<this.yx.size(); j++) {
				if(rY == this.yx.get(j).get(0) && rX == this.yx.get(j).get(1))
					check = true;
			}
			if(check) i--;
			else {
				Box t = this.map[rY][rX];
				this.items.add(new Box(t.getX()+10,t.getY()+10,20,20,Color.blue));
				
				ArrayList<Integer> pair = new ArrayList<Integer>();
				pair.add(rY);
				pair.add(rX);
				this.itemYx.add(pair);
			}
		}
	}

	private void setSnake() {
		for(int i=0; i<4; i++) {
			Box t = this.map[0][i]; 
			Color c = Color.blue; // body
			if(i==0) // head
				c = Color.green;
			this.snake.add(new Box(t.getX(),t.getY(),t.getW(),t.getH(),c)); // snake 초기값 맵에서 가져옴
			
			ArrayList<Integer> pair = new ArrayList<>();
			pair.add(0); // map y 인덱스 
			pair.add(i); // map x 인덱스
			this.yx.add(pair);
		}
		
	}

	private void setTitle() {
		this.title.setBounds(-15,-25,300,100);
		this.title.setText("SNAKE GAME");
		this.title.setFont(new Font("",1,30));
		this.title.setHorizontalAlignment(JLabel.CENTER);
		add(this.title);
		
	}

	private void setButton() {
		String text[] = {"←","↓","→","↑"};
		int x = 550;
		int y = 400;
		for(int i=0; i<key.length; i++) {
			this.key[i] = new JButton();
			this.key[i].setBounds(x,y,60,60);
			this.key[i].setBackground(Color.white);
			this.key[i].setText(text[i]);
			this.key[i].setFont(new Font("",Font.BOLD,18));
			this.key[i].addKeyListener(this);
			add(this.key[i]);
			x+=60;
			if(i==key.length-1-1) {
				x-=120;
				y-=60;
			}	 
		}
		this.reset.setBounds(550,480,180,70);
		this.reset.setText("RESET");
		this.reset.setFont(new Font("",Font.BOLD,20));
		this.reset.setBackground(Color.white);
		this.reset.addActionListener(this);
		add(this.reset);
	}

	private void setMap() {
		
		int y = 250 - 40*SIZE/2;
		for(int i=0; i<SIZE; i++) {
			int x = 230 - 40*SIZE/2;
			for(int j=0; j<SIZE; j++) {
				this.map[i][j] = new Box(x,y,50,50,Color.pink);
				
				x+=50;
			}
			y+=50;
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		// snake
				for(int i=0; i<this.snake.size(); i++) {
					Box r = this.snake.get(i);
					Color c = Color.blue;
					if(i==0)
						c = Color.GREEN;
					if(death)
						c = Color.black;
					g.setColor(c);
					g.fillRect(r.getX(),r.getY(),r.getW(),r.getH());
				}
				// item
				for(int i=0; i<this.items.size(); i++) {
					Box r = this.items.get(i);
					Color c = Color.pink;
					g.setColor(c);
					g.fillRoundRect(r.getX(),r.getY(),r.getW(),r.getH(),r.getW(),r.getH());
				}
				g.setColor(Color.black);
				// map
				for(int i=0; i<SIZE; i++) {
					for(int j=0; j<SIZE; j++) {
						Box r = this.map[i][j];
						g.setColor(r.getC());
						g.drawRect(r.getX(),r.getY(),r.getW(),r.getH());
					}
				}
				requestFocusInWindow();
				repaint();
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_LEFT) 
			this.dir = LEFT;
		else if(e.getKeyCode() == e.VK_DOWN) 
			this.dir = DOWN;
		else if(e.getKeyCode() == e.VK_RIGHT) 
			this.dir = RIGHT;
		else if(e.getKeyCode() == e.VK_UP) 
			this.dir = UP;
		super.keyPressed(e);
		
		move();
	}
	
	
	

	private void move() {
		int yy = this.yx.get(0).get(0);
		int xx = this.yx.get(0).get(1);
		
		if(this.dir == LEFT) 
			xx--;
		else if(this.dir == DOWN) 
			yy++;
		else if(this.dir == RIGHT) 
			xx++;
		else if(this.dir == UP) 
		    yy--;
		
		// check 
		if(xx <0 || xx>=SIZE || yy<0 || yy>= SIZE )
			return;
		
		//bodyCheck
		for(int i=0; i<this.yx.size(); i++) {
			if(yy ==this.yx.get(i).get(0) && xx == this.yx.get(i).get(1))
				this.death = true;
		}
		
		// item
		boolean isGrow = false;
		for(int i=0; i<this.itemYx.size(); i++) { // item 먹었다 처리
			if(yy == this.itemYx.get(i).get(0) && xx == this.itemYx.get(i).get(1)) {
				isGrow = true;
				this.items.remove(i); // 아이템 먹고지우기
				this.itemYx.remove(i); // 아이템 지도에서 지우기
			}
			
		}
		
		// move
		if(!death) {
			Box tail = this.snake.get(this.snake.size()-1);
			ArrayList<Integer> tailYx = this.yx.get(this.yx.size()-1);
			
			// body
			for(int i=this.snake.size()-1; i>0; i--) {
				Box temp = this.snake.get(i-1);
				temp.setC(Color.blue);
				this.snake.set(i, temp);
				
				ArrayList<Integer> pair = this.yx.get(i-1);
				this.yx.set(i, pair); // i--> pair 물려받기 
			}
			// head
			Box t = this.map[yy][xx];
			this.snake.set(0, new Box(t.getX(),t.getY(),t.getW(),t.getH(),Color.red));
			ArrayList<Integer> pair = new ArrayList<Integer>();
			pair.add(yy);
			pair.add(xx);
			this.yx.set(0, pair);
			
			// item 먹으면
			if(isGrow) {
				this.snake.add(tail);
				this.yx.add(tailYx);
			}
		}
		else {
			new Death("You lose …");
		}
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) { // reset
		if (e.getSource() instanceof JButton) {
			JButton temp = (JButton) e.getSource();
			if (temp == this.reset) {
				resetGame();
			}

		}
		super.actionPerformed(e);
	}

	private void resetGame() {
		
		// snake
		for (int i = 0; i < this.yx.size(); i++) {
			yx.clear();
		}

		for (int i = 0; i < snake.size(); i++) {
			this.snake.clear();
		}

		// item
		for (int i = 0; i < this.itemYx.size(); i++) {
			this.items.remove(i);
			this.itemYx.remove(i);
		}
		setSnake();
		setItems();
	}

	
}


public class Snake extends JFrame{
	public Snake() {
		super("Snake");
		setBounds(100,100,800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new Sgame());
		
		setVisible(true);
		revalidate();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Snake game = new Snake();
	}

}

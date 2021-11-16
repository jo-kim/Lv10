package gui_horse;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Horse {
	// 
	public final int READY  = 0;
	public final int RUN = 1;
	public final int GOAL = 2;
	
	private int num; 
	private int x,y,w,h;
	private String fileName; 
	private ImageIcon image;
	
	private int state; // 0 ready , 1 run 2 goal 말의 현상태 기록용
	private int rank;
	private String record;
	
	public Horse(int num , int x, int y, int w, int h) {
		this.num = num;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.fileName = String.format("images/horse%d.png", this.num);
		this.image = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
	}
	
	public int getNum() {
		return num;
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
	public String getFileName() {
		return fileName;
	}
	public ImageIcon getImage() {
		return image;
	}
	public int getState() {
		return state;
	}
	public int getRank() {
		return rank;
	}
	public String getRecord() {
		return record;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
		// ImageIcon 수정 초기화
	}

	public void setState(int state) {
		this.state = state;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	
}

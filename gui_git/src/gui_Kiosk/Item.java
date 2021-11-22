package gui_Kiosk;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Item {
	private int x,y,w,h,num;
	private String fileName, name;
	private ImageIcon im;
	
	public Item(int num, int w, int h) {
		this.num = num;
		this.w = w;
		this.h = h;
		if(this.num<10) {
		this.fileName = String.format("image/gimbap/gimbap_%d.png", this.num);
		}
		else {
			this.fileName = String.format("image/bunsik/bunsik_%d.png", this.num);
		}
		this.im = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
	}
	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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
	public String getName() {
		return name;
	}
	
	public ImageIcon getIm() {
		return im;
	}
	public void setW(int w) {
		this.w = w;
	}
	public void setH(int h) {
		this.h = h;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setIm(ImageIcon im) {
		this.im = im;
	}
	
}

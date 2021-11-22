package gui_Kiosk;

import javax.swing.ImageIcon;

public class Item {
	private int w,h,price;
	private String fileName, name, category;
	private ImageIcon im;
	
	public Item() {
		
	}
	
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
	public int getPrice() {
		return price;
	}
	public String getFileName() {
		return fileName;
	}
	public String getName() {
		return name;
	}
	public String getCategory() {
		return category;
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
	public void setPrice(int price) {
		this.price = price;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setIm(ImageIcon im) {
		this.im = im;
	}
	
}

package src.dnd.test;

import java.awt.Image;

public class Drawing {

	private Image img;
	private int x,y;
	public Drawing(Image i, int xc, int yc)
	{
		img = i;
		x = xc;
		y = yc;
	}
	public Image getImg() {
		return img;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	

}

package dnd.map;

import java.awt.Color;
import java.awt.Graphics;

public class CharImage {

	private int _x, _y;
	public CharImage(int x,int y) {
		_x=x;_y=y;
	}
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(_x+2, _y+2, 20, 20);
	
	}
	public boolean isEqual(int x, int y){
		return (_x == x && _y == y);
	}

}

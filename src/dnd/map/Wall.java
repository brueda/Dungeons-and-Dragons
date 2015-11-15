package src.dnd.map;

import java.awt.Color;
import java.awt.Graphics;

public class Wall {
	private int _x1,_y1,_x2,_y2;
	public Wall(int x1,int y1,int x2,int y2) {
		_x1=x1;_x2=x2;_y1=y1;_y2=y2;
	}
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(_x1, _y1, _x2, _y2);
	}
	public boolean isEqual(int x1, int y1, int x2, int y2){
		return (_x1 == x1 && _y1 == y1 && _x2 == x2 && _y2 == y2);
	}

}

package dnd.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


import dnd.core.State;

public class PositionEnemyState extends State{

	private Color lighterGray = new Color(224,224,224);
	private ArrayList<String> _enemyNames;
	public PositionEnemyState() {
		_enemyNames = new ArrayList<String>();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(50, 50, 600, 600);
		g.setColor(lighterGray);
		for(int i = 0; i < 26; i++){
			g.drawLine(i*24+50, 50, i*24+50, 650); // going left
			g.drawLine(50, i*24+50, 650, i*24+50); // going down
		}
		if(Grid._selectedTile != null){
			g.setColor(Color.CYAN);
			//convert index to upper left coordinates
			int x1 = Grid._selectedTile._xIndex*24+50;
			int y1 = Grid._selectedTile._yIndex*24+50;
			//slightly smaller square to let the edges show
			g.fillRect(x1+1, y1+1, 23, 23);
			g.drawString("Enter values for enemy below", 740, 50);
		}
		for(Wall wl:Grid._walls){
			wl.render(g);
		}
		for(CharImage ci:Grid._charImage){
			ci.render(g);
		}
	}

	@Override
	public void handleClick(int x, int y) {
		//calculate X Tile index
		int xTemp = (x-50)%24;
		x = x - xTemp;
		int xTile = (x-50)/24;
		//calculate Y Tile index
		int yTemp = (y-50)%24;
		y = y - yTemp;
		int yTile = (y-50)/24;
		
		Grid._selectedTile = Grid._grid[xTile][yTile];
	}

	@Override
	public void handleKeyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

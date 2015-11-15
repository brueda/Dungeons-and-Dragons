package dnd.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


import dnd.core.State;

public class PositionEnemyState extends State{

	private Color lighterGray = new Color(224,224,224);
	private ArrayList<String> _enemyNames;
	private String _strString, _dexString, _conString, 
		_intString, _wisString, _chaString;
	private int _whichField;
	public PositionEnemyState() {
		_enemyNames = new ArrayList<String>();
		_strString = ""; _dexString = ""; _conString = "";
		_intString = ""; _wisString = ""; _chaString = "";
		_whichField = 0;
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
			
			g.setColor(Color.BLACK);
			g.drawString("Enter values for enemy below", 740, 50);
			 // STR
			g.drawString("STR:", 710, 75);
			g.drawRect(740, 60, 20, 23);
			if(_whichField == 1){
				g.setColor(Color.PINK);
				g.fillRect(741, 61, 19, 22);
				g.setColor(Color.BLACK);
			}
			g.drawString(_strString, 742, 75);
			 // DEX
			g.drawString("DEX:", 780, 75);
			g.drawRect(810, 60, 20, 23);
			if(_whichField == 2){
				g.setColor(Color.PINK);
				g.fillRect(811, 61, 19, 22);
				g.setColor(Color.BLACK);
			}
			g.drawString(_dexString, 812, 75);
			 // CON
			g.drawString("CON:", 850, 75);
			g.drawRect(880, 60, 20, 23);
			if(_whichField == 3){
				g.setColor(Color.PINK);
				g.fillRect(881, 61, 19, 22);
				g.setColor(Color.BLACK);
			}
			g.drawString(_conString, 883, 75);
			 // INT
			g.drawString("INT:", 710, 110);
			g.drawRect(740, 95, 20, 23);
			if(_whichField == 4){
				g.setColor(Color.PINK);
				g.fillRect(741, 96, 19, 22);
				g.setColor(Color.BLACK);
			}
			g.drawString(_intString, 742, 110);
			 // WIS
			g.drawString("WIS:", 780, 110);
			g.drawRect(810, 95, 20, 23);
			if(_whichField == 5){
				g.setColor(Color.PINK);
				g.fillRect(811, 96, 19, 22);
				g.setColor(Color.BLACK);
			}
			g.drawString(_wisString, 812, 110);
			 // CHA
			g.drawString("CHA:", 850, 110);
			g.drawRect(880, 95, 20, 23);
			if(_whichField == 6){
				g.setColor(Color.PINK);
				g.fillRect(881, 96, 19, 22);
				g.setColor(Color.BLACK);
			}
			g.drawString(_chaString, 883, 110);
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
		//STR textbox
		if(x < 760 && x > 740 && y < 83 && y > 60){
			_whichField = 1;
		}
		//DEX textbox
		else if(x < 840 && x > 810 && y < 83 && y > 60){
			_whichField = 2;
		}
		//CON textbox
		else if(x < 900 && x > 880 && y < 83 && y > 60){
			_whichField = 3;
		}
		//INT textbox
		else if(x < 760 && x > 740 && y < 118 && y > 95){
			_whichField = 4;
		}
		//WIS textbox
		else if(x < 840 && x > 810 && y < 118 && y > 95){
			_whichField = 5;
		}
		//CHA textbox
		else if(x < 900 && x > 880 && y < 118 && y > 95){
			_whichField = 6;
		}
		else{
			_whichField = 0;
			//calculate X Tile index
			int xTemp = (x-50)%24;
			x = x - xTemp;
			int xTile = (x-50)/24;
			//calculate Y Tile index
			int yTemp = (y-50)%24;
			y = y - yTemp;
			int yTile = (y-50)/24;
			if(xTile < 26 && yTile < 26)
				Grid._selectedTile = Grid._grid[xTile][yTile];
		}
	}

	@Override
	public void handleKeyPressed(KeyEvent e) {
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_BACK_SPACE:
			switch(_whichField){
			case 1:
				if(!_strString.equals(""))
					_strString = _strString.substring(0, _strString.length()-1);
				break;
			case 2:
				if(!_dexString.equals(""))
					_dexString = _dexString.substring(0, _dexString.length()-1);
				break;
			case 3:
				if(!_conString.equals(""))
					_conString = _conString.substring(0, _conString.length()-1);
				break;
			case 4:
				if(!_intString.equals(""))
					_intString = _intString.substring(0, _intString.length()-1);
				break;
			case 5:
				if(!_wisString.equals(""))
					_wisString = _wisString.substring(0, _wisString.length()-1);
				break;
			case 6:
				if(!_chaString.equals(""))
					_chaString = _chaString.substring(0, _chaString.length()-1);
				break;
			}
			break;
		case KeyEvent.VK_MINUS:
			if(_whichField > 6)
				break;
		case KeyEvent.VK_0:
		case KeyEvent.VK_1:
		case KeyEvent.VK_2:
		case KeyEvent.VK_3:
		case KeyEvent.VK_4:
		case KeyEvent.VK_5:
		case KeyEvent.VK_6:
		case KeyEvent.VK_7:
		case KeyEvent.VK_8:
		case KeyEvent.VK_9:
			switch(_whichField){
			case 1:
				if(_strString.length() < 2)
					_strString += e.getKeyChar();
				break;
			case 2:
				if(_dexString.length() < 2)
					_dexString += e.getKeyChar();
				break;
			case 3:
				if(_conString.length() < 2)
					_conString += e.getKeyChar();
				break;
			case 4:
				if(_intString.length() < 2)
					_intString += e.getKeyChar();
				break;
			case 5:
				if(_wisString.length() < 2)
					_wisString += e.getKeyChar();
				break;
			case 6:
				if(_chaString.length() < 2)
					_chaString += e.getKeyChar();
				break;
			}
		}
	}

}

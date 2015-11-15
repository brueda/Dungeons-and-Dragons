package src.dnd.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import src.dnd.core.State;

public class PositionCharState  extends State {

	private Color lighterGray = new Color(224,224,224);
	private ArrayList<String> _charNames;
	private int index;
	public PositionCharState() {
		_charNames = new ArrayList<String>();
		_charNames.add("Ben"); _charNames.add("Benjamin"); _charNames.add("Pat");
		_charNames.add("PattyCakes"); _charNames.add("DOH");
		index = 0;
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
		}
		for(Wall wl:Grid._walls){
			wl.render(g);
		}
		for(CharImage ci:Grid._charImage){
			ci.render(g);
		}
		g.setColor(Color.BLACK);
		if(index < _charNames.size()){
			g.drawString("Click square to place " + _charNames.get(index), 740, 50);
			g.drawString("Press Enter to place. Press Space to skip.", 710, 70);
		}
		else{
			g.drawString("All players have been accounted for.", 710, 50);
			g.drawString("Press Space to continue.", 750, 70);
		}
		if(index != 0){
			g.drawString("Press BackSpace to go back.", 730, 90);
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
		if(Grid._selectedTile != null){
			int x = Grid._selectedTile._xIndex*24+50;
			int y = Grid._selectedTile._yIndex*24+50;
			switch(e.getKeyCode())
			{
			case KeyEvent.VK_ENTER:
				System.out.println("ENTER!");
				if(index < _charNames.size()){
					Grid._charImage.add(new CharImage(x,y));
				}
			case KeyEvent.VK_SPACE:
				if(index < _charNames.size()){
					index++;
				}else{
					Grid._selectedTile = null;
					setNewState(new PositionEnemyState());
				}
				break;
			case KeyEvent.VK_BACK_SPACE:
				if(index == 0){
					break;
				}
				else{
					index--;
					Grid._charImage.remove(index);
				}
				break;
			default:
				System.out.println("Some other key... In Position Char");
			}
		}
		else{
			System.err.println("FUCCCCCKKKKKKKKKK22");
		}
		
	}

}

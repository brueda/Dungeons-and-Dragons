package src.dnd.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import src.dnd.core.StartClass;
import src.dnd.core.State;

public class CreateWallState extends State{

	private Color lighterGray = new Color(224,224,224);
	private String prompt = "Press Space to finish";
	private boolean continueConfirm;
	public CreateWallState() {
		continueConfirm = false;
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
		g.setColor(Color.BLACK);
		g.drawString(prompt, 750, 50);
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
	}

	@Override
	public void handleClick(int x, int y) {
		System.out.println("X :" + x + " Y: " + y);
		//calculate X Tile index
		int xTemp = (x-50)%24;
		x = x - xTemp;
		int xTile = (x-50)/24;
		//calculate Y Tile index
		int yTemp = (y-50)%24;
		y = y - yTemp;
		int yTile = (y-50)/24;

		Grid._selectedTile = Grid._grid[xTile][yTile];

		System.out.println("X Corner :" + xTile + " Y Corner: " + yTile);
	}

	@Override
	public void handleKeyPressed(KeyEvent e) {
		if(Grid._selectedTile != null){
			prompt = "Press Space to finish";
			int x1 = Grid._selectedTile._xIndex*24+50;
			int y1 = Grid._selectedTile._yIndex*24+50;
			int x2 = x1;
			int y2 = y1;
			boolean isAddition = true;
			switch(e.getKeyCode())
			{
			case KeyEvent.VK_UP:
				System.out.println("UP!");
				x2 = x1+24;
				y2 = y1;
				isAddition = Grid._selectedTile.set_walls(Tile.UP);
				continueConfirm = false;
				break;
			case KeyEvent.VK_DOWN:
				System.out.println("DOWN!");
				x2 = x1 + 24;
				y1 = y2 = y1+24;
				isAddition = Grid._selectedTile.set_walls(Tile.DOWN);
				continueConfirm = false;
				break;
			case KeyEvent.VK_LEFT:
				System.out.println("LEFT!");
				x2 = x1;
				y2 = y1+24;
				isAddition = Grid._selectedTile.set_walls(Tile.LEFT);
				continueConfirm = false;
				break;
			case KeyEvent.VK_RIGHT:
				System.out.println("RIGHT!");
				x1 = x2 = x1+24;
				y2 = y1+24;
				isAddition = Grid._selectedTile.set_walls(Tile.RIGHT);
				continueConfirm = false;
				break;
			case KeyEvent.VK_SPACE:
				if(continueConfirm){
					Grid._selectedTile = null;
					setNewState(new PositionCharState());
				}
				else{
					prompt = "Press Space again to confirm";
					continueConfirm = true;
				}
				break;
			default:
				System.out.println("Some other key...");
				continueConfirm = false;
			}
			if(isAddition){
				Grid._walls.add(new Wall(x1,y1,x2,y2));
			}
			else{
				for(Wall wl:Grid._walls){
					if(wl.isEqual(x1, y1, x2, y2)){
						Grid._walls.remove(wl);
						break;
					}
				}
			}
			
		}
		else{
			System.err.println("FUCCCCCKKKKKKKKKK");
		}
	}
}

package src.dnd.map;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public interface State {
	
	public void render(Graphics g);

	public void handleClick(int x, int y);
	
	public void handleKeyPressed(KeyEvent e);
}

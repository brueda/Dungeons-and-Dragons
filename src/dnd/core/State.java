package src.dnd.core;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public abstract class State {
	
	public abstract void render(Graphics g);

	public abstract void handleClick(int x, int y);
	
	public abstract void handleKeyPressed(KeyEvent e);
	
	public void setNewState(State s){
		StartClass._curState = s;
	}
}

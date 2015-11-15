package dnd.sheet;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dnd.core.StartClass;
import dnd.core.State;
import dnd.map.CreateWallState;
import dnd.util.FreshPlayerParser;

public class CreateCharacterState extends State {

	public CreateCharacterState() {
		StartClass._chars = new FreshPlayerParser().generateFreshCharacters();
	}

	@Override
	public void render(Graphics g) {
		setNewState(new CreateWallState());
	}

	@Override
	public void handleClick(int x, int y) {
		
	}

	@Override
	public void handleKeyPressed(KeyEvent e) {

	}

}

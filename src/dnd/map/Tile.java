package src.dnd.map;


public class Tile {
	public final static int LEFT = 0;
	public final static int RIGHT = 1;
	public final static int UP = 2;
	public final static int DOWN = 3;
	
	private boolean _walls[];
	public final int _xIndex;
	public final int _yIndex;
	
	public Tile(int x, int y){
		_walls = new boolean[4];
		_xIndex = x;
		_yIndex = y;
	}

	public boolean[] get_walls() {
		return _walls;
	}

	public boolean set_walls(int i) {
		_walls[i] = !_walls[i];
		return _walls[i]; // false means deletion
	}

}

package dnd.map;


public class Tile {
	public final static int LEFT = 0;
	public final static int RIGHT = 1;
	public final static int UP = 2;
	public final static int DOWN = 3;
	
	private boolean _walls[];
	public final int _xIndex;
	public final int _yIndex;
	private boolean _occupied;
	
	public Tile(int x, int y){
		_walls = new boolean[4];
		_xIndex = x;
		_yIndex = y;
		_occupied = false;
	}

	public boolean[] get_walls() {
		return _walls;
	}

	public boolean set_walls(int i) {
		_walls[i] = !_walls[i];
		return _walls[i]; // false means deletion
	}

	public boolean is_occupied() {
		return _occupied;
	}

	public void set_occupied(boolean _occupied) {
		this._occupied = _occupied;
	}

}

package dnd.map;


public class Tile {
	private final int LEFT = 0;
	private final int RIGHT = 1;
	private final int UP = 2;
	private final int DOWN = 3;
	
	private boolean _walls[];
	
<<<<<<< Updated upstream
	public Tile(){
		_walls = new boolean[4];
=======
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
>>>>>>> Stashed changes
	}
	
	
	
	
	

	public boolean is_occupied() {
		return _occupied;
	}

	public void set_occupied(boolean _occupied) {
		this._occupied = _occupied;
	}

}

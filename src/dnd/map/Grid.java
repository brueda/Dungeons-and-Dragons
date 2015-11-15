package src.dnd.map;

public class Grid {
	public static Tile[][] _grid = new Tile[25][25];

	public static void initialize(){
		for(int b=0; b<25; b++){
			for(int p=0; p<25; p++){
				_grid[b][p] = new Tile(b,p);
			}
		}
	}

}

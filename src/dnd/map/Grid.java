package dnd.map;

import java.util.ArrayList;

public class Grid {
	public static Tile[][] _grid = new Tile[25][25];
	public static ArrayList<Wall> _walls = new ArrayList<Wall>();
	public static ArrayList<CharImage> _charImage = new ArrayList<CharImage>();
	public static Tile _selectedTile;
	public static void initialize(){
		for(int b=0; b<25; b++){
			for(int p=0; p<25; p++){
				_grid[b][p] = new Tile(b,p);
			}
		}
	}

}

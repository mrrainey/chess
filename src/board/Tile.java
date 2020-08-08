package board;
import pieces.Piece;

public class Tile {
	int x;
	int y;
	Piece piece = null;
	
	/*
	 * 0,0 0,1 0,2
	 * 1,0
	 */
	public Tile(int _x, int _y) {
		x = _x;
		y = _y;
	}
}

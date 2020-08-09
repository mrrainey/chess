package board;
import pieces.Piece;

public class Tile {
	private int x;
	private int y;
	private Piece piece = null;
	
	/*
	 * 0,0 0,1 0,2
	 * 1,0
	 */
	public Tile(int _x, int _y) {
		setX(_x);
		setY(_y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	
}

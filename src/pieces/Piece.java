package pieces;

public class Piece {
	private Tile currentTile;
	
	public Piece(Tile t) {
		this.currentTile = t;
	}
	
	public void move(Tile t) {
		
	}
	
	public abstract boolean canMove(Tile t);
}

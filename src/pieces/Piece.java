package pieces;

import board.Tile;

/**
 * @author Saul
 *
 */
public abstract class Piece {
	private Tile currentTile;
	
	public Piece(Tile t) {
		this.currentTile = t;
	}
	
	
	/**
	 * @param t 
	 * 
	 * 
	 */
	public void move(Tile t) {
		
	}
	
	public abstract boolean canMove(Tile t);
}

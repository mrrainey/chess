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
	 * Moves the piece to a tile
	 * @param t The tile to move to
	 *  
	 */
	public boolean move(Tile t) {
		if (canMove(t)) {
			currentTile = t;
			return true;
		}
		return false;
	}
	
	/**
	 * Determines whether a piece can legally move to a tile
	 * @param t The tile test for a legal movement
	 * @return true if the piece can legally move to the tile, false if not
	 * 
	 */
	public abstract boolean canMove(Tile t);
}

package pieces;

import board.Tile;

public class Bishop extends Piece {

	public Bishop(Tile t) {
		super(t);
	}

	@Override
	public boolean canMove(Tile t) {
		// movement logic
		return false;
	}
	
	
}

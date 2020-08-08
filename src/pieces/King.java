package pieces;

import board.Tile;

public class King extends Piece {

	public King(Tile t) {
		super(t);
	}

	@Override
	public boolean canMove(Tile t) {
		// movement logic
		return false;
	}
	
	
}

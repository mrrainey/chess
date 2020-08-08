package pieces;

import board.Tile;

public class Knight extends Piece {

	public Knight(Tile t) {
		super(t);
	}

	@Override
	public boolean canMove(Tile t) {
		// movement logic
		return false;
	}
	
	
}

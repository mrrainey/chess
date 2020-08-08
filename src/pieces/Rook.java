package pieces;

import board.Tile;

public class Rook extends Piece {

	public Rook(Tile t) {
		super(t);
	}

	@Override
	public boolean canMove(Tile t) {
		// movement logic
		return false;
	}
	
	
}

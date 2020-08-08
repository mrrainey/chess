package pieces;

import board.Tile;

public class Queen extends Piece {

	public Queen(Tile t) {
		super(t);
	}

	@Override
	public boolean canMove(Tile t) {
		// movement logic
		return false;
	}
	
	
}

package pieces;

import board.Tile;

public class Pawn extends Piece {

	public Pawn(Tile t) {
		super(t);
	}

	@Override
	public boolean canMove(Tile t) {
		// pawn movement logic
		return false;
	}
	
	
}

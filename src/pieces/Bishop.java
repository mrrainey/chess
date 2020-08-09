package pieces;

import board.Tile;
import player.Player;

public class Bishop extends Piece {


	public Bishop(Player player, Tile tile) {
		super(player, tile);
	}

	public Bishop(Tile t) {
		super(t);
	}

	@Override
	public boolean canMove(Tile t) {
		// movement logic
		return false;
	}
	
	
}

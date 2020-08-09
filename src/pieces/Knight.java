package pieces;

import board.Tile;
import player.Player;

public class Knight extends Piece {


	public Knight(Player player, Tile tile) {
		super(player, tile);
	}

	public Knight(Tile t) {
		super(t);
	}

	@Override
	public boolean canMove(Tile t) {
		// movement logic
		return false;
	}
	
	
}

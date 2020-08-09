package pieces;

import board.Tile;
import player.Player;

public class Queen extends Piece {


	public Queen(Player player, Tile tile) {
		super(player, tile);
		// TODO Auto-generated constructor stub
	}

	public Queen(Tile t) {
		super(t);
	}

	@Override
	public boolean canMove(Tile t) {
		// movement logic
		return false;
	}
	
	
}

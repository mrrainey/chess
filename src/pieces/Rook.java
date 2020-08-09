package pieces;

import board.Tile;
import player.Player;

public class Rook extends Piece {


	public Rook(Player player, Tile tile) {
		super(player, tile);
		// TODO Auto-generated constructor stub
	}

	public Rook(Tile t) {
		super(t);
	}

	@Override
	public boolean canMove(Tile t) {
		// movement logic
		return false;
	}
	
	
}

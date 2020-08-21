package pieces;

import board.Tile;
import player.Player;
import utilities.Navigation;

public class Rook extends Piece {

	public Rook(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Tile target) {
		if (Navigation.isCardinal(getTile(), target)) {
			// if target is North, East, South or West from this piece

			Tile[] path = Navigation.getPath(getTile(), target);
			for (int i = 0; i < path.length; i++) {
				// for each tile in the path

				if (!path[i].isEmpty()) {
					// if tile contains a piece

					if (i < path.length) {
						// if tile is not the final tile in the path, return false
						return false;
					} else if (path[i].getPiece().getPlayer() == getPlayer()) {
						// if tile is the final tile in the path and contains a piece already owned by
						// this piece's owner, return false
						return false;
					}
				}
			}
		} else {
			// if target tile is not directly North, East, South or West, return false
			return false;
		}
		return true;
	}

}

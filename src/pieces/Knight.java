package pieces;

import board.Tile;
import player.Player;
import utilities.Navigation;

public class Knight extends Piece {

	public Knight(Player player) {
		super(player);
	}

	@Override
	public boolean canMove(Tile target) {
		final Tile[] path = Navigation.getKnightPath(getTile(), target);
		if (path != null) {
			if (!path[path.length - 1].isEmpty()) {
				if (path[path.length - 1].getPiece().getPlayer() == getPlayer()) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

}

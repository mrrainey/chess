package pieces;

import board.Tile;
import chess.Chess;
import player.Player;
import utilities.Navigation;
import utilities.Navigation.Direction;

public class Pawn extends Piece {

	public Pawn(final Player player) {
		super(player);
	}

	@Override
	public boolean canMove(Tile target) {
		Navigation.Direction dir = Navigation.getDirection(getTile(), target);
		int dist = Navigation.getDistance(getTile(), target);
		if (dir == (getPlayer() == Chess.getBoard().getPlayer1() ? Direction.South : Direction.North)) {
			if (target.isEmpty()) {
				if (dist == 1) {
					return true;
				} else if (dist == 2) {
					if (getMoves() == 0) {
						return true;
					}
				}
			}
		} else if (dir == (getPlayer() == Chess.getBoard().getPlayer1() ? Direction.SouthEast : Direction.NorthEast)
				|| dir == (getPlayer() == Chess.getBoard().getPlayer1() ? Direction.SouthWest : Direction.NorthWest)) {
			if (dist == 1) {
				if (!target.isEmpty()) {
					if (target.getPiece().getPlayer() != getPlayer()) {
						return true;
					}
				}
			}
		}
		return false;
	}

}

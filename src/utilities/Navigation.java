/**
 * 
 */
package utilities;

import board.Chessboard;
import board.Tile;
import chess.Chess;
import pieces.Knight;

/**
 * @author Saul
 *
 */
public class Navigation {

	public enum Direction {
		East, North, NorthEast, NorthWest, South, SouthEast, SouthWest, West
	}

	/**
	 * Used to determine if tile1 and tile2 are cardinal from each other
	 * (North/East/South/West).
	 * 
	 * @param tile1 the tile to compare with tile2 for direction
	 * @param tile2 the tile to compare with tile1 for direction
	 * @return <code>true</code> if tile1 and tile2 are cardinal of each other;<br>
	 *         <code>false</code> if they are not
	 */
	public static boolean isCardinal(Tile tile1, Tile tile2) {
		if (tile1.getX() == tile2.getX() || tile1.getY() == tile2.getY())
			return true;
		return false;
	}

	/**
	 * Used to determine if tile1 and tile2 are ordinal from each other (North
	 * East/North West/South East/South West).
	 * 
	 * @param tile1 the tile to compare with tile2 for direction
	 * @param tile2 the tile to compare with tile1 for direction
	 * @return <code>true</code> if tile1 and tile2 are ordinal of each other;<br>
	 *         <code>false</code> if they are not
	 */
	public static boolean isOrdinal(Tile tile1, Tile tile2) {
		if (tile2.getX() - tile1.getX() == tile2.getY() - tile1.getY()
				|| tile2.getX() - tile1.getX() == tile1.getY() - tile2.getY())
			return true;
		return false;
	}

	/**
	 * Generates a path (array of tiles) from the origin tile to the target tile.
	 * 
	 * @param origin the origin tile
	 * @param target the target tile to path to
	 * @return an array of tiles from the origin to the target, inclusive of the
	 *         target tile and exclusive of the origin
	 */
	public static Tile[] getPath(Tile origin, Tile target) {
		int dist = getDistance(origin, target);
		Tile[] path = new Tile[dist];
		switch (getDirection(origin, target)) {
			case East:
				for (int i = 0; i < dist; i++) {
					path[i] = Chess.getBoard().getTile(origin.getX(), origin.getY() + (i + 1));
				}
				return path;
			case North:
				for (int i = 0; i < dist; i++) {
					path[i] = Chess.getBoard().getTile(origin.getX() - (i + 1), origin.getY());
				}
				return path;
			case NorthEast:
				for (int i = 0; i < dist; i++) {
					path[i] = Chess.getBoard().getTile(origin.getX() - (i + 1), origin.getY() + (i + 1));
				}
				return path;
			case NorthWest:
				for (int i = 0; i < dist; i++) {
					path[i] = Chess.getBoard().getTile(origin.getX() - (i + 1), origin.getY() - (i + 1));
				}
				return path;
			case South:
				for (int i = 0; i < dist; i++) {
					path[i] = Chess.getBoard().getTile(origin.getX() + (i + 1), origin.getY());
				}
				return path;
			case SouthEast:
				for (int i = 0; i < dist; i++) {
					path[i] = Chess.getBoard().getTile(origin.getX() + (i + 1), origin.getY() + (i + 1));
				}
				return path;
			case SouthWest:
				for (int i = 0; i < dist; i++) {
					path[i] = Chess.getBoard().getTile(origin.getX() + (i + 1), origin.getY() - (i + 1));
				}
				return path;
			case West:
				for (int i = 0; i < dist; i++) {
					path[i] = Chess.getBoard().getTile(origin.getX(), origin.getY() + (i + 1));
				}
				return path;
		}
		return null;
	}

	/**
	 * Generates a path between two tiles for a Knight piece. Similar to
	 * {@code getPath()} except this returns one of two possible paths for a Knight.
	 * Since Knights can always potentially take two paths to get to the same target
	 * tile, this function supports generation of both.
	 * 
	 * @param origin the start tile
	 * @param target the tile to path to
	 * @return array of tiles to the target tile, excluding the origin, for a Knight
	 */
	public static Tile[] getKnightPath(final Tile origin, final Tile target) {
		final int x1 = origin.getX();
		final int x2 = target.getX();
		final int y1 = origin.getY();
		final int y2 = target.getY();
		final int distX = x2 - x1;
		final int distY = y2 - y1;
		final Chessboard board = Chess.getBoard();
		final Tile[] path1;
		final Tile[] path2;
		if (Math.abs(distX) == 1 && Math.abs(distY) == 2) {
			path1 = new Tile[] { board.getTile(x1, y1 + (distY / 2)), board.getTile(x1, y1 + distY),
					board.getTile(x1 + distX, y1 + distY) };
			path2 = new Tile[] { board.getTile(x1 + distX, y1), board.getTile(x1 + distX, y1 + (distY / 2)),
					board.getTile(x1 + distX, y1 + distY) };
			return path1;
		} else if (Math.abs(distX) == 2 && Math.abs(distY) == 1) {
			path1 = new Tile[] { board.getTile(x1 + (distX / 2), y1), board.getTile(x1 + distX, y1),
					board.getTile(x1 + distX, y1 + distY) };
			path2 = new Tile[] { board.getTile(x1, y1 + distY), board.getTile(x1 + (distX / 2), y1 + distY),
					board.getTile(x1 + distX, y1 + distY) };
			return path1;
		}
		/*
		 * TODO add support for player's choice between path1 and path2 because Knights
		 * can often take two different paths to get to the same tile.
		 * 
		 * For example if a Knight wants to move two tiles East and one tile North it
		 * can either move North then East(x2), or it can move East(x2) before moving
		 * North.
		 * 
		 * Due to this it may be advantageous to the player to choose one path over the
		 * other as one path may contain an enemy piece, or both paths may contain an
		 * enemy piece one of which may be more desirable to pwn. *
		 */

		return null;
	}

	/**
	 * Returns the direction required to travel to get from one tile to another
	 * tile.
	 * 
	 * @param origin the origin tile
	 * @param target the tile to get the direction of from the origin tile. This
	 *               tile must be directly ordinal (NE/NW/SE/SW) or cardinal
	 *               (N/E/S/W) from the origin tile
	 * @return the direction from the origin tile to the target, or
	 *         <code>null</code> if the target tile is not directly ordinal or
	 *         cardinal to the origin tile
	 */
	public static Direction getDirection(Tile origin, Tile target) {
		int x1 = origin.getX();
		int y1 = origin.getY();
		int x2 = target.getX();
		int y2 = target.getY();
		int dx = x2 - x1;
		int dy = y2 - y1;

		// cardinal directions
		if (dx == 0)
			if (y1 < y2)
				return Direction.East;
			else if (y1 > y2)
				return Direction.West;
		if (dy == 0) {
			if (x1 < x2)
				return Direction.South;
			else if (x1 > x2)
				return Direction.North;
		}

		// ordinal directions
		if (dx == dy || dx == -dy) {
			if (x1 < x2)
				if (y1 < y2)
					return Direction.SouthEast;
				else if (y1 > y2)
					return Direction.SouthWest;
			if (x1 > x2)
				if (y1 < y2)
					return Direction.NorthEast;
				else if (y1 > y2)
					return Direction.NorthWest;
		}

		return null;
	}

	/**
	 * For testing and debugging purposes. This method is a quick way to print all
	 * the tiles in an array.
	 * 
	 * @param path the array of tiles to be printed
	 */
	public static void printPath(Tile[] path) {
		System.out.print("Path tiles: {");
		for (Tile tile : path) {
			System.out.print(tile + ",");
		}
		System.out.println("}");
	}

	/**
	 * Compares two tiles and returns the distance between them. If the tiles being
	 * compared are not cardinal (North/East/South/West) or ordinal
	 * (North-east/South-east/South-west/North-west) of each other then -1 will be
	 * returned.
	 * 
	 * @param from the start tile
	 * @param to   the end tile
	 * @return <code>int</code> value greater than or equal to <code>0</code>,
	 *         representing the distance between the start and end tiles; or
	 *         <code>-1</code> if the tiles are neither ordinal or cardinal of each
	 *         other
	 */
	public static int getDistance(Tile from, Tile to) {

		if (!isOrdinal(from, to) && !isCardinal(from, to))
			return -1;

		int distX = Math.abs(to.getX() - from.getX());
		int distY = Math.abs(to.getY() - from.getY());

		if (distX == distY)
			return distX;
		else if (distX == 0)
			return distY;
		else
			return distX;
	}
}

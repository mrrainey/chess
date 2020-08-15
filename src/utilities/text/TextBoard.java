package utilities.text;

import java.io.PrintStream;

import board.Chessboard;
import board.Tile;

public class TextBoard {
	private PrintStream out = System.out;
	private Chessboard board;
	private int tileSize;
	private Tile[][] tiles;
	private String lineBuffer = "";

	public TextBoard(Chessboard board, int tileSize) {
		this.board = board;
		this.tileSize = tileSize;
		this.setTiles(board.tiles);
	}

	public void append(String text) {
		lineBuffer = lineBuffer + text;
	}

	public String centre(String text, int width) {
		return null;
	}

	public void flush() {
		System.out.println(lineBuffer);
		lineBuffer = "";
	}

	/**
	 * Gets the current <code>Chessboard</code> object.
	 * 
	 * @return the chessboard
	 */
	public Chessboard getBoard() {
		return board;
	}

	public int getBoardHeight() {
		return (getTileHeight() * tiles.length) + tiles.length + 1;
	}

	public int getBoardWidth() {
		return (getTileWidth() * tiles[0].length) + tiles[0].length + 1;
	}

	public int getTileHeight() {
		return tileSize;
	}

	/**
	 * @return the tiles
	 */
	public Tile[][] getTiles() {
		return tiles;
	}

	public int getTileWidth() {
		return tileSize * 2;
	}

	public void print() {
		String buffer = "";
		Tile[][] tiles = getTiles();
		int numRows = tiles.length;
		for (int row = 0; row < numRows; row++) {
			buffer = buffer + getRowText(row);
		}
		out.println(buffer);
	}

	public String getRowText(int row) {
		Tile[] tiles = getTiles()[row];
		TextTile[] textTiles = new TextTile[tiles.length];
		for (int tile = 0; tile < tiles.length; tile++) {
			TextTile tt = new TextTile(tiles[tile], tileSize+1, tileSize*2, TextTile.Border.North, TextTile.Border.West);
			if (!tiles[tile].isEmpty())
				tt.setText(tiles[tile].getPiece().toString().substring(0, 4));
			else 
				tt.setText("");
			tt.generate();
			textTiles[tile] = tt;
		}
		TextRow textRow = new TextRow(textTiles);
		return textRow.getBody();
	}

	public void printTile(int tile) {
		for (int i = 0; i < tileSize; i++) {
			if (i == 0) {
				append("+");
				append("-".repeat(tileSize));
			}
		}
	}

	/**
	 * @param tiles the tiles to set
	 */
	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}

	private class BoardTile {
		public String[] lines;

	}
}

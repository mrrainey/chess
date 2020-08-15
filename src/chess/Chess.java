package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

import board.*;
import pieces.Piece;
import player.Player;
import utilities.Colour;
import utilities.Navigation;
import utilities.text.TextBoard;

public class Chess {

	private static Chessboard board;
	private static TextBoard textBoard;

	public static void main(String args[]) {

		Random rand = new Random();
		int randNum = rand.nextInt(2);
		Colour p1Col = Colour.White;
		Colour p2Col = Colour.Black;

		Player p1;
		Player p2;

		if (randNum == 0) {
			p1 = new Player("Matthew", p1Col);
			p2 = new Player("Saul", p2Col);
		} else {
			p1 = new Player("Saul", p1Col);
			p2 = new Player("Matthew", p2Col);
		}

		setBoard(new Chessboard(p1, p2));
		textBoard = new TextBoard(getBoard(), 4);
		textBoard.print();

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		readCommand(br);
	}

	/**
	 * @return the board
	 */
	public static Chessboard getBoard() {
		return board;
	}

	/**
	 * @param board the board to set
	 */
	public static void setBoard(Chessboard board) {
		Chess.board = board;
	}

	/**
	 * Takes the input of the {@code BufferedReader} and interprets it. Intended to
	 * be used with {@code System.in} in order to take commands to test the Chess logic.
	 * 
	 * Allowed commands are:
	 * 
	 * @deprecated This method is used for testing purposes and is likely to be
	 *             removed in the future.
	 * @author Saul
	 * @param reader
	 * 
	 */
	@Deprecated
	public static void readCommand(BufferedReader reader) {
		try {
			String text = reader.readLine();
			Scanner s = new Scanner(text);
			if (s.next().equals("move")) {
				if (s.hasNext()) {
					String[] coord1 = s.next().split(",");
					int t1x = Integer.parseInt(coord1[0]);
					int t1y = Integer.parseInt(coord1[1]);
					Tile tile1 = getBoard().getTile(t1x, t1y);

					if (s.hasNext()) {
						String[] coord2 = s.next().split(",");
						int t2x = Integer.parseInt(coord2[0]);
						int t2y = Integer.parseInt(coord2[1]);
						Tile tile2 = getBoard().getTile(t2x, t2y);

						getBoard().move(tile1.getPiece(), tile2);
					}
				}
				textBoard.print();
			}
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		readCommand(reader);
	}
}

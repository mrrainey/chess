package player;

import utilities.Colour;

public class Player {
	
	private String name;
	private Colour colour;
	
	public Player(String _name, Colour _colour) {
		name = _name;
		colour = _colour;
	}

	public String getName() {
		return name;
	}

	public Colour getColour() {
		return colour;
	}
}

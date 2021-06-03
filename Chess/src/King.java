
/*
 *
 * Detection of standings, color status and position status for the king class.
 * */

public class King extends Piece {

	public King(Piece.Colour colour, int x, int y) {
		super(100, colour, x, y);
	}

	public String toString() {
		return "s" + Piece.colourToString(this.getColour());
	}
}

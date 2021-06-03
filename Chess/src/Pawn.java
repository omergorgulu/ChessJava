/*
 * 
 * Detection of standings, color status and position status for the Pawn class.
 * */


public class Pawn extends Piece {

	public Pawn(Piece.Colour colour, int x, int y) {
		super(1, colour, x, y);
	}

	public String toString() {
		return "p" + Piece.colourToString(this.getColour());
	}
}

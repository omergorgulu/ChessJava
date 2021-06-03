
/*
 * 
 * Detection of score status, color status and position status for the Knight class and 
 * calculation of the threat status according to its position.
 * */

public class Knight extends Piece {

	public Knight(Piece.Colour colour, int x, int y) {
		super(3, colour, x, y);
	}

	public String toString() {
		return "a" + Piece.colourToString(this.getColour());
	}

	/*
	 *chess piece marks threat 
	 */
	public void markThreats(Board board) {
		int[] position = this.getPosition();
		int[][] checklist = new int[8][2];

		checklist[0][0] = position[0] - 1;
		checklist[0][1] = position[1] - 2;
		checklist[1][0] = position[0] - 1;
		checklist[1][1] = position[1] + 2;
		checklist[2][0] = position[0] - 2;
		checklist[2][1] = position[1] - 1;
		checklist[3][0] = position[0] - 2;
		checklist[3][1] = position[1] + 1;
		checklist[4][0] = position[0] + 1;
		checklist[4][1] = position[1] - 2;
		checklist[5][0] = position[0] + 1;
		checklist[5][1] = position[1] + 2;
		checklist[6][0] = position[0] + 2;
		checklist[6][1] = position[1] - 1;
		checklist[7][0] = position[0] + 2;
		checklist[7][1] = position[1] + 1;

		for (int i = 0; i < 8; i++) {
			board.checkPiece(checklist[i][0], checklist[i][1], this.getColour());
		}
	}
}

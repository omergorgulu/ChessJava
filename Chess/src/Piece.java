/*
 * I thought of Pieces as an abstract class and here I defined the properties that I think are necessary.

 */

public abstract class Piece {
	
	public enum Colour {
        White, Black
    }

    private int value;
    private Colour colour;
    private int[] position;
    private boolean marked;


    Piece(int value, Colour colour, int x, int y) {
        this.value = value;
        this.colour = colour;
        this.position = new int[2];
        this.position[0] = x;
        this.position[1] = y;
        this.marked = false;
    }
    
    /**
     * convert char to enum
     */
    
    public static Colour convertColour(char colour) {
        if (colour == 'b') {
            return Colour.White;
        } else {
            return Colour.Black;
        }
    }
    
    /**
     * convert enum to char
     */
    public static String colourToString(Colour colour) {
        if (colour == Colour.White) {
            return "b";
        } else {
            return "s";
        }
    }


    public int getValue() {
        return this.value;
    }
    
    public Colour getColour() {
        return this.colour;
    }
    
    public int[] getPosition() {
        return this.position;
    }
    
    public boolean checkMarked() {
        return marked;
    }
    
    public void mark() {
        this.marked = true;
    }
    
    public abstract String toString();
    
    public void markThreats(Board board) {
	}
}
package model;

/**
 * Created by hell on 26/08/14.
 */
public class Cell implements ICell{

    public static enum CellState {NULL, ROOK, KNIGHT, BISHOP, QUEEN, KING, PAWN};

    //Fields
    private int i;
    private int j;
    private Cell.CellState status;
    private Piece piece;

    //Constructor
    public Cell(int x, int y, Cell.CellState initStatus, Piece piece) {
        i=x;
        j=y;
        status=initStatus;
        this.piece = piece;
    }
    //Getters and setters
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public Cell.CellState getStatus() {
        return status;
    }

    public void setStatus(Cell.CellState status) {
        this.status = status;
    }

    public void setPiece(Piece p) {

        this.piece = p;
    }

    // Interface methods
    @Override
    public boolean damageCell() {
        return false;
    }

    @Override
    public Piece getPiece() {
        return piece;
    }

    @Override
    public boolean isOccupied() {return (getStatus().equals(CellState.NULL)) ? false : true; }

    @Override
    public String toString() {
        String print = new String("");
        print = " *";
        if (isOccupied()) {
            if (Piece.ColorPiece.BLACK.equals(piece.getColor())) print="B";
            else print = "W";
            if (piece instanceof Pawn) print+="P";
            else if (piece instanceof Rook) print+="R";
            else if (piece instanceof Knight) print+="H";
            else if (piece instanceof King) print+="K";
            else if (piece instanceof Bishop) print +="B";
            else if (piece instanceof Queen) print += "Q";
        }
        return print;
    }
}

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
    private Piece p;

    //Constructor
    public Cell(int x, int y, Cell.CellState initStatus, Piece piece) {
        i=x;
        j=y;
        status=initStatus;
        this.p = piece;
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

    public void setP(Piece p) {
        this.p = p;
    }

    // Interface methods
    @Override
    public boolean damageCell() {
        return false;
    }

    @Override
    public Piece getPiece() {
        return p;
    }

    @Override
    public boolean isOccupied() {
        return false;
    }
}

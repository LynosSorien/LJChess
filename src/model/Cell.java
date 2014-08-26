package model;

/**
 * Created by hell on 26/08/14.
 */
public class Cell implements ICell{

    public enum CellState {NULL, ROOK, KNIGHT, BISHOP, QUEEN, KING, PAWN};

    //Fields
    int index;
    int i;
    int j;
    String status;

    //Constructor
    public Cell() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    // Interface methods
    @Override
    public boolean damageCell() {
        return false;
    }

    @Override
    public Piece getPiece() {
        return null;
    }

    @Override
    public boolean isOccupied() {
        return false;
    }
}

package model;

/**
 * Created by hell on 26/08/14.
 */
public class Cell implements ICell{

    public enum CellState {NULL, ROOK, KNIGHT, BISHOP, QUEEN, KING, PAWN};

    //Fields
    int i;
    int j;
    String status;
    boolean isCrownCell;
    boolean isMoveCell;
    //Constructor
    public Cell(int x, int y, String initStatus) {
        i=x;
        j=y;
        status=initStatus;
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

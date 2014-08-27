package model;

/**
 * Created by hell on 26/08/14.
 */
public class Cell implements ICell{

    public static enum CellState {NULL, ROOK, KNIGHT, BISHOP, QUEEN, KING, PAWN};
    public static enum ColorPiece {BLACK, WHITE};

    //Fields
    private int i;
    private int j;
    //String status;
    private Cell.CellState status;
    private boolean isCrownCell;

    public boolean isCrownCell() {
        return isCrownCell;
    }

    public void setCrownCell(boolean isCrownCell) {
        this.isCrownCell = isCrownCell;
    }

    public boolean isMoveCell() {
        return isMoveCell;
    }

    public void setMoveCell(boolean isMoveCell) {
        this.isMoveCell = isMoveCell;
    }

    private boolean isMoveCell;
    private Class<? extends Piece> p;
    private Cell.ColorPiece colorpiece;

    public ColorPiece getColorpiece() {
        return colorpiece;
    }

    public void setColorpiece(ColorPiece colorpiece) {
        this.colorpiece = colorpiece;
    }

    //Constructor
    public Cell(int x, int y, Cell.CellState initStatus, Class<? extends Piece> piece, Cell.ColorPiece color) {
        i=x;
        j=y;
        status=initStatus;
        this.p = piece;
        colorpiece = color;
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

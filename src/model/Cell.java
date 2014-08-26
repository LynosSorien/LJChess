package model;

/**
 * Created by hell on 26/08/14.
 */
public class Cell implements ICell{

    public enum CellState {NULL, ROOK, KNIGHT, BISHOP, QUEEN, KING, PAWN};

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

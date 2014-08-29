package view;

/**
 * Created by juanma on 28/08/14.
 */

import model.Pawn;

/**
 * Created by juanma on 28/08/14.
 */
public interface IMain {
    public static enum PieceType {PAWN,BISHOP,QUEEN,KING,ROOK,KNIGHT,NONE};
    public int selectPieceRow();
    public int selectPieceColumn();
    public void setMovement();
    public PieceType crownPawn(Pawn p);
}

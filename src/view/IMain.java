package view;

/**
 * Created by juanma on 28/08/14.
 */
import model.Pawn;
import model.Piece;
import model.Vector;

import java.util.List;

/**
 * Created by juanma on 28/08/14.
 */
public interface IMain {
    public static final int KNIGHT = 0;
    public static final int BISHOP = 1;
    public static final int ROOK = 2;
    public static final int QUEEN = 3;

    public static enum PieceType {PAWN,BISHOP,QUEEN,KING,ROOK,KNIGHT,NONE};
    public int selectPieceRow();
    public int selectPieceColumn();
    public <P extends Piece> void setMovement(List<Vector> possibleMoves, P piece);
    public PieceType crownPawn(Pawn p);
    public int getValueOf(PieceType pt);
}

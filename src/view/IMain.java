package view;

<<<<<<< HEAD
/**
 * Created by juanma on 28/08/14.
 */
public class IMain {
}
=======
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
>>>>>>> fac87036267656d47e56657c0bc4540527a4d9da

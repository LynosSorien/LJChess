package model;

import java.util.ArrayList;

/**
 * Created by hell on 26/08/14.
 */
public abstract class Piece {

    Cell cellused;
    ArrayList listPosibleMoves = new ArrayList();
    public abstract void pieceMovements();
    public abstract ArrayList getPosibleMoves();
}

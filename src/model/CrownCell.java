package model;

/**
 * Created by hell on 26/08/14.
 */
public class CrownCell extends Cell{
    public CrownCell(int x, int y, CellState initStatus, Piece piece) {
        super(x, y, initStatus, piece);
    }
    public boolean checkCell(Cell c, int x){
        boolean isIt = false;
        if (x==0 || x==7) isIt=true;
        return isIt;
    }
    //el peon se convierte en la pieza que se necesite
}

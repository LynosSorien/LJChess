package model;

/**
 * Created by hell on 26/08/14.
 */
public class Board implements IBoard{

    //Fields
    //Constructor
    public Board() {
        Cell board [][] = new Cell[8][8];

    }


    //Interface Methods
    @Override
    public Cell getCell() {
        return null;
    }

    @Override
    public boolean damageCell(int index) {
        return false;
    }

    @Override
    public boolean damageCell(int i, int j) {
        return false;
    }
}

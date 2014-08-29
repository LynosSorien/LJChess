package model;

/**
 * Created by hell on 26/08/14.
 */
public interface IBoard {
    public Cell getCell(int i, int j);
    public boolean damageCell(int index);
    public boolean damageCell(int i, int j);
    public Cell[][] getBoard();
}

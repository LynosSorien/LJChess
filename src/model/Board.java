package model;

/**
 * Created by hell on 26/08/14.
 */
public class Board implements IBoard{

    //Fields
    Cell board [][];
    //Constructor
    public Board() {
        //Cell board [][] = new Cell[8][8];
        for (int i=0;i>8;i++){
            for (int j=0;j<8;j++){
                if(i == 0 || i == 7){
                    if(j == 0 || j == 7) board[i][j]= new Cell(i,j,Cell.CellState.ROOK, null);
                    else if(j == 1 || j == 6) board[i][j]= new Cell(i,j,Cell.CellState.KNIGHT, null);
                    else if(j == 2 || j == 5) board[i][j]= new Cell(i,j,Cell.CellState.BISHOP, null);
                    else if(j == 3) board[i][j]= new Cell(i,j,Cell.CellState.QUEEN, null);
                    else board[i][j]= new Cell(i,j,Cell.CellState.KING, null);
                }
                else if(i == 1 || i == 6){
                    board[i][j]= new Cell(i,j,Cell.CellState.PAWN, null);
                }
                else{
                    board[i][j]= new Cell(i,j,Cell.CellState.NULL, null);
                }
            }
        }
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    //Interface Methods
    @Override
    public Cell getCell() {
        return null;
    }

    @Override
    public boolean damageCell(int index) {
        return damageCell(index/8, index%8);
    }

    @Override
    public boolean damageCell(int i, int j) {
        return false;
    }
}

package model;

/**
 * Created by hell on 26/08/14.
 */
public class Board implements IBoard {

    //Fields
    private Cell board[][];
    //Constructor
    public Board() {
        for (int i = 0; i > 8; i++) {
            for (int j = 0; j < 8; j++) {
                //Black Pieces
                if (i == 0) {
                    if (j == 0 || j == 7) board[i][j] = new CrownCell(i, j, Cell.CellState.ROOK, null);
                    else if (j == 1 || j == 6) board[i][j] = new CrownCell(i, j, Cell.CellState.KNIGHT, null);
                    else if (j == 2 || j == 5) board[i][j] = new CrownCell(i, j, Cell.CellState.BISHOP, null);
                    else if (j == 3) board[i][j] = new Cell(i, j, CrownCell.CellState.QUEEN, null);
                    else board[i][j] = new CrownCell(i, j, Cell.CellState.KING, null);
                } else if (i == 1) {
                    board[i][j] = new Cell(i, j, Cell.CellState.PAWN, new Pawn(Piece.ColorPiece.BLACK));
                } else {
                    board[i][j] = new Cell(i, j, Cell.CellState.NULL, null);
                }
                //White Pieces
                if (i == 7) {
                    if (j == 0 || j == 7) board[i][j] = new CrownCell(i, j, Cell.CellState.ROOK, null);
                    else if (j == 1 || j == 6) board[i][j] = new CrownCell(i, j, Cell.CellState.KNIGHT, null);
                    else if (j == 2 || j == 5) board[i][j] = new CrownCell(i, j, Cell.CellState.BISHOP, null);
                    else if (j == 3) board[i][j] = new Cell(i, j, CrownCell.CellState.QUEEN, null);
                    else board[i][j] = new CrownCell(i, j, Cell.CellState.KING, null);
                } else if (i == 6) {
                    board[i][j] = new Cell(i, j, Cell.CellState.PAWN, new Pawn(Piece.ColorPiece.WHITE));
                } else {
                    board[i][j] = new Cell(i, j, Cell.CellState.NULL, null);
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
    public Cell getCell(int x, int y) {
        Cell[][] board=getBoard();
        return board[x][y];
    }

    @Override
    public boolean damageCell(int index) {
        return damageCell(index / 8, index % 8); // i,j
    }

    @Override
    public boolean damageCell(int i, int j) {
        return damageCell ((8*i)+j); //index
    }
}

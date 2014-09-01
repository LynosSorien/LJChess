package model;

/**
 * Created by hell on 26/08/14.
 */
public class Board implements IBoard {

    //Fields
    private Cell board[][];
    //Constructor
    public Board() {
        System.out.println("Board constructor");
        board = new Cell[8][8];
        CrownCell cc;
        Cell c;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //Black Pieces
                if (i == 0) {
                    if (j == 0 || j == 7) board[i][j] = (cc = new CrownCell(i, j, Cell.CellState.ROOK, new Rook(Piece.ColorPiece.BLACK))).getPiece().setActualCell(cc);
                    else if (j == 1 || j == 6) board[i][j] = (cc = new CrownCell(i, j, Cell.CellState.KNIGHT, new Knight(Piece.ColorPiece.BLACK))).getPiece().setActualCell(cc);
                    else if (j == 2 || j == 5) board[i][j] = (cc = new CrownCell(i, j, Cell.CellState.BISHOP, new Bishop(Piece.ColorPiece.BLACK))).getPiece().setActualCell(cc);
                    else if (j == 3) board[i][j] = (cc = new CrownCell(i, j, CrownCell.CellState.QUEEN, new Queen(Piece.ColorPiece.BLACK))).getPiece().setActualCell(cc);
                    else board[i][j] = (cc = new CrownCell(i, j, Cell.CellState.KING, new King(Piece.ColorPiece.BLACK))).getPiece().setActualCell(cc);
                }
                else if (i == 1) board[i][j] = (c = new Cell(i, j, Cell.CellState.PAWN, new Pawn(Piece.ColorPiece.BLACK))).getPiece().setActualCell(c);
                //White Pieces
                else if (i == 7) {
                    if (j == 0 || j == 7) board[i][j] = (c = new CrownCell(i, j, Cell.CellState.ROOK, new Rook(Piece.ColorPiece.WHITE))).getPiece().setActualCell(c);
                    else if (j == 1 || j == 6) board[i][j] = (c = new CrownCell(i, j, Cell.CellState.KNIGHT, new Knight(Piece.ColorPiece.WHITE))).getPiece().setActualCell(c);
                    else if (j == 2 || j == 5) board[i][j] = (c = new CrownCell(i, j, Cell.CellState.BISHOP, new Bishop(Piece.ColorPiece.WHITE))).getPiece().setActualCell(c);
                    else if (j == 3) board[i][j] = (c = new Cell(i, j, CrownCell.CellState.QUEEN, new Queen(Piece.ColorPiece.WHITE))).getPiece().setActualCell(c);
                    else board[i][j] = (c = new CrownCell(i, j, Cell.CellState.KING, new King(Piece.ColorPiece.WHITE))).getPiece().setActualCell(c);
                }
                else if (i == 6) board[i][j] = (c = new Cell(i, j, Cell.CellState.PAWN, new Pawn(Piece.ColorPiece.WHITE))).getPiece().setActualCell(c);
                //Empty Pieces
                else board[i][j] = new Cell(i, j, Cell.CellState.NULL, null);
            }
        }
        System.out.println("Board Construction ended!");
        System.out.println(this);
    }
    @Override
    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    //Interface Methods
    @Override
    public Cell getCell(int x, int y) {
        //Cell[][] board=getBoard();
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

    @Override
    public String toString() {
        String print= new String("#############BOARD#############\n");
        print+="  0  1  2  3  4  5  6  7\n";
        for(int i = 0;i<board.length;i++) {
            print+=i+" ";
            for(int j = 0; j<board[i].length;j++) {
                print+=board[i][j]+" ";
            }
            print+="\n";
        }
        print+="###############################";
        return print;
    }
}

package control;

import model.Board;
import model.Piece;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 26/08/14.
 */
public class DataControl {
    private Board board;
    private List<P extends Piece> white;
    private List<P extends Piece> black;

    public DataControl(){
        this.board = new Board();
        this.white = new ArrayList<Piece>();
        this.black = new ArrayList<Piece>();
    }

    public Board getBoard(){
        return this.board;
    }
}

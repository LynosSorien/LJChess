package control;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 26/08/14.
 */
public class GameControl extends Thread{
    private Board board;
    private List white;
    private List black;

    public GameControl(){
        this.board = new Board();
        this.white = new ArrayList<Piece>();
        this.black = new ArrayList<Piece>();
    }

    public Board getBoard(){
        return this.board;
    }
}

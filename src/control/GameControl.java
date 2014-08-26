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
    private enum VictoryConditions {WIN,LOSE,DRAW,NONE}

    public GameControl(){
        this.board = new Board();
        this.white = new ArrayList<Piece>();
        this.black = new ArrayList<Piece>();
    }

    @Override
    public void run(){

    }

    public Board getBoard(){
        return this.board;
    }
}

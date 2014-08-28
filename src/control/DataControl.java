package control;

import model.Board;
import model.IBoard;
import model.Piece;
import model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 26/08/14.
 */
public class DataControl {
    private IBoard board;
    private Player player1;
    private Player player2;
    private List<? extends Piece> white;
    private List<? extends Piece> black;

    public DataControl(){
        this.board = new Board();
        this.white = new ArrayList<Piece>();
        this.black = new ArrayList<Piece>();
    }

    public IBoard getBoard(){
        return this.board;
    }

    public void setPlayerName(int i, String name){
        if (i==0)this.player1.setName(name);
        else    this.player2.setName(name);
    }

    public String getPlayerName(int i){
        if (i==0)return this.player1.getName();
        else    return this.player2.getName();
    }
}

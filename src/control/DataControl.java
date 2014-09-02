package control;

import model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 26/08/14.
 */
public class DataControl {
    private IBoard board;
    private Player player1;
    private Player player2;

    public DataControl(){
        this.board = new Board();
        this.player1 = new Player("Itachi", Piece.ColorPiece.BLACK,(King)this.board.getCell(0,4).getPiece());
        for (int i=0;i<2;i++){
            for (int j=0;j<8;j++){
                this.player1.setAlivePieces(this.board.getCell(i,j).getPiece());
            }
        }
        this.player2 = new Player("Madara", Piece.ColorPiece.WHITE,(King)this.board.getCell(7,4).getPiece());
        for (int i=6;i<8;i++){
            for (int j=0;j<8;j++){
                this.player2.setAlivePieces(this.board.getCell(i,j).getPiece());
            }
        }
    }

    public Board getBoard(){
        return (Board)this.board;
    }

    public void setPlayerName(int i, String name){
        if (i==0)this.player1.setName(name);
        else    this.player2.setName(name);
    }

    public String getPlayerName(int i){
        if (i==0)return this.player1.getName();
        else    return this.player2.getName();
    }

    /**
     *
     * @param turn if true white, else black
     * @return
     */
    public Player getPlayer(boolean turn){
        if (turn) return this.player2;
        else return this.player1;
    }

}

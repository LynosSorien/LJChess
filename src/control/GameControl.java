package control;

import model.Piece;
import model.Vector;
import view.IMain;

import java.util.List;

/**
 * Created by david on 26/08/14.
 */
public class GameControl extends Thread{
    private enum Turn {WHITE,BLACK}
    private enum VictoryConditions {WIN,LOSE,DRAW, PLAY}

    private Turn turn;
    private VictoryConditions state;

    private DataControl dataControl;
    private IMain main;

    public GameControl(DataControl dc, IMain m){
        this.turn = Turn.WHITE;
        this.state = VictoryConditions.PLAY;
        this.dataControl = dc;
        this.main = m;
    }

    @Override
    public void run(){
        int row,column;
        boolean choose = false;
        Piece p;
        do {
            System.out.println(this.dataControl.getBoard());
            System.out.println("WHITE DeadPieces: "+this.dataControl.getPlayer(true).getDeadPieces());
            System.out.println("BLACK DeadPieces: "+this.dataControl.getPlayer(false).getDeadPieces()+"\n");
            System.out.println("WHITE AlivePieces: "+this.dataControl.getPlayer(true).getAlivePieces());
            System.out.println("BLACK AlivePieces: "+this.dataControl.getPlayer(false).getAlivePieces()+"\n");
            if (this.turn == Turn.WHITE){
                System.out.println("WHITE TURN");
                do {
                    boolean correctPiece = false;
                    do {
                        row = 0;
                        column = 0;
                        row = main.selectPieceRow();
                        column = main.selectPieceColumn();
                        p = this.dataControl.getBoard().getCell(row, column).getPiece();
                        if (p != null) {
                            if (p.getColor().equals(Piece.ColorPiece.WHITE)) {
                                correctPiece = true;
                            } else System.out.println("Choose a piece of your color");
                        } else System.out.println("Choose a piece");
                    } while (!correctPiece);
                    if (p != null) {
                        p.pieceMovements(dataControl.getBoard());
                        List<Vector> pieceMovements = p.getPosibleMoves(this.dataControl.getBoard());
                        choose = main.setMovement(pieceMovements, p);
                    }
                }while (!choose);
                //if (this.checkVictory())this.state = VictoryConditions.WIN;
                this.turn = Turn.BLACK;
            }else if (this.turn == Turn.BLACK){
                System.out.println("BLACK TURN");
                do {
                    boolean correctPiece = false;
                    do {
                        row = 0;
                        column = 0;
                        row = main.selectPieceRow();
                        column = main.selectPieceColumn();
                        p = this.dataControl.getBoard().getCell(row, column).getPiece();
                        if (p != null) {
                            if (p.getColor().equals(Piece.ColorPiece.BLACK)) {
                                correctPiece = true;
                            } else System.out.println("Choose a piece of your color");
                        } else System.out.println("Choose a piece");
                    } while (!correctPiece);
                    if (p != null) {
                        p.pieceMovements(dataControl.getBoard());
                        List<Vector> pieceMovements = p.getPosibleMoves(this.dataControl.getBoard());
                        choose = main.setMovement(pieceMovements, p);
                    }
                }while (!choose);
                //if (this.checkVictory())this.state = VictoryConditions.WIN;
                this.turn = turn.WHITE;
            }
        }while (this.state == VictoryConditions.PLAY);
        if (this.turn.equals(turn.WHITE))System.out.println("BLACK wins");
        else if (this.turn.equals(turn.BLACK))System.out.println("WHITE wins");
        else System.out.println("DRAW");
        System.out.println("Game ended.");
    }

    public boolean checkVictory(){
        System.out.println("CHECK VICTORY");
        boolean danger, ret = false;
        if (this.turn.equals(Turn.WHITE)){
            danger = this.dataControl.getPlayer(false).getKing().isInDanger(this.dataControl.getPlayer(true).getAlivePieces(),
                    this.dataControl.getBoard());
            if (danger) ret = this.dataControl.getPlayer(false).getKing().isCheckMate();
        }else if (this.turn.equals(Turn.BLACK)){
            danger = this.dataControl.getPlayer(true).getKing().isInDanger(this.dataControl.getPlayer(false).getAlivePieces(),
                    this.dataControl.getBoard());
            if (danger) ret = this.dataControl.getPlayer(true).getKing().isCheckMate();
        }
        return ret;
    }

    public void move(Vector v, Piece p){
        if (this.turn.equals(Turn.WHITE))
            p.movePiece(v.getX(),v.getY(),this.dataControl.getBoard(),this.dataControl.getPlayer(false));
        else
            p.movePiece(v.getX(),v.getY(),this.dataControl.getBoard(),this.dataControl.getPlayer(true));
    }

}

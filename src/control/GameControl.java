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
        Piece p;
        do {
            System.out.println(this.dataControl.getBoard());
            System.out.println(this.dataControl.getPlayer(true).getDeadPieces());
            System.out.println(this.dataControl.getPlayer(false).getDeadPieces());
            if (this.turn == Turn.WHITE){
                System.out.println("WHITE TURN");
                boolean correctPiece = false;
                do {
                    row = 0;
                    column = 0;
                    row = main.selectPieceRow();
                    column = main.selectPieceColumn();
                    p = this.dataControl.getBoard().getCell(row, column).getPiece();
                    if (p.getColor().equals(Piece.ColorPiece.WHITE)){
                        correctPiece = true;
                    }else System.out.println("Choose a piece of your color");
                }while(!correctPiece);
                if (p!=null) {
                    p.pieceMovements(dataControl.getBoard());
                    List<Vector> pieceMovements = p.getPosibleMoves(this.dataControl.getBoard());
                    main.setMovement(pieceMovements, p);
                }
                this.turn = Turn.BLACK;
            }else if (this.turn == Turn.BLACK){
                System.out.println("BLACK TURN");
                boolean correctPiece = false;
                do {
                    row = 0; column = 0;
                    row = main.selectPieceRow();
                    column = main.selectPieceColumn();
                    p = this.dataControl.getBoard().getCell(row, column).getPiece();
                    if (p.getColor().equals(Piece.ColorPiece.BLACK)){
                        correctPiece = true;
                    }else System.out.println("Choose a piece of your color");
                }while(!correctPiece);
                if(p!=null) {
                    p.pieceMovements(dataControl.getBoard());
                    List<Vector> pieceMovements = p.getPosibleMoves(this.dataControl.getBoard());
                    main.setMovement(pieceMovements,p);
                }
                this.turn = turn.WHITE;
            }
        }while (this.state == VictoryConditions.PLAY);
        System.out.println("Game ended.");
    }

    public void move(Vector v, Piece p){
        if (this.turn.equals(Turn.WHITE))
            p.movePiece(v.getX(),v.getY(),this.dataControl.getBoard(),this.dataControl.getPlayer(true));
        else
            p.movePiece(v.getX(),v.getY(),this.dataControl.getBoard(),this.dataControl.getPlayer(false));
    }

}

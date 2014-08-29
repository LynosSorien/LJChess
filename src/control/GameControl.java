package control;

import view.IMain;

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
        do {
            System.out.println(this.dataControl.getBoard());
            if (this.turn == Turn.WHITE){
                row = 0; column = 0;
                row = main.selectPieceRow();
                column = main.selectPieceColumn();
                this.dataControl.getBoard().getCell(row,column).getPiece().pieceMovements();
                main.setMovement();
                this.turn = Turn.BLACK;
            }else if (this.turn == Turn.BLACK){
                row = 0; column = 0;
                row = main.selectPieceRow();
                column = main.selectPieceColumn();
                this.dataControl.getBoard().getCell(row,column).getPiece().pieceMovements();
                main.setMovement();
                this.turn = turn.WHITE;
            }
        }while (this.state == VictoryConditions.PLAY);
        System.out.println("Game ended.");
    }


}

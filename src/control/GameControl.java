package control;

import view.Main;

/**
 * Created by david on 26/08/14.
 */
public class GameControl extends Thread{
    private enum Turn {WHITE,BLACK}
    private enum VictoryConditions {WIN,LOSE,DRAW, PLAY}

    private Turn turn;
    private VictoryConditions state;

    private DataControl dataControl;
    private Main main;

    public GameControl(DataControl dc,Main m){
        this.turn = Turn.WHITE;
        this.state = VictoryConditions.PLAY;
        this.dataControl = dc;
        this.main = m;
    }

    @Override
    public void run(){
        int row,column;
        do {
            if (this.turn == Turn.WHITE){
                row = 0; column = 0;
                row = main.selectPieceRow();
                column = main.selectPieceColumn();
                this.dataControl.getBoard().getCell(row,column).getPiece().pieceMovements();
                main.setMovement();
            }else if (this.turn == Turn.BLACK){
                row = 0; column = 0;
                row = main.selectPieceRow();
                column = main.selectPieceColumn();
                this.dataControl.getBoard().getCell().getPiece().pieceMovements();
            }
        }while (this.state == VictoryConditions.PLAY);
        System.out.println("Game ended.");
    }


}

package control;

/**
 * Created by david on 26/08/14.
 */
public class GameControl extends Thread{
    private enum Turn {WHITE,BLACK}
    private enum VictoryConditions {WIN,LOSE,DRAW, PLAY}
    private DataControl dataControl;
    private Turn turn;
    private VictoryConditions state;

    public GameControl(DataControl dc){
        this.turn = Turn.WHITE;
        this.state = VictoryConditions.PLAY;
        this.dataControl = dc;
    }

    @Override
    public void run(){
        do {
            if (this.turn == Turn.WHITE){
                this.dataControl.getBoard().getCell().getPiece().pieceMovements();
            }else if (this.turn == Turn.BLACK){
                this.dataControl.getBoard().getCell().getPiece().pieceMovements();
            }
        }while (this.state == VictoryConditions.PLAY);
        System.out.println("Game ended.");
    }
}

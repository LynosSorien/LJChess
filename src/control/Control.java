package control;

import model.Piece;
import model.Vector;
import view.IMain;

/**
 * Created by david on 26/08/14.
 */
public class Control {
    private GameControl gameControl;
    private DataControl dataControl;
    private IMain main;

    public Control (IMain m){
        this.main = m;
        this.dataControl = new DataControl();
        this.gameControl = new GameControl(this.dataControl, this.main);
    }

    /*
        GAMECONTROL METHODS
     */
    public void startGame(){
        this.gameControl.start();
    }

    public void setMovement(Vector v, Piece p){
        this.gameControl.move(v,p);
    }

    /*
        DATACONTROL METHODS
     */

    public void printBoard(){
        System.out.println(this.dataControl.getBoard());
    }

    public String getPlayerName(int i){
        return this.dataControl.getPlayerName(i);
    }

    public void setPlayerName(int i, String name){
        this.dataControl.setPlayerName(i,name);
    }
}

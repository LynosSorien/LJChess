package control;

/**
 * Created by david on 26/08/14.
 */
public class Control {
    private GameControl gameControl;
    private DataControl dataControl;

    public Control (){
        this.gameControl = new GameControl();
        this.dataControl = new DataControl();
    }

    /*
        GAMECONTROL METHODS
     */

    public void startGame(){
        this.gameControl.start();
    }

    /*
        DATACONTROL METHODS
     */
}

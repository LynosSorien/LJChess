package control;

/**
 * Created by david on 26/08/14.
 */
public class Control {
    private GameControl gameControl;
    private DataControl dataControl;
    private Main main;

    public Control (){
        this.dataControl = new DataControl();
        this.gameControl = new GameControl(this.dataControl, this.main);
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

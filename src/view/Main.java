package view;

import control.Control;
import model.Pawn;

import java.util.Scanner;

import static view.IMain.PieceType.ROOK;

/**
 * Created by juanma on 27/08/14.
 */
public class Main implements IMain {
    public static final int PLAY = 1;
    public static final int OPTIONS = 2;
    public static final int EXIT = 3;

    public static final int NAME1 = 1;
    public static final int NAME2 = 2;
    public static final int RETURN = 0;

    private static final int KNIGHT = 0;
    private static final int BISHOP = 1;
    private static final int ROOK = 2;
    private static final int QUEEN = 3;

    private int option;
    private Scanner sc;
    private Control ctrl;

    public Main(){
        ctrl = new Control(this);
        sc = new Scanner(System.in);
        LJChessInstance.instance().addListener((IMain)this);
    }

    public void printMenu(){
        System.out.println("############### MENU ##############");
        System.out.println(PLAY+". Play");
        System.out.println(OPTIONS+". Options");
        System.out.println(EXIT+". Exit");
        System.out.println("###################################");
    }

    public void printOptionMenu(){
        System.out.println("############# OPTIONS #############");
        System.out.println(NAME1+". Change player1 name's");
        System.out.println(NAME2+". Change player2 name's");
        System.out.println(RETURN+". Exit");
        System.out.println("###################################");
    }

    public void option(){
        do{
            printOptionMenu();
            option = Integer.parseInt(sc.nextLine());
            String name;
            switch(option){
                case NAME1:
                    System.out.println("Write the name of the player");
                    name = sc.nextLine();
                    ctrl.setPlayerName(NAME1,name);
                    break;
                case NAME2:
                    System.out.println("Write the name of the player");
                    name = sc.nextLine();
                    ctrl.setPlayerName(NAME2,name);
                    break;
                case RETURN:  break;
                default:
                    System.out.println("Incorrect option");
            }
        }while (option!=RETURN);
    }
    
    public void start() {
        do {
            printMenu();
            option = Integer.parseInt(sc.nextLine());
            switch(option) {
                case PLAY:
                    ctrl.startGame();
                    break;
                case OPTIONS:
                    option();
                    break;
                case EXIT:break;
                default:System.out.println("Incorrect Option");
            }
        } while(option!=EXIT);
        System.out.println("Thanks for playing!");
    }

    public static void main (String[] args){
        new Main().start();
    }

    @Override
    public int selectPieceRow() {
        int row;
        do {
            System.out.println("Choose the row of the chosen piece");
            row = Integer.parseInt(sc.nextLine());
        }while(row<0 || row>7);
        return row;
    }

    @Override
    public int selectPieceColumn() {
        int row;
        do {
            System.out.println("Choose the row of the chosen piece");
            row = Integer.parseInt(sc.nextLine());
        }while(row<0 || row>7);
        return row;
    }

    @Override
    public void setMovement() {

    }

    @Override
    public PieceType crownPawn(Pawn p) {
        PieceType pt;
        int choice;
        System.out.println("Choose piece to crown");
        System.out.println(KNIGHT+" - Knight\n"+BISHOP+" - Bishop\n"+ROOK+"- Rook\n"+QUEEN+" - Queen");
        choice = Integer.parseInt(sc.nextLine());
        switch(choice) {
            case 0:
                pt = PieceType.KNIGHT;
                break;
            case 1:
                pt = PieceType.BISHOP;
                break;
            case 2:
                pt = PieceType.ROOK;
                break;
            case 3:
                pt = PieceType.QUEEN;
                break;
            default:
                pt = PieceType.NONE;
                break;
        }
        return pt;
    }

    @Override
    public int getValueOf(PieceType pt) {
        if (pt.equals(PieceType.KNIGHT)) return KNIGHT;
        if (pt.equals(PieceType.BISHOP)) return BISHOP;
        if (pt.equals(PieceType.ROOK)) return ROOK;
        if (pt.equals(PieceType.QUEEN)) return QUEEN;
        return -1;
    }
}

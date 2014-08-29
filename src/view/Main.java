package view;

import control.Control;

import java.util.Scanner;

/**
 * Created by juanma on 27/08/14.
 */
public class Main implements IMain {
    public static final int PLAY = 1;
    public static final int OPTIONS = 2;
    public static final int EXIT = 3;

    public static final int NAME1 = 1;
    public static final int NAME2 = 2;

    private int option;
    private Scanner sc;
    private Control ctrl;

    public Main(){
        ctrl = new Control();
        sc = new Scanner(System.in);
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
        System.out.println(EXIT+". Exit");
        System.out.println("###################################");
    }

    public void option(){
        do{
            printOptionMenu();
            option = Integer.parseInt(sc.nextLine());
            System.out.println("Write the name of the player");
            String name = sc.nextLine();
            switch(option){
                case NAME1:
                    ctrl.setPlayerName(NAME1,name);
                    break;
                case NAME2:
                    ctrl.setPlayerName(NAME2,name);
                    break;
                default:
                    System.out.println("Incorrect option");
            }
        }while (option!=EXIT);
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
}

package view;

import control.Control;

import java.util.Scanner;

/**
 * Created by juanma on 27/08/14.
 */
public class Main {
    public static final int PLAY = 1;
    public static final int OPTIONS = 2;
    public static final int EXIT = 3;
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
    
    public void start() {
        do {
            printMenu();
            option = Integer.parseInt(sc.nextLine());
            switch(option) {
                case PLAY:
                    ctrl.startGame();
                    break;
                case OPTIONS:
                    // Set the player preferences
                    // Player name ....
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
}

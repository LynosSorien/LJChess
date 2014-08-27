package view;

import control.Control;

import java.util.Scanner;

/**
 * Created by juanma on 27/08/14.
 */
public class Main {
    private Scanner sc;
    private Control ctrl;

    public Main(){
        int option = -1;
        ctrl = new Control();

        option = Integer.parseInt(sc.nextLine());
    }

    public void menu(){
        System.out.println("############### MENU ##############");
        System.out.println("1. Play");
        System.out.println("2. Exit");
    }

    public void main (String[] args){
        new Main();
    }
}

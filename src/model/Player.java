package model;

import java.util.ArrayList;

/**
 * Created by hell on 28/08/14.
 */
public class Player {
    String name;
    Piece.ColorPiece color;
    int score; // por implementar
    ArrayList<Piece> deadPieces = new ArrayList<Piece>();
    public Player(String name, Piece.ColorPiece color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Piece.ColorPiece getColor() {
        return color;
    }

    public void setColor(Piece.ColorPiece color) {
        this.color = color;
    }

    public ArrayList<Piece> getDeadPieces() {
        return deadPieces;
    }

    public void setDeadPieces(ArrayList<Piece> deadPieces) {
        this.deadPieces = deadPieces;
    }
}

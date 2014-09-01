package model;

import java.util.ArrayList;

/**
 * Created by hell on 28/08/14.
 */
public class Player {
    String name;
    King king;
    Piece.ColorPiece color;
    int score; // por implementar
    ArrayList<Piece> deadPieces = new ArrayList<Piece>() {
        @Override
        public String toString() {
            String toReturn = new String("Dead Pieces: ");
            for (int i = 0; i<this.size();i++) {
                toReturn += this.get(i).toString()+" | ";
            }
            return toReturn;
        }
    };
    ArrayList<Piece> alivePieces = new ArrayList<Piece>() {
        @Override
        public String toString() {
            String toReturn = new String("Alive Pieces: ");
            for (int i = 0; i<this.size();i++) {
                toReturn += this.get(i).toString()+" | ";
            }
            return toReturn;
        }
    };

    public King getKing() {
        return king;
    }

    public void setKing(King king) {
        this.king = king;
    }

    public Player(String name, Piece.ColorPiece color, King king) {
        this.deadPieces = new ArrayList<Piece>();
        this.king = king;
        this.name = name;
        this.color = color;
        this.alivePieces = new ArrayList<Piece>();
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

    public ArrayList<Piece> getAlivePieces() {
        return alivePieces;
    }

    public void setAlivePieces(Piece p) {
        this.alivePieces.add(p);
    }

    public void removeAlivePiece(Piece p){
        this.alivePieces.remove(p);
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

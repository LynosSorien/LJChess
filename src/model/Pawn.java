package model;

import view.IMain;
import view.LJChessInstance;

import java.util.ArrayList;

/**
 * Created by hell on 26/08/14.
 */
public class Pawn extends Piece {
    private int row;
    private int col;
    public Pawn(ColorPiece color){
        super(color);
    }
    @Override
    public void pieceMovements(Board map) {
        row = actualCell.getI();
        col = actualCell.getJ();
        map.getBoard();
        //start = objective.getCell();
        if (color.equals(ColorPiece.BLACK)){
            nextCell=map.getCell(row+1,col);
            if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(row+1,col));
            if (firstTurn){
                nextCell=map.getCell(row+2,col);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(row+2,col));
            }
            if (col == 0){
                nextCell=map.getCell(row+1,col+1);
                if (nextCell.getStatus() != Cell.CellState.NULL) listPosibleMoves.add(new Vector(row+1,col+1));
            }
            else if (col == 7){
                nextCell=map.getCell(row+1,col-1);
                if (nextCell.getStatus() != Cell.CellState.NULL) listPosibleMoves.add(new Vector(row+1,col-1));
            }
            else{
                nextCell=map.getCell(row+1,col-1);
                if (nextCell.getStatus() != Cell.CellState.NULL) listPosibleMoves.add(new Vector(row+1,col-1));
                nextCell=map.getCell(row+1,col+1);
                if (nextCell.getStatus() != Cell.CellState.NULL) listPosibleMoves.add(new Vector(row+1,col+1));
            }
        }
        else {
            nextCell=map.getCell(row-1,col);
            if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(row-1,col));
            if (firstTurn){
                nextCell=map.getCell(row-2,col);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(row-2,col));
            }
            if (col == 0){
                nextCell=map.getCell(row-1,col+1);
                if (nextCell.getStatus() != Cell.CellState.NULL) listPosibleMoves.add(new Vector(row-1,col+1));
            }
            else if (col == 7){
                nextCell=map.getCell(row-1,col-1);
                if (nextCell.getStatus() != Cell.CellState.NULL) listPosibleMoves.add(new Vector(row-1,col-1));
            }
            else{
                nextCell=map.getCell(row-1,col-1);
                if (nextCell.getStatus() != Cell.CellState.NULL) listPosibleMoves.add(new Vector(row-1,col-1));
                nextCell=map.getCell(row-1,col+1);
                if (nextCell.getStatus() != Cell.CellState.NULL) listPosibleMoves.add(new Vector(row-1,col+1));
            }
        }
    }

    @Override
    public void movePiece(int x, int y, Board map, Player p){
        boolean checkIfCrown;
        firstTurn=false;
        actualCell.setStatus(Cell.CellState.NULL);
        actualCell.setPiece(null);
        actualCell=map.getCell(x,y);
        //comprobar si ay enemigos y matar
        if (actualCell.getStatus() != Cell.CellState.NULL){
            p.deadPieces.add(actualCell.getPiece());
            p.removeAlivePiece(actualCell.getPiece());
        }
        //comprobar si esta en CrownCell
        if (x==0){
            IMain.PieceType pt = LJChessInstance.instance().getMainListener().crownPawn(this);
            switch (LJChessInstance.instance().getMainListener().getValueOf(pt)){
                case IMain.ROOK:
                    actualCell.setStatus(Cell.CellState.ROOK);
                    actualCell.setPiece(new Rook(ColorPiece.WHITE));
                    break;
                case IMain.BISHOP:
                    actualCell.setStatus(Cell.CellState.BISHOP);
                    actualCell.setPiece(new Bishop(ColorPiece.WHITE));
                    break;
                case IMain.KNIGHT:
                    actualCell.setStatus(Cell.CellState.KNIGHT);
                    actualCell.setPiece(new Knight(ColorPiece.WHITE));
                    break;
                case IMain.QUEEN:
                    actualCell.setStatus(Cell.CellState.QUEEN);
                    actualCell.setPiece(new Queen(ColorPiece.WHITE));
                    break;
                default:
                    break;
            }


        }
        else if (x==7){
            IMain.PieceType pt = LJChessInstance.instance().getMainListener().crownPawn(this);
            switch (LJChessInstance.instance().getMainListener().getValueOf(pt)){
                case IMain.ROOK:
                    actualCell.setStatus(Cell.CellState.ROOK);
                    actualCell.setPiece(new Rook(ColorPiece.BLACK));
                    break;
                case IMain.BISHOP:
                    actualCell.setStatus(Cell.CellState.BISHOP);
                    actualCell.setPiece(new Bishop(ColorPiece.BLACK));
                    break;
                case IMain.KNIGHT:
                    actualCell.setStatus(Cell.CellState.KNIGHT);
                    actualCell.setPiece(new Knight(ColorPiece.BLACK));
                    break;
                case IMain.QUEEN:
                    actualCell.setStatus(Cell.CellState.QUEEN);
                    actualCell.setPiece(new Queen(ColorPiece.BLACK));
                    break;
                default:
                    break;
            }


        }

        else {//sino se mueve
            actualCell.setStatus(Cell.CellState.PAWN);
            actualCell.setPiece(this);
        }
    }

    @Override
    public String toString(){
        return "Pawn";
    }
}

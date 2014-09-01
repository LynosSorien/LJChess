package model;

import java.util.ArrayList;

/**
 * Created by hell on 28/08/14.
 */
public class Knight extends Piece {
    public Knight(ColorPiece color) {
        super(color);
    }

    @Override
    public void pieceMovements(Board map) {
        map.getBoard();
        int row = actualCell.getI();
        int col = actualCell.getJ();
        if(actualCell.getPiece().color == ColorPiece.BLACK) {
            if ((row - 2 >= 0 && row - 2 <= 7) && (col - 1 >= 0 && col - 1 <= 7)){
                nextCell=map.getCell(row-2,col-1);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(row-2,col-1));
                else if (nextCell.getPiece().color != ColorPiece.BLACK) listPosibleMoves.add(new Vector(row-2,col-1));
            }
            if ((row - 2 >= 0 && row - 2 <= 7) && (col + 1 >= 0 && col + 1 <= 7)){
                nextCell=map.getCell(row-2,col+1);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(row-2,col+1));
                else if (actualCell.getPiece().color != ColorPiece.BLACK) listPosibleMoves.add(new Vector(row-2,col+1));
            }
            if ((row - 1 >= 0 && row - 1 <= 7) && (col + 2 >= 0 && col + 2 <= 7)){
                nextCell=map.getCell(row-2,col+1);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(row-1,col+2));
                else if (actualCell.getPiece().color != ColorPiece.BLACK) listPosibleMoves.add(new Vector(row-1,col+2));
            }
            if ((row + 1 >= 0 && row + 1 <= 7) && (col + 2 >= 0 && col + 2 <= 7)){
                nextCell=map.getCell(row+1,col+2);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(row+1,col+2));
                else if (actualCell.getPiece().color != ColorPiece.BLACK) listPosibleMoves.add(new Vector(row+1,col+2));
            }
            if ((row + 2 >= 0 && row + 2 <= 7) && (col + 1 >= 0 && col + 1 <= 7)){
                nextCell=map.getCell(row+2,col+1);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(row+2,col+1));
                else if (actualCell.getPiece().color != ColorPiece.BLACK) listPosibleMoves.add(new Vector(row+2,col+1));
            }
            if ((row + 2 >= 0 && row + 2 <= 7) && (col - 1 >= 0 && col - 1 <= 7)){
                nextCell=map.getCell(row+2,col-1);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(row+2,col-1));
                else if (actualCell.getPiece().color != ColorPiece.BLACK) listPosibleMoves.add(new Vector(row+2,col-1));
            }
            if ((row + 1 >= 0 && row + 1 <= 7) && (col - 2 >= 0 && col - 2 <= 7)){
                nextCell=map.getCell(row+1,col-2);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(row+1,col-2));
                else if (actualCell.getPiece().color != ColorPiece.BLACK) listPosibleMoves.add(new Vector(row+1,col-2));
            }
            if ((row - 1 >= 0 && row - 1 <= 7) && (col - 2 >= 0 && col - 2 <= 7)){
                nextCell=map.getCell(row-1,col-2);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(row-1,col-2));
                else if (actualCell.getPiece().color != ColorPiece.BLACK) listPosibleMoves.add(new Vector(row-1,col-2));
            }
        }
        else{
            if ((row - 2 >= 0 && row - 2 <= 7) && (col - 1 >= 0 && col - 1 <= 7)){
                nextCell=map.getCell(row-2,col-1);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(row-2,col-1));
                else if (nextCell.getPiece().color != ColorPiece.WHITE) listPosibleMoves.add(new Vector(row-2,col-1));
            }
            if ((row - 2 >= 0 && row - 2 <= 7) && (col + 1 >= 0 && col + 1 <= 7)){
                nextCell=map.getCell(row-2,col+1);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(row-2,col+1));
                else if (actualCell.getPiece().color != ColorPiece.WHITE) listPosibleMoves.add(new Vector(row-2,col+1));
            }
            if ((row - 1 >= 0 && row - 1 <= 7) && (col + 2 >= 0 && col + 2 <= 7)){
                nextCell=map.getCell(row-1,col+2);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(row-1,col+2));
                else if (actualCell.getPiece().color != ColorPiece.WHITE) listPosibleMoves.add(new Vector(row-1,col+2));
            }
            if ((row + 1 >= 0 && row + 1 <= 7) && (col + 2 >= 0 && col + 2 <= 7)){
                nextCell=map.getCell(row+1,col+2);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(row+1,col+2));
                else if (actualCell.getPiece().color != ColorPiece.WHITE) listPosibleMoves.add(new Vector(row+1,col+2));
            }
            if ((row + 2 >= 0 && row + 2 <= 7) && (col + 1 >= 0 && col + 1 <= 7)){
                nextCell=map.getCell(row+2,col+1);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(row+2,col+1));
                else if (actualCell.getPiece().color != ColorPiece.WHITE) listPosibleMoves.add(new Vector(row+2,col+1));
            }
            if ((row + 2 >= 0 && row + 2 <= 7) && (col - 1 >= 0 && col - 1 <= 7)){
                nextCell=map.getCell(row+2,col-1);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(row+2,col-1));
                else if (actualCell.getPiece().color != ColorPiece.WHITE) listPosibleMoves.add(new Vector(row+2,col-1));
            }
            if ((row + 1 >= 0 && row + 1 <= 7) && (col - 2 >= 0 && col - 2 <= 7)){
                nextCell=map.getCell(row+1,col-2);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(row+1,col-2));
                else if (actualCell.getPiece().color != ColorPiece.WHITE) listPosibleMoves.add(new Vector(row+1,col-2));
            }
            if ((row - 1 >= 0 && row - 1 <= 7) && (col - 2 >= 0 && col - 2 <= 7)){
                nextCell=map.getCell(row-1,col-2);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(row-1,col-2));
                else if (actualCell.getPiece().color != ColorPiece.WHITE) listPosibleMoves.add(new Vector(row-1,col-2));
            }
        }

    }


    @Override
    public void movePiece(int x, int y,Board map, Player p) {
        firstTurn=false;
        actualCell.setStatus(Cell.CellState.NULL);
        actualCell.setPiece(null);
        actualCell=map.getCell(x,y);
        //comprobar si ay enemigos y matar
        if (actualCell.getStatus() != Cell.CellState.NULL){
            p.deadPieces.add(actualCell.getPiece());
            p.removeAlivePiece(actualCell.getPiece());
        }
        //sino se mueve
        actualCell.setStatus(Cell.CellState.KNIGHT);
        actualCell.setPiece(this);
    }

    @Override
    public String toString(){
        return "Knight";
    }
}

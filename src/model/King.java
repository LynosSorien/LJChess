package model;

import java.util.ArrayList;

/**
 * Created by hell on 28/08/14.
 */
public class King extends Piece{
    public King(ColorPiece color) {
        super(color);
    }

    @Override
    public void pieceMovements(Board map) {
        map.getBoard();
        int row = actualCell.getI();
        int col = actualCell.getJ();
        if(actualCell.getPiece().color == ColorPiece.BLACK){
            if (firstTurn){
                if(checkWaytoRookLong(map,row,col,checkRooks(map, 0,0))) listPosibleMoves.add(new Vector(row,col-2));
                if(checkWaytoRookShort(map,row,col,checkRooks(map, 0,7))) listPosibleMoves.add(new Vector(row,col+2));
            }
            if ((row-1 >= 0 && row-1 <= 7) && (col >= 0 && col <= 7)){
                nextCell=map.getCell(row-1,col);
                if (nextCell.getPiece().color != ColorPiece.BLACK) listPosibleMoves.add(new Vector(row-1,col));
            }
            if ((row-1 >= 0 && row-1 <= 7) && (col-1 >= 0 && col-1 <= 7)){
                nextCell=map.getCell(row-1,col-1);
                if (nextCell.getPiece().color != ColorPiece.BLACK) listPosibleMoves.add(new Vector(row-1,col-1));
            }
            if ((row >= 0 && row <= 7) && (col-1 >= 0 && col-1 <= 7)){
                nextCell=map.getCell(row,col-1);
                if (nextCell.getPiece().color != ColorPiece.BLACK) listPosibleMoves.add(new Vector(row,col-1));
            }
            if ((row+1 >= 0 && row+1 <= 7) && (col-1 >= 0 && col-1 <= 7)){
                nextCell=map.getCell(row+1,col-1);
                if (nextCell.getPiece().color != ColorPiece.BLACK) listPosibleMoves.add(new Vector(row+1,col-1));
            }
            if ((row+1 >= 0 && row+1 <= 7) && (col >= 0 && col <= 7)){
                nextCell=map.getCell(row+1,col);
                if (nextCell.getPiece().color != ColorPiece.BLACK) listPosibleMoves.add(new Vector(row+1,col));
            }
            if ((row+1 >= 0 && row+1 <= 7) && (col+1 >= 0 && col+1 <= 7)){
                nextCell=map.getCell(row+1,col+1);
                if (nextCell.getPiece().color != ColorPiece.BLACK) listPosibleMoves.add(new Vector(row+1,col+1));
            }
            if ((row >= 0 && row <= 7) && (col+1 >= 0 && col+1 <= 7)){
                nextCell=map.getCell(row,col+1);
                if (nextCell.getPiece().color != ColorPiece.BLACK) listPosibleMoves.add(new Vector(row,col+1));
            }
            if ((row-1 >= 0 && row-1 <= 7) && (col+1 >= 0 && col+1 <= 7)){
                nextCell=map.getCell(row-1,col+1);
                if (nextCell.getPiece().color != ColorPiece.BLACK) listPosibleMoves.add(new Vector(row-1,col+1));
            }
        }
        else{
            if (firstTurn){
                if(checkWaytoRookLong(map,row,col,checkRooks(map, 7,0))) listPosibleMoves.add(new Vector(row,col-2));
                if(checkWaytoRookShort(map,row,col,checkRooks(map, 7,7))) listPosibleMoves.add(new Vector(row,col+2));
            }
            if ((row-1 >= 0 && row-1 <= 7) && (col >= 0 && col <= 7)){
                nextCell=map.getCell(row-1,col);
                if (nextCell.getPiece().color != ColorPiece.WHITE) listPosibleMoves.add(new Vector(row-1,col));
            }
            if ((row-1 >= 0 && row-1 <= 7) && (col-1 >= 0 && col-1 <= 7)){
                nextCell=map.getCell(row-1,col-1);
                if (nextCell.getPiece().color != ColorPiece.WHITE) listPosibleMoves.add(new Vector(row-1,col-1));
            }
            if ((row >= 0 && row <= 7) && (col-1 >= 0 && col-1 <= 7)){
                nextCell=map.getCell(row,col-1);
                if (nextCell.getPiece().color != ColorPiece.WHITE) listPosibleMoves.add(new Vector(row,col-1));
            }
            if ((row+1 >= 0 && row+1 <= 7) && (col-1 >= 0 && col-1 <= 7)){
                nextCell=map.getCell(row+1,col-1);
                if (nextCell.getPiece().color != ColorPiece.WHITE) listPosibleMoves.add(new Vector(row+1,col-1));
            }
            if ((row+1 >= 0 && row+1 <= 7) && (col >= 0 && col <= 7)){
                nextCell=map.getCell(row+1,col);
                if (nextCell.getPiece().color != ColorPiece.WHITE) listPosibleMoves.add(new Vector(row+1,col));
            }
            if ((row+1 >= 0 && row+1 <= 7) && (col+1 >= 0 && col+1 <= 7)){
                nextCell=map.getCell(row+1,col+1);
                if (nextCell.getPiece().color != ColorPiece.WHITE) listPosibleMoves.add(new Vector(row+1,col+1));
            }
            if ((row >= 0 && row <= 7) && (col+1 >= 0 && col+1 <= 7)){
                nextCell=map.getCell(row,col+1);
                if (nextCell.getPiece().color != ColorPiece.WHITE) listPosibleMoves.add(new Vector(row,col+1));
            }
            if ((row-1 >= 0 && row-1 <= 7) && (col+1 >= 0 && col+1 <= 7)){
                nextCell=map.getCell(row-1,col+1);
                if (nextCell.getPiece().color != ColorPiece.WHITE) listPosibleMoves.add(new Vector(row-1,col+1));
            }
        }


    }

    @Override
    public ArrayList getPosibleMoves() {
        return listPosibleMoves;
    }

    @Override
    public void movePiece(int x, int y) {
        //comprobar enroque
        if (firstTurn){
            if (x==actualCell.getI()&& y==actualCell.getJ()-2){
                //aqui va el enroque largo
                actualCell.setStatus(Cell.CellState.NULL);
                actualCell.setPiece(null);
                actualCell=map.getCell(x,y);
                actualCell.setStatus(Cell.CellState.KING);
                actualCell.setPiece(this);
                actualCell=map.getCell(x,0);
                actualCell.setStatus(Cell.CellState.NULL);
                actualCell.setPiece(null);
                actualCell=map.getCell(x,y+1);
                actualCell.setStatus(Cell.CellState.ROOK);
                actualCell.setPiece(this);
            }
            else if (x==actualCell.getI()&& y==actualCell.getJ()+2){
                //aqui va el enroque corto
                actualCell.setStatus(Cell.CellState.NULL);
                actualCell.setPiece(null);
                actualCell=map.getCell(x,y);
                actualCell.setStatus(Cell.CellState.KING);
                actualCell.setPiece(this);
                actualCell=map.getCell(x,7);
                actualCell.setStatus(Cell.CellState.NULL);
                actualCell.setPiece(null);
                actualCell=map.getCell(x,y-1);
                actualCell.setStatus(Cell.CellState.ROOK);
                actualCell.setPiece(this);
            }
            else {
                //no hay enroque en el primer mov del rey
                firstTurn=false;
                actualCell.setStatus(Cell.CellState.NULL);
                actualCell.setPiece(null);
                actualCell=map.getCell(x,y);
                if (actualCell.getStatus() != Cell.CellState.NULL){
                    p.deadPieces.add(actualCell.getPiece());
                }
                actualCell.setStatus(Cell.CellState.KING);
                actualCell.setPiece(this);
            }
        }
        else {
            actualCell.setStatus(Cell.CellState.NULL);
            actualCell.setPiece(null);
            actualCell=map.getCell(x,y);

            //comprobar si ay enemigos y matar
            if (actualCell.getStatus() != Cell.CellState.NULL){
                p.deadPieces.add(actualCell.getPiece());
            }
            //sino se mueve
            actualCell.setStatus(Cell.CellState.KING);
            actualCell.setPiece(this);
        }
    }

    private boolean checkRooks(Board map, int x, int y){
        boolean thereRook=false;
        Cell rookCell = map.getCell(x,y);
        if (rookCell.getPiece().firstTurn) thereRook = true;
        return thereRook;
    }

    private boolean checkWaytoRookLong(Board map, int kingX, int kingY, boolean isRock) {
        boolean freeWay = false;
        if (isRock) {
            nextCell = map.getCell(kingX, kingY - 1);
            if (nextCell.getStatus() == Cell.CellState.NULL) {
                nextCell = map.getCell(kingX, kingY - 2);
                if (nextCell.getStatus() == Cell.CellState.NULL) {
                    nextCell = map.getCell(kingX, kingY - 3);
                    if (nextCell.getStatus() == Cell.CellState.NULL) freeWay = true;
                }
            }
        }
        return freeWay;
    }
    private boolean checkWaytoRookShort(Board map, int kingX, int kingY, boolean isRock){
        boolean freeWay=false;
        if (isRock){
            nextCell = map.getCell(kingX,kingY+1);
            if (nextCell.getStatus() == Cell.CellState.NULL) {
                nextCell = map.getCell(kingX, kingY+2);
                if (nextCell.getStatus() == Cell.CellState.NULL) freeWay = true;
            }
        }
        return freeWay;
    }

}

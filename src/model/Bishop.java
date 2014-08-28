package model;

import java.util.ArrayList;

/**
 * Created by hell on 28/08/14.
 */
public class Bishop extends Piece{

    public Bishop(ColorPiece color) {
        super(color);
    }

    @Override
    public void pieceMovements() {
        map.getBoard();
        int row = actualCell.getI();
        int col = actualCell.getJ();
        nextCell=actualCell;
        if (row==0 && col==0) rightDownDiagonal(listPosibleMoves,row,col,nextCell,map);
        else if (row==7 && col==0) rightUpDiagonal(listPosibleMoves,row,col,nextCell,map);
        else if (row==0 && col==7) leftDownDiagonal(listPosibleMoves,row,col,nextCell,map);
        else if (row==7 && col==7) leftUpDiagonal(listPosibleMoves,row,col,nextCell,map);
        else if (row==0){
            rightDownDiagonal(listPosibleMoves,row,col,nextCell,map);
            leftDownDiagonal(listPosibleMoves,row,col,nextCell,map);
        }
        else if (row==7){
            rightUpDiagonal(listPosibleMoves,row,col,nextCell,map);
            leftUpDiagonal(listPosibleMoves,row,col,nextCell,map);
        }
        else if (col==0){
            rightDownDiagonal(listPosibleMoves,row,col,nextCell,map);
            rightUpDiagonal(listPosibleMoves,row,col,nextCell,map);
        }
        else if (col==7){
            leftDownDiagonal(listPosibleMoves,row,col,nextCell,map);
            leftUpDiagonal(listPosibleMoves,row,col,nextCell,map);
        }
        else {
            rightDownDiagonal(listPosibleMoves,row,col,nextCell,map);
            leftDownDiagonal(listPosibleMoves,row,col,nextCell,map);
            rightUpDiagonal(listPosibleMoves,row,col,nextCell,map);
            leftUpDiagonal(listPosibleMoves,row,col,nextCell,map);
        }

    }


    @Override
    public ArrayList getPosibleMoves() {
        return listPosibleMoves;
    }

    @Override
    public void movePiece(int x, int y) {
        firstTurn=false;
        actualCell.setStatus(Cell.CellState.NULL);
        actualCell.setP(null);
        actualCell=map.getCell(x,y);
        //comprobar si ay enemigos y matar
        if (actualCell.getStatus() != Cell.CellState.NULL){
            p.deadPieces.add(actualCell.getPiece());
        }
        //sino se mueve
        actualCell.setStatus(Cell.CellState.BISHOP);
        actualCell.setP(this);//?????????????

    }
    private void rightDownDiagonal (ArrayList<Vector> listPosibleMoves, int x, int y,Cell nextCell, Board map){
        boolean finish=false;
        if (nextCell.getPiece().color == ColorPiece.BLACK){
            while ((x<7 && y<7)&& !finish){
                x++;
                y++;
                nextCell=map.getCell(x,y);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(x,y));
                else {
                    finish=true;
                    if (nextCell.getPiece().color == ColorPiece.WHITE)listPosibleMoves.add(new Vector(x,y));
                }
            }
        }
        else{
            while ((x<7 && y<7)&& !finish){
                x++;
                y++;
                nextCell=map.getCell(x,y);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(x,y));
                else {
                    finish=true;
                    if (nextCell.getPiece().color == ColorPiece.BLACK)listPosibleMoves.add(new Vector(x,y));
                }
            }
        }
    }

    private void rightUpDiagonal(ArrayList<Vector> listPosibleMoves, int x, int y,Cell nextCell, Board map) {
        boolean finish=false;
        if (nextCell.getPiece().color == ColorPiece.BLACK){
            while ((x>0 && y<7)&& !finish){
                x--;
                y++;
                nextCell=map.getCell(x,y);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(x,y));
                else {
                    finish=true;
                    if (nextCell.getPiece().color == ColorPiece.WHITE)listPosibleMoves.add(new Vector(x,y));
                }
            }
        }
        else{
            while ((x>0 && y<7)&& !finish){
                x--;
                y++;
                nextCell=map.getCell(x,y);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(x,y));
                else {
                    finish=true;
                    if (nextCell.getPiece().color == ColorPiece.BLACK)listPosibleMoves.add(new Vector(x,y));
                }
            }
        }
    }

    private void leftDownDiagonal(ArrayList<Vector> listPosibleMoves, int x, int y, Cell nextCell, Board map) {
        boolean finish=false;
        if (nextCell.getPiece().color == ColorPiece.BLACK){
            while ((x<7 && y>0)&& !finish){
                x++;
                y--;
                nextCell=map.getCell(x,y);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(x,y));
                else {
                    finish=true;
                    if (nextCell.getPiece().color == ColorPiece.WHITE)listPosibleMoves.add(new Vector(x,y));
                }
            }
        }
        else{
            while ((x<7 && y>0)&& !finish){
                x++;
                y--;
                nextCell=map.getCell(x,y);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(x,y));
                else {
                    finish=true;
                    if (nextCell.getPiece().color == ColorPiece.BLACK)listPosibleMoves.add(new Vector(x,y));
                }
            }
        }
    }

    private void leftUpDiagonal(ArrayList<Vector> listPosibleMoves, int x, int y, Cell nextCell, Board map) {
        boolean finish=false;
        if (nextCell.getPiece().color == ColorPiece.BLACK){
            while ((x>0 && y>0)&& !finish){
                x--;
                y--;
                nextCell=map.getCell(x,y);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(x,y));
                else {
                    finish=true;
                    if (nextCell.getPiece().color == ColorPiece.WHITE)listPosibleMoves.add(new Vector(x,y));
                }
            }
        }
        else{
            while ((x>0 && y>0)&& !finish){
                x--;
                y--;
                nextCell=map.getCell(x,y);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(x,y));
                else {
                    finish=true;
                    if (nextCell.getPiece().color == ColorPiece.BLACK)listPosibleMoves.add(new Vector(x,y));
                }
            }
        }
    }

}

package model;

import java.util.ArrayList;


/**
 * Created by hell on 28/08/14.
 */
public class Queen extends Piece {
    public Queen(ColorPiece color) {
        super(color);
    }

    @Override
    public void pieceMovements(Board map) {
        map.getBoard();
        int row = actualCell.getI();
        int col = actualCell.getJ();
        nextCell=actualCell;
        if (row==0 && col==0) {
            down(listPosibleMoves,row,col,nextCell,map);
            right(listPosibleMoves,row,col,nextCell,map);
            rightDownDiagonal(listPosibleMoves,row,col,nextCell,map);
        }
        else if (row==7 && col==0) {
            up(listPosibleMoves,row,col,nextCell,map);
            right(listPosibleMoves,row,col,nextCell,map);
            rightUpDiagonal(listPosibleMoves,row,col,nextCell,map);
        }
        else if (row==0 && col==7) {
            left(listPosibleMoves,row,col,nextCell,map);
            down(listPosibleMoves,row,col,nextCell,map);
            leftDownDiagonal(listPosibleMoves,row,col,nextCell,map);
        }
        else if (row==7 && col==7) {
            left(listPosibleMoves,row,col,nextCell,map);
            up(listPosibleMoves,row,col,nextCell,map);
            leftUpDiagonal(listPosibleMoves,row,col,nextCell,map);
        }
        else if (row==0){
            right(listPosibleMoves,row,col,nextCell,map);
            left(listPosibleMoves,row,col,nextCell,map);
            down(listPosibleMoves,row,col,nextCell,map);
            rightDownDiagonal(listPosibleMoves,row,col,nextCell,map);
            leftDownDiagonal(listPosibleMoves,row,col,nextCell,map);
        }
        else if (row==7){
            right(listPosibleMoves,row,col,nextCell,map);
            left(listPosibleMoves,row,col,nextCell,map);
            up(listPosibleMoves,row,col,nextCell,map);
            rightUpDiagonal(listPosibleMoves,row,col,nextCell,map);
            leftUpDiagonal(listPosibleMoves,row,col,nextCell,map);
        }
        else if (col==0){
            right(listPosibleMoves,row,col,nextCell,map);
            up(listPosibleMoves,row,col,nextCell,map);
            down(listPosibleMoves,row,col,nextCell,map);
            rightDownDiagonal(listPosibleMoves,row,col,nextCell,map);
            rightUpDiagonal(listPosibleMoves,row,col,nextCell,map);
        }
        else if (col==7){
            up(listPosibleMoves,row,col,nextCell,map);
            left(listPosibleMoves,row,col,nextCell,map);
            down(listPosibleMoves,row,col,nextCell,map);
            leftDownDiagonal(listPosibleMoves,row,col,nextCell,map);
            leftUpDiagonal(listPosibleMoves,row,col,nextCell,map);
        }
        else {
            right(listPosibleMoves,row,col,nextCell,map);
            left(listPosibleMoves,row,col,nextCell,map);
            up(listPosibleMoves,row,col,nextCell,map);
            down(listPosibleMoves,row,col,nextCell,map);
            rightDownDiagonal(listPosibleMoves,row,col,nextCell,map);
            leftDownDiagonal(listPosibleMoves,row,col,nextCell,map);
            rightUpDiagonal(listPosibleMoves,row,col,nextCell,map);
            leftUpDiagonal(listPosibleMoves,row,col,nextCell,map);
        }
    }


    @Override
    public void movePiece(int x, int y, Board map, Player p) {
        firstTurn=false;
        actualCell.setStatus(Cell.CellState.NULL);
        actualCell.setPiece(null);
        actualCell=map.getCell(x,y);
        //comprobar si ay enemigos y matar
        if (actualCell.getStatus() != Cell.CellState.NULL){
            p.deadPieces.add(actualCell.getPiece());
        }
        //sino se mueve
        actualCell.setStatus(Cell.CellState.QUEEN);
        actualCell.setPiece(this);
    }

    private void right (ArrayList<Vector> listPosibleMoves, int x, int y,Cell nextCell, Board map){
        boolean finish=false;
        if (nextCell.getPiece().color == ColorPiece.BLACK){
            while (x<7 && !finish){
                x++;
                nextCell=map.getCell(x,y);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(x,y));
                else {
                    finish=true;
                    if (nextCell.getPiece().color == ColorPiece.WHITE)listPosibleMoves.add(new Vector(x,y));
                }
            }
        }
        else{
            while (x<7&& !finish){
                x++;
                nextCell=map.getCell(x,y);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(x,y));
                else {
                    finish=true;
                    if (nextCell.getPiece().color == ColorPiece.BLACK)listPosibleMoves.add(new Vector(x,y));
                }
            }
        }
    }

    private void left(ArrayList<Vector> listPosibleMoves, int x, int y,Cell nextCell, Board map) {
        boolean finish=false;
        if (nextCell.getPiece().color == ColorPiece.BLACK){
            while (x>0&& !finish){
                x--;
                nextCell=map.getCell(x,y);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(x,y));
                else {
                    finish=true;
                    if (nextCell.getPiece().color == ColorPiece.WHITE)listPosibleMoves.add(new Vector(x,y));
                }
            }
        }
        else{
            while (x>0&& !finish){
                x--;
                nextCell=map.getCell(x,y);
                if (nextCell.getStatus() == Cell.CellState.NULL) listPosibleMoves.add(new Vector(x,y));
                else {
                    finish=true;
                    if (nextCell.getPiece().color == ColorPiece.BLACK)listPosibleMoves.add(new Vector(x,y));
                }
            }
        }
    }

    private void up(ArrayList<Vector> listPosibleMoves, int x, int y, Cell nextCell, Board map) {
        boolean finish=false;
        if (nextCell.getPiece().color == ColorPiece.BLACK){
            while (y>0&& !finish){
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
            while (y>0&& !finish){
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

    private void down(ArrayList<Vector> listPosibleMoves, int x, int y, Cell nextCell, Board map) {
        boolean finish=false;
        if (nextCell.getPiece().color == ColorPiece.BLACK){
            while (y<7&& !finish){
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
            while (y<7&& !finish){
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

    @Override
    public String toString(){
        return "Queen";
    }
}

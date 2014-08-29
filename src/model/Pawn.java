package model;

import java.util.ArrayList;

/**
 * Created by hell on 26/08/14.
 */
public class Pawn extends Piece {
    private int row = actualCell.getI();
    private int col = actualCell.getJ();
    public Pawn(ColorPiece color){
        super(color);
    }
    @Override
    public void pieceMovements() {
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
    public ArrayList getPosibleMoves() {
        return listPosibleMoves;
    }

    @Override
    public void movePiece(int x, int y){
        boolean checkIfCrown;
        firstTurn=false;
        actualCell.setStatus(Cell.CellState.NULL);
        actualCell.setPiece(null);
        actualCell=map.getCell(x,y);
        //comprobar si ay enemigos y matar
        if (actualCell.getStatus() != Cell.CellState.NULL){
            p.deadPieces.add(actualCell.getPiece());
        }
        //comprobar si esta en CrownCell
        //sino se mueve
        actualCell.setStatus(Cell.CellState.PAWN);
        actualCell.setPiece(this);

    }
}

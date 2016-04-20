package fr.snak.chess.Models;

import fr.snak.chess.Interfaces.IPiece;
import fr.snak.chess.Interfaces.ISquare;

import java.util.ArrayList;

/**
 * Created by Nautile on 09/03/2016.
 */
public class Bishop implements IPiece {

    private int value;
    private int type;

    public Bishop(int type){
        this.type = type;
        this.value = 9;
    }

    @Override
    public int getName() {
        if(type == FRONT_PIECE){return BISHOP_BLACK;}else{return BISHOP_WHITE;}
    }

    @Override
    public void showMoves(ArrayList<ISquare> chessboard) {
        int index = -1;
        ISquare square;
        for(int i =0; i < chessboard.size(); i++){
            square = chessboard.get(i);
            if(!square.isEmpty()){
                IPiece piece = square.getPiece();
                if(piece == this){
                    index = i;
                    break;
                }
            }
        }
        if(index != -1) {
            getDiagonal(chessboard, index, ChessBoard.NB_SQUARE_PAR_LINE-1);
            getDiagonal(chessboard, index, ChessBoard.NB_SQUARE_PAR_LINE+1);
            getDiagonal(chessboard, index, -ChessBoard.NB_SQUARE_PAR_LINE+1);
            getDiagonal(chessboard, index, -ChessBoard.NB_SQUARE_PAR_LINE-1);
        }
    }
    private void getDiagonal(ArrayList<ISquare> chessboard, int index, int step){
        int i = index;
        int line = ChessBoard.currentLine(i);
        i += step;
        int newLine;
        while (i < chessboard.size() && i > 0){
            newLine = ChessBoard.currentLine(i);
            if(newLine == line+(int) Math.signum(step)){
                line = newLine;
            }else{
                break;
            }
            ISquare square = chessboard.get(i);
            if(!square.isEmpty()){
                IPiece piece = square.getPiece();
                if(piece.getType() != type){
                    square.setStatus(ISquare.STATUS_TARGETABLE);
                }
                break;
            }
            square.setStatus(ISquare.STATUS_MOVE);
            i += step;
        }
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "Bishop{" +
                "value=" + value +
                ", color=" + type +
                '}';
    }
}
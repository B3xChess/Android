package fr.snak.chess.Models;

import fr.snak.chess.Interfaces.IPiece;
import fr.snak.chess.Interfaces.ISquare;

import java.util.ArrayList;

/**
 * Created by Nautile on 09/03/2016.
 */
public class Knight implements IPiece {

    private int value;
    private int type;

    public Knight(int type){
        this.type = type;
        this.value = 8;
    }

    @Override
    public int getName() {
        if(type == FRONT_PIECE){return KNIGHT_BLACK;}else{return KNIGHT_WHITE;}
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
            getMove(chessboard, index, ChessBoard.NB_SQUARE_PAR_LINE*2+1,+1);
            getMove(chessboard, index, ChessBoard.NB_SQUARE_PAR_LINE*2-1,-1);
            getMove(chessboard, index, ChessBoard.NB_SQUARE_PAR_LINE+2,+1);
            getMove(chessboard, index, ChessBoard.NB_SQUARE_PAR_LINE-2,-1);
            getMove(chessboard, index, -ChessBoard.NB_SQUARE_PAR_LINE*2+1,+1);
            getMove(chessboard, index, -ChessBoard.NB_SQUARE_PAR_LINE*2-1,-1);
            getMove(chessboard, index, -ChessBoard.NB_SQUARE_PAR_LINE+2,+1);
            getMove(chessboard, index, -ChessBoard.NB_SQUARE_PAR_LINE-2,-1);
        }
    }

    private void getMove(ArrayList<ISquare> chessboard, int index, int step, int bord) {
        int i = index;
        int column = ChessBoard.currentColumn(i);
        i += step;
        ISquare square = null;
        if (i < chessboard.size() && i > 0) {
            int newColumn = ChessBoard.currentColumn(i);
            if ((int) Math.signum(bord) > 0) {
                if(newColumn > column) {
                    square = chessboard.get(i);
                }
            }else{
                if(newColumn < column) {
                    square = chessboard.get(i);
                }
            }
            if(square != null) {
                if (!square.isEmpty()) {
                    IPiece piece = square.getPiece();
                    if (piece.getType() != type) {
                        square.setStatus(ISquare.STATUS_TARGETABLE);
                    }
                } else {
                    square.setStatus(ISquare.STATUS_MOVE);
                }
            }
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
        return "Knight{" +
                "value=" + value +
                ", type=" + type +
                '}';
    }
}
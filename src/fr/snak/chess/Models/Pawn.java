package fr.snak.chess.Models;

import fr.snak.chess.Interfaces.IPiece;
import fr.snak.chess.Interfaces.ISquare;

import java.util.ArrayList;

/**
 * Created by Nautile on 09/03/2016.
 */
public class Pawn implements IPiece {

    private int value;
    private int type;

    public Pawn(int type){
        this.type = type;
        this.value = 5;
    }

    @Override
    public int getName() {
        if(type == FRONT_PIECE){return PAWN_BLACK;}else{return PAWN_WHITE;}
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
        if(index != -1){
            if(type == FRONT_PIECE){
                square = chessboard.get(index-8);
                if(square.isEmpty()){
                    square.setStatus(ISquare.STATUS_MOVE);
                    if(index < 8*7 && index >= 8*6){
                        square = chessboard.get(index-8*2);
                        if(square.isEmpty()){
                            square.setStatus(ISquare.STATUS_MOVE);
                        }
                    }
                }
                ArrayList<ISquare> squares = new ArrayList();
                square = chessboard.get(index-7);
                squares.add(square);
                square = chessboard.get(index-9);
                squares.add(square);
                squareEated(squares);
            }else{
                square = chessboard.get(index+8);
                if(square.isEmpty()){
                    square.setStatus(ISquare.STATUS_MOVE);
                    if(index < 8*2 && index >= 8){
                        square = chessboard.get(index+8*2);
                        if(square.isEmpty()){
                            square.setStatus(ISquare.STATUS_MOVE);
                        }
                    }
                }
                ArrayList<ISquare> squares = new ArrayList();
                square = chessboard.get(index+7);
                squares.add(square);
                square = chessboard.get(index+9);
                squares.add(square);
                squareEated(squares);
            }
        }
    }

    private void squareEated(ArrayList<ISquare> squares){
        for(ISquare squareSelected : squares) {
            if (!squareSelected.isEmpty()) {
                IPiece piece = squareSelected.getPiece();
                if (piece.getType() != this.type) {
                    squareSelected.setStatus(ISquare.STATUS_TARGETABLE);
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
        return "Pawn{" +
                "value=" + value +
                ", type=" + type +
                '}';
    }
}

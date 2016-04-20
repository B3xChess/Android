package fr.snak.chess.Models;

import fr.snak.chess.Interfaces.IPiece;
import fr.snak.chess.Interfaces.ISquare;

/**
 * Created by Nautile on 09/03/2016.
 */
public class Square implements ISquare {

    private String name;
    private IPiece piece;
    private int status;

    public Square(String name, IPiece piece){
        this.name = name;
        this.piece = piece;
        this.status = STATUS_DEFAULT;
    }

    public Square(String name){
        this.name = name;
        this.piece = null;
        this.status = STATUS_DEFAULT;
    }

    @Override
    public boolean isEmpty() {
        if(this.piece != null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void resetStatus() {
        if(this.status != STATUS_DEFAULT){
            this.status = STATUS_DEFAULT;
        }
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int getStatus() {
        return this.status;
    }

    @Override
    public void add(IPiece piece) {
        this.piece = piece;
    }

    @Override
    public void remove() {
        this.piece = null;
    }

    @Override
    public IPiece getPiece() {
        return this.piece;
    }

    @Override
    public String toString() {
        String value = "Square{'" + name + "', "
        +"'" + status + "'" ;
        if(piece == null){
            value += "null";
        }else{
            value += piece.toString();
        }
        value += "}";
        return value;
    }
}
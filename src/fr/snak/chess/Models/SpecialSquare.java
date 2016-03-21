package fr.snak.chess.Models;

import fr.snak.chess.Interfaces.IPiece;
import fr.snak.chess.Interfaces.ISquare;

/**
 * Created by Nautile on 09/03/2016.
 */
public class SpecialSquare implements ISquare {

    private String name;
    private IPiece piece;

    public SpecialSquare(String name, IPiece piece){
        this.name = name;
        this.piece = piece;
    }

    public SpecialSquare(String name){
        this.name = name;
        this.piece = null;
    }

    @Override
    public boolean isEmpty() {
        if(this.piece == null){
            return false;
        }else{
            return true;
        }
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
        return "SSquare{" +
                "'" + name + '\'' +
                ", " + piece.toString() +
                '}';
    }
}

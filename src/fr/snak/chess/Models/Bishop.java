package fr.snak.chess.Models;

import fr.snak.chess.Interfaces.IPiece;

/**
 * Created by Nautile on 09/03/2016.
 */
public class Bishop implements IPiece {

    private int value;
    private char color;

    public Bishop(char color){
        this.color = color;
        this.value = 9;
    }


    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public char getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return "Bishop{" +
                "value=" + value +
                ", color=" + color +
                '}';
    }
}
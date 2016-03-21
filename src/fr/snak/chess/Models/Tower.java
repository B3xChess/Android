package fr.snak.chess.Models;

import fr.snak.chess.Interfaces.IPiece;

/**
 * Created by Nautile on 09/03/2016.
 */
public class Tower implements IPiece {

    private int value;
    private char color;

    public Tower(char color){
        this.color = color;
        this.value = 10;
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
        return "Tower{" +
                "value=" + value +
                ", color=" + color +
                '}';
    }
}
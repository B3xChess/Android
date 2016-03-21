package fr.snak.chess.Interfaces;

/**
 * Created by Nautile on 09/03/2016.
 */
public interface ISquare {
    boolean isEmpty();
    void add(IPiece piece);
    void remove();
    IPiece getPiece();
}

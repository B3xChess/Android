package fr.snak.chess.Interfaces;

/**
 * Created by Nautile on 09/03/2016.
 */
public interface ISquare {
    int STATUS_DEFAULT = 0;
    int STATUS_SELECTED = 1;
    int STATUS_TARGETABLE = 2;
    int STATUS_MOVE = 3;
    int STATUS_DANGEROUS = 4;
    boolean isEmpty();
    void add(IPiece piece);
    void remove();
    IPiece getPiece();
    void setStatus(int status);
    int getStatus();
    void resetStatus();
}

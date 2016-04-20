package fr.snak.chess.Interfaces;

import android.content.Context;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by Nautile on 09/03/2016.
 */
public interface IPiece {
    int FRONT_PIECE = 20;
    int BACK_PIECE = 21;
    int NO_SKIN = 0;
    int PAWN_BLACK = 1;
    int PAWN_WHITE = 2;
    int BISHOP_BLACK = 3;
    int BISHOP_WHITE = 4;
    int TOWER_BLACK = 5;
    int TOWER_WHITE = 6;
    int KNIGHT_BLACK = 7;
    int KNIGHT_WHITE = 8;
    int QUEEN_BLACK = 9;
    int QUEEN_WHITE = 10;
    int KING_BLACK = 11;
    int KING_WHITE = 12;
    int getValue();
    int getType();
    int getName();
    void showMoves(ArrayList<ISquare> chessboard);

    void setImage(Context context, RelativeLayout myLayout, int width, int height, int left, int top);
    void animate(int left, int top);
}
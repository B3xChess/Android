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
    int getValue();
    int getType();
    void showMoves(ArrayList<ISquare> chessboard);

    void setImage(Context context, RelativeLayout myLayout, int width, int height, int left, int top);
    void animate(int left, int top);
    void hideImage();
}
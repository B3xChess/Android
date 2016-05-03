package fr.snak.chess.Pieces;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import fr.snak.chess.Boards.ChessBoard;
import fr.snak.chess.Interfaces.IPiece;
import fr.snak.chess.Interfaces.ISquare;
import fr.snak.chess.R;

import java.util.ArrayList;

/**
 * Created by Nautile on 09/03/2016.
 */
public class Pawn implements IPiece {

    private int value;
    private int type;
    private ImageView imageView;
    private int topView, leftView;

    public Pawn(int type){
        this.type = type;
        this.value = 5;
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
                int newIndex = index-8;
                if(newIndex >= 0) {
                    square = chessboard.get(newIndex);
                    if (square.isEmpty()) {
                        square.setStatus(ISquare.STATUS_MOVE);
                        if (index < ChessBoard.NB_SQUARE_PAR_LINE * 7 && index >= ChessBoard.NB_SQUARE_PAR_LINE * 6) {
                            square = chessboard.get(index - ChessBoard.NB_SQUARE_PAR_LINE * 2);
                            if (square.isEmpty()) {
                                square.setStatus(ISquare.STATUS_MOVE);
                            }
                        }
                    }
                    if (index != -1) {
                        squareEated(chessboard, index, -9, -1);
                        squareEated(chessboard, index, -7, +1);
                    }
                }
            }else{
                int newIndex = index+8;
                if(newIndex < chessboard.size()) {
                    square = chessboard.get(newIndex);
                    if (square.isEmpty()) {
                        square.setStatus(ISquare.STATUS_MOVE);
                        if (index < ChessBoard.NB_SQUARE_PAR_LINE * 2 && index >= ChessBoard.NB_SQUARE_PAR_LINE) {
                            square = chessboard.get(newIndex + ChessBoard.NB_SQUARE_PAR_LINE);
                            if (square.isEmpty()) {
                                square.setStatus(ISquare.STATUS_MOVE);
                            }
                        }
                    }
                    if (index != -1) {
                        squareEated(chessboard, index, +9, +1);
                        squareEated(chessboard, index, +7, -1);
                    }
                }
            }
        }
    }

    private void squareEated(ArrayList<ISquare> chessboard, int index, int step, int bord) {
        int i = index;
        int column = ChessBoard.currentColumn(i);
        i += step;
        ISquare square = null;
        if (i < chessboard.size() && i >= 0) {
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
                }
            }
        }
    }

    @Override
    public void setImage(Context context, RelativeLayout myLayout, int width, int height, int left, int top) {
        if(imageView == null) {
            imageView = new ImageView(context);
            if (type == FRONT_PIECE) {
                imageView.setImageResource(R.drawable.wpawn);
            } else {
                imageView.setImageResource(R.drawable.bpawn);
            }
            RelativeLayout.LayoutParams params;
            params = new RelativeLayout.LayoutParams(width, height);
            params.leftMargin = left;
            params.topMargin = top;
            imageView.setLayoutParams(params);
            myLayout.addView(imageView, params);
        }
    }

    @Override
    public void animate(int left, int top){
        int xCurrentPos = imageView.getLeft();
        int yCurrentPos = imageView.getTop();
        leftView = left-xCurrentPos;
        topView = top-yCurrentPos;
        TranslateAnimation anim = new TranslateAnimation(0, leftView, 0, topView);
        anim.setDuration(800);
        anim.setFillAfter(true);
        anim.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.clearAnimation();
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                lp.leftMargin = imageView.getLeft()+leftView;
                lp.topMargin = imageView.getTop()+topView;
                imageView.setLayoutParams(lp);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub
            }
        });
        imageView.startAnimation(anim);
    }

    @Override
    public void hideImage() {
        if(imageView != null){
            imageView.setVisibility(View.INVISIBLE);
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

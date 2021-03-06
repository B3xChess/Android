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
public class Bishop implements IPiece {

    private int value;
    private int type;
    private ImageView imageView;
    private int topView, leftView;

    public Bishop(int type){
        this.type = type;
        this.value = 9;
        this.imageView = null;
    }

    @Override
    public void detectMoves(ArrayList<ISquare> chessboard, boolean show) {
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
        if(index != -1) {
            getDiagonal(chessboard, show, index, ChessBoard.NB_SQUARE_PAR_LINE-1);
            getDiagonal(chessboard, show, index, ChessBoard.NB_SQUARE_PAR_LINE+1);
            getDiagonal(chessboard, show, index, -ChessBoard.NB_SQUARE_PAR_LINE+1);
            getDiagonal(chessboard, show, index, -ChessBoard.NB_SQUARE_PAR_LINE-1);
        }
    }
    private void getDiagonal(ArrayList<ISquare> chessboard, boolean show, int index, int step){
        int i = index;
        int line = ChessBoard.currentLine(i);
        i += step;
        int newLine;
        while (i < chessboard.size() && i >= 0){
            newLine = ChessBoard.currentLine(i);
            if(newLine == line+(int) Math.signum(step)){
                line = newLine;
            }else{
                break;
            }
            ISquare square = chessboard.get(i);
            if(!square.isEmpty()){
                if(!show){
                    square.setStatus(ISquare.STATUS_DANGEROUS);
                }
                IPiece piece = square.getPiece();
                if(piece.getType() != type){
                    if(show){
                        square.setStatus(ISquare.STATUS_TARGETABLE);
                    }
                }
                if(!(!show && piece.getClass().getName().equals("fr.snak.chess.Pieces.King"))){
                    break;
                }
            }
            if(show){
                square.setStatus(ISquare.STATUS_MOVE);
            }else{
                square.setStatus(ISquare.STATUS_DANGEROUS);
            }
            i += step;
        }
    }

    @Override
    public void setImage(Context context, RelativeLayout myLayout, int width, int height, int left, int top) {
        if(imageView == null) {
            imageView = new ImageView(context);
            if (type == FRONT_PIECE) {
                imageView.setImageResource(R.drawable.wbishop);
            } else {
                imageView.setImageResource(R.drawable.bbishop);
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
        return "Bishop{" +
                "value=" + value +
                ", color=" + type +
                '}';
    }
}
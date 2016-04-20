package fr.snak.chess.Models;

import android.content.Context;
import android.graphics.*;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import fr.snak.chess.Interfaces.IPiece;
import fr.snak.chess.Interfaces.ISquare;
import fr.snak.chess.R;

import java.util.ArrayList;

/**
 * Created by Nautile on 09/03/2016.
 */
public class ChessBoard extends View implements View.OnTouchListener{
    public static final int NB_SQUARE_PAR_LINE = 8;
    private final RectF rectF = new RectF();
    private final Paint paintSquare = new Paint(),paintStatus= new Paint();
    private ArrayList<ISquare> chessboard;
    private ISquare selectedSquare;
    private int ref,margin;

    public ChessBoard(Context context, ArrayList<ISquare> chessboard) {
        super(context);
        this.chessboard = chessboard;
        this.setOnTouchListener(this);
    }

    public static int currentLine(int index){
        int value = (index-(index%NB_SQUARE_PAR_LINE))/NB_SQUARE_PAR_LINE;
        return value;
    }

    public static int currentColumn(int index){
        int value = index - (index-(index%NB_SQUARE_PAR_LINE));
        return value;
    }

    @Override
    public void onDraw(Canvas canvas) {
        int margeLeft,margeRight,margeTop,margeBot,line,calcLine,part;
        if(canvas.getWidth() > canvas.getHeight()) {
            ref = (int) (canvas.getHeight()*0.85);
            margin = (int) (canvas.getHeight()*0.15);
        }else {
            ref = (int) (canvas.getWidth()*0.85);
            margin = (int) (canvas.getWidth()*0.15);
        }
        part = ref / NB_SQUARE_PAR_LINE;
        line = -1;
        int size = (int) Math.pow(NB_SQUARE_PAR_LINE,2);
        for(int i = 0; i<size; i++) {
            ISquare square = chessboard.get(i);
            calcLine = (i-i%NB_SQUARE_PAR_LINE)/NB_SQUARE_PAR_LINE;
            margeTop = calcLine*part + margin/2;
            if(calcLine != line){
                line = calcLine;
                margeLeft = margin/2;
            }else{
                margeLeft = margin/2 + part*(i%NB_SQUARE_PAR_LINE);
            }
            margeBot = margeTop + part;
            margeRight = margeLeft + part;

            if((line+i)%2==1){paintSquare.setColor(Color.parseColor("#e6e6ff"));}else{paintSquare.setColor(Color.parseColor("#a7823d"));}
            Rect rect = new Rect(margeLeft, margeTop, margeRight, margeBot);

            canvas.drawRect(rect, paintSquare);

            int status = square.getStatus();
            if(status != ISquare.STATUS_DEFAULT) {
                int border_margin = (int) (part*0.08);
                int inner_margin;
                switch (status) {
                    case (ISquare.STATUS_SELECTED):
                        paintStatus.setColor(Color.parseColor("#0034E1"));//"#FFA200"));
                        paintStatus.setStyle(Paint.Style.STROKE);
                        paintStatus.setStrokeWidth(border_margin);
                        inner_margin = border_margin/2;
                        rectF.set(margeLeft + inner_margin, margeTop + inner_margin, margeRight - inner_margin, margeBot - inner_margin);
                        canvas.drawRect(rectF, paintStatus);
                        break;
                    case (ISquare.STATUS_TARGETABLE):
                        paintStatus.setColor(Color.parseColor("#D23939"));
                        paintStatus.setStyle(Paint.Style.FILL);
                        paintStatus.setStrokeWidth(0);
                        inner_margin = (int) (border_margin/1.5);
                        rectF.set(margeLeft + inner_margin, margeTop + inner_margin, margeRight - inner_margin, margeBot - inner_margin);
                        canvas.drawRect(rectF, paintStatus);
                        break;
                    case (ISquare.STATUS_MOVE):
                        paintStatus.setColor(Color.parseColor("#3899D1"));
                        paintStatus.setStyle(Paint.Style.FILL);
                        paintStatus.setStrokeWidth(0);
                        inner_margin = (int) (border_margin/1.5);
                        rectF.set(margeLeft + inner_margin, margeTop + inner_margin, margeRight - inner_margin, margeBot - inner_margin);
                        canvas.drawRect(rectF, paintStatus);
                        break;
                }
            }

            if(!square.isEmpty()){
                IPiece piece = square.getPiece();
                int name = piece.getName();
                int image = IPiece.NO_SKIN;
                switch(name){
                    case IPiece.PAWN_WHITE:
                        image = R.drawable.wpawn;
                        break;
                    case IPiece.PAWN_BLACK:
                        image = R.drawable.bpawn;
                        break;
                    case IPiece.BISHOP_WHITE:
                        image = R.drawable.wbishop;
                        break;
                    case IPiece.BISHOP_BLACK:
                        image = R.drawable.bbishop;
                        break;
                    case IPiece.TOWER_WHITE:
                        image = R.drawable.wtower;
                        break;
                    case IPiece.TOWER_BLACK:
                        image = R.drawable.btower;
                        break;
                    case IPiece.KNIGHT_WHITE:
                        image = R.drawable.wknight;
                        break;
                    case IPiece.KNIGHT_BLACK:
                        image = R.drawable.bknight;
                        break;
                    case IPiece.QUEEN_WHITE:
                        image = R.drawable.wqueen;
                        break;
                    case IPiece.QUEEN_BLACK:
                        image = R.drawable.bqueen;
                        break;
                    case IPiece.KING_WHITE:
                        image = R.drawable.wking;
                        break;
                    case IPiece.KING_BLACK:
                        image = R.drawable.bking;
                        break;
                }

                if(image != IPiece.NO_SKIN) {
                    int marginDrawable = (int) (part * 0.2);

                    RelativeLayout myLayout = (RelativeLayout)this.getParent();
                    RelativeLayout.LayoutParams params;

                    ImageView imageView = new ImageView(this.getContext());
                    imageView.setImageResource(image);

                    params = new RelativeLayout.LayoutParams((margeRight - marginDrawable) - ( margeLeft + marginDrawable), (margeBot - marginDrawable) - (margeTop + marginDrawable));
                    params.leftMargin = margeLeft + marginDrawable;
                    params.topMargin = margeTop + marginDrawable;
                    imageView.setLayoutParams(params);
                    myLayout.addView(imageView, params);

                    if(this.selectedSquare == square){
                        int xCurrentPos = imageView.getLeft();
                        int yCurrentPos = imageView.getTop();

                        TranslateAnimation anim = new TranslateAnimation(xCurrentPos, xCurrentPos+150, yCurrentPos, yCurrentPos);
                        anim.setDuration(1000);

                        imageView.startAnimation(anim);
                    }
                }

            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int line, column;
        column = (int) ((event.getX()-margin/2)*NB_SQUARE_PAR_LINE/ref);
        line = (int) ((event.getY()-margin/2)*NB_SQUARE_PAR_LINE/ref);
        boolean left,top,right,bot;
        left = event.getX()-margin/2 > 0;
        top = event.getY()-margin/2 > 0;
        right = event.getX()-margin/2 < ref;
        bot = event.getY()-margin/2 < ref;
        if(left && top && right && bot){
            ISquare square = getSquare(line, column);
            this.resetSquares();
            if(selectedSquare == null) {
                square.setStatus(ISquare.STATUS_SELECTED);
                IPiece piece = square.getPiece();
                if(piece != null){
                    piece.showMoves(this.chessboard);
                    selectedSquare = square;
                }
            }else{
                selectedSquare = null;
            }
            this.invalidate();
        }
        return false;
    }

    public void resetSquares(){
        for(ISquare square : this.chessboard){
            square.resetStatus();
        }
    }

    public ISquare getSquare(int line, int column){
        int value = line*8+column;
        if(value < this.chessboard.size()) {
            return this.chessboard.get(value);
        }else{
            return null;
        }
    }

    @Override
    public String toString() {
        String value = "ChessBoard{";
        int i = 0;
        for(ISquare square : chessboard){
            if(i++%8==0){value += "\n";};
            value += square.toString()+",";
        }
        value += "}";
        return value;
    }

}

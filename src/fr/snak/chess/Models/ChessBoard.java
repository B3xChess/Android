package fr.snak.chess.Models;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import fr.snak.chess.Interfaces.ISquare;

import java.util.ArrayList;

/**
 * Created by Nautile on 09/03/2016.
 */
public class ChessBoard extends View implements View.OnTouchListener {
    final int NB_SQUARE_PAR_LINE = 8;
    private ArrayList<ISquare> chessboard;
    Paint paint = new Paint();
    private int ref,margin,margeleft,margeright,margetop,margebot,line,calcLine,part;

    public ChessBoard(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.chessboard = init();
        this.setOnTouchListener(this);
    }

    @Override
    public void onDraw(Canvas canvas) {
        if(canvas.getWidth() > canvas.getHeight()) {
            ref = (int) (canvas.getHeight()*0.85);
            margin = (int) (canvas.getHeight()*0.15);
        }else {
            ref = (int) (canvas.getWidth()*0.85);
            margin = (int) (canvas.getWidth()*0.15);
        }
        part = (int) ref / NB_SQUARE_PAR_LINE;
        line = -1;
        for(int i = 0; i<Math.pow(NB_SQUARE_PAR_LINE,2); i++) {
            calcLine = (i-i%NB_SQUARE_PAR_LINE)/NB_SQUARE_PAR_LINE;
            if(calcLine != line){
                line = calcLine;
                margetop = line*part + margin/2;
                margeleft = margin/2;
            }else{
                margeleft = margin/2 + part*(i%NB_SQUARE_PAR_LINE);
            }
            margebot = margetop + part;
            margeright = margeleft + part;

            if((line+i)%2==1){paint.setColor(Color.parseColor("#e6e6ff"));}else{paint.setColor(Color.parseColor("#a7823d"));}
            Rect rect = new Rect(margeleft, margetop, margeright, margebot);

            canvas.drawRect(rect, paint);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        System.out.println(event.getX()+" : "+event.getY());
        return false;
    }

    public ISquare getSquare(char line, int column){
        int valueLine;
        switch(line){
            case 'A':
                valueLine = -1;
                break;
            case 'B':
                valueLine = 7;
                break;
            case 'C':
                valueLine = 15;
                break;
            case 'D':
                valueLine = 23;
                break;
            case 'E':
                valueLine = 31;
                break;
            case 'F':
                valueLine = 39;
                break;
            case 'G':
                valueLine = 47;
                break;
            case 'H':
                valueLine = 55;
                break;
            default:
                return null;
        }
        if(column < 1 || column > 8){
            return null;
        }
        return this.chessboard.get(valueLine+column);
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

    public ArrayList<ISquare> init(){
        ArrayList<ISquare> squares = new ArrayList<>();
        // A
        squares.add(new SpecialSquare("a1",new Tower('W')));
        squares.add(new SpecialSquare("a2",new Knight('W')));
        squares.add(new SpecialSquare("a3",new Bishop('W')));
        squares.add(new SpecialSquare("a4",new Qween('W')));
        squares.add(new SpecialSquare("a5",new King('W')));
        squares.add(new SpecialSquare("a6",new Bishop('W')));
        squares.add(new SpecialSquare("a7",new Knight('W')));
        squares.add(new SpecialSquare("a8",new Tower('W')));
        // B
        squares.add(new Square("b1",new Pawn('W')));
        squares.add(new Square("b2",new Pawn('W')));
        squares.add(new Square("b3",new Pawn('W')));
        squares.add(new Square("b4",new Pawn('W')));
        squares.add(new Square("b5",new Pawn('W')));
        squares.add(new Square("b6",new Pawn('W')));
        squares.add(new Square("b7",new Pawn('W')));
        squares.add(new Square("b8",new Pawn('W')));
        // C
        squares.add(new Square("c1"));
        squares.add(new Square("c2"));
        squares.add(new Square("c3"));
        squares.add(new Square("c4"));
        squares.add(new Square("c5"));
        squares.add(new Square("c6"));
        squares.add(new Square("c7"));
        squares.add(new Square("c8"));
        // D
        squares.add(new Square("d1"));
        squares.add(new Square("d2"));
        squares.add(new Square("d3"));
        squares.add(new Square("d4"));
        squares.add(new Square("d5"));
        squares.add(new Square("d6"));
        squares.add(new Square("d7"));
        squares.add(new Square("d8"));
        // E
        squares.add(new Square("e1"));
        squares.add(new Square("e2"));
        squares.add(new Square("e3"));
        squares.add(new Square("e4"));
        squares.add(new Square("e5"));
        squares.add(new Square("e6"));
        squares.add(new Square("e7"));
        squares.add(new Square("e8"));
        // F
        squares.add(new Square("f1"));
        squares.add(new Square("f2"));
        squares.add(new Square("f3"));
        squares.add(new Square("f4"));
        squares.add(new Square("f5"));
        squares.add(new Square("f6"));
        squares.add(new Square("f7"));
        squares.add(new Square("f8"));
        // G
        squares.add(new Square("g1",new Pawn('B')));
        squares.add(new Square("g2",new Pawn('B')));
        squares.add(new Square("g3",new Pawn('B')));
        squares.add(new Square("g4",new Pawn('B')));
        squares.add(new Square("g5",new Pawn('B')));
        squares.add(new Square("g6",new Pawn('B')));
        squares.add(new Square("g7",new Pawn('B')));
        squares.add(new Square("g8",new Pawn('B')));
        // H
        squares.add(new SpecialSquare("h1",new Tower('B')));
        squares.add(new SpecialSquare("h2",new Knight('B')));
        squares.add(new SpecialSquare("h3",new Bishop('B')));
        squares.add(new SpecialSquare("h4",new Qween('B')));
        squares.add(new SpecialSquare("h5",new King('B')));
        squares.add(new SpecialSquare("h6",new Bishop('B')));
        squares.add(new SpecialSquare("h7",new Knight('B')));
        squares.add(new SpecialSquare("h8",new Tower('B')));

        return squares;
    }
}

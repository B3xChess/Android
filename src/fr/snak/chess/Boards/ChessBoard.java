package fr.snak.chess.Boards;

import android.content.Context;
import android.graphics.*;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import fr.snak.chess.Interfaces.IPiece;
import fr.snak.chess.Models.Player;
import fr.snak.chess.Interfaces.ISquare;
import fr.snak.chess.Pieces.King;
import fr.snak.chess.Pieces.Pawn;
import fr.snak.chess.Squares.SpecialSquare;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Nautile on 09/03/2016.
 */
public class ChessBoard extends View implements View.OnTouchListener {
    public static final int NB_SQUARE_PAR_LINE = 8;
    private final RectF rectF = new RectF();
    private final Paint paintSquare = new Paint(), paintStatus = new Paint();
    private ArrayList<ISquare> chessboard;
    private ISquare selectedSquare;
    private int ref, margin;

    private Player playerTurn;
    private ArrayList<Player> listPlayer;
    private ArrayList<String> refColumn;
    //Map contain what we have to print depending on IPiece
    private HashMap<String,String>  refPiece;
    private Handler myHandler;

    private boolean currentKingCanMove;

    public ChessBoard(Context context, ArrayList<ISquare> chessboard, ArrayList<Player> listPlayer, Handler handler) {
        super(context);
        this.chessboard = chessboard;
        this.setOnTouchListener(this);

        this.listPlayer = listPlayer;
        //this.playerTurn = listPlayer.get(0);
        if(listPlayer.get(0).getColor() == IPiece.FRONT_PIECE) {
            this.playerTurn = listPlayer.get(0);
        } else {
            this.playerTurn = listPlayer.get(1);
        }

        refColumn = new ArrayList<String> () {{
            add("a");
            add("b");
            add("c");
            add("d");
            add("e");
            add("f");
            add("g");
            add("h");
        } };

        refPiece = new HashMap<String,String>() {{
            put("fr.snak.chess.Pieces.Bishop","B");
            put("fr.snak.chess.Pieces.King","K");
            put("fr.snak.chess.Pieces.Knight","N");
            put("fr.snak.chess.Pieces.Pawn","");
            put("fr.snak.chess.Pieces.Queen","Q");
            put("fr.snak.chess.Pieces.Tower","T");
            //Rock
            //Promot
            //Chess (+)
        } };

        this.myHandler= handler;

    }

    public static int currentLine(int index) {
        int value = (index - (index % NB_SQUARE_PAR_LINE)) / NB_SQUARE_PAR_LINE;
        return value;
    }

    public static int currentColumn(int index) {
        int value = index - (index - (index % NB_SQUARE_PAR_LINE));
        return value;
    }

    @Override
    public void onDraw(Canvas canvas) {
        int margeLeft, margeRight, margeTop, margeBot, line, calcLine, part;
        if (canvas.getWidth() > canvas.getHeight()) {
            ref = (int) (canvas.getHeight() * 0.85);
            margin = (int) (canvas.getHeight() * 0.15);
        } else {
            ref = (int) (canvas.getWidth() * 0.85);
            margin = (int) (canvas.getWidth() * 0.15);
        }
        part = ref / NB_SQUARE_PAR_LINE;
        line = -1;
        int size = (int) Math.pow(NB_SQUARE_PAR_LINE, 2);
        for (int i = 0; i < size; i++) {
            ISquare square = chessboard.get(i);
            calcLine = (i - i % NB_SQUARE_PAR_LINE) / NB_SQUARE_PAR_LINE;
            margeTop = calcLine * part + margin / 2;
            if (calcLine != line) {
                line = calcLine;
                margeLeft = margin / 2;
            } else {
                margeLeft = margin / 2 + part * (i % NB_SQUARE_PAR_LINE);
            }
            margeBot = margeTop + part;
            margeRight = margeLeft + part;

            if ((line + i) % 2 == 1) {
                paintSquare.setColor(Color.parseColor("#a7823d"));
            } else {
                paintSquare.setColor(Color.parseColor("#e6e6ff"));
            }
            Rect rect = new Rect(margeLeft, margeTop, margeRight, margeBot);

            canvas.drawRect(rect, paintSquare);

            int status = square.getStatus();
            if (status != ISquare.STATUS_DEFAULT) {
                int border_margin = (int) (part * 0.08);
                int inner_margin;
                switch (status) {
                    case (ISquare.STATUS_SELECTED):
                        paintStatus.setColor(Color.parseColor("#0034E1"));//"#FFA200"));
                        paintStatus.setStyle(Paint.Style.STROKE);
                        paintStatus.setStrokeWidth(border_margin);
                        inner_margin = border_margin / 2;
                        rectF.set(margeLeft + inner_margin, margeTop + inner_margin, margeRight - inner_margin, margeBot - inner_margin);
                        canvas.drawRect(rectF, paintStatus);
                        break;
                    case (ISquare.STATUS_TARGETABLE):
                        paintStatus.setColor(Color.parseColor("#D23939"));
                        paintStatus.setStyle(Paint.Style.FILL);
                        paintStatus.setStrokeWidth(0);
                        inner_margin = (int) (border_margin / 1.5);
                        rectF.set(margeLeft + inner_margin, margeTop + inner_margin, margeRight - inner_margin, margeBot - inner_margin);
                        canvas.drawRect(rectF, paintStatus);
                        break;
                    case (ISquare.STATUS_MOVE):
                        paintStatus.setColor(Color.parseColor("#3899D1"));
                        paintStatus.setStyle(Paint.Style.FILL);
                        paintStatus.setStrokeWidth(0);
                        inner_margin = (int) (border_margin / 1.5);
                        rectF.set(margeLeft + inner_margin, margeTop + inner_margin, margeRight - inner_margin, margeBot - inner_margin);
                        canvas.drawRect(rectF, paintStatus);
                        break;
                }
            }

            if (!square.isEmpty()) {
                IPiece piece = square.getPiece();

                int marginDrawable = (int) (part * 0.2);

                RelativeLayout myLayout = (RelativeLayout) this.getParent();

                int width = (margeRight - marginDrawable) - (margeLeft + marginDrawable);
                int height = (margeBot - marginDrawable) - (margeTop + marginDrawable);
                int left = margeLeft + marginDrawable;
                int top = margeTop + marginDrawable;

                piece.setImage(getContext(), myLayout, width, height, left, top);
            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int line, column;
        column = (int) ((event.getX() - margin / 2) * NB_SQUARE_PAR_LINE / ref);
        line = (int) ((event.getY() - margin / 2) * NB_SQUARE_PAR_LINE / ref);

        boolean left, top, right, bot;
        left = event.getX() - margin / 2 > 0;
        top = event.getY() - margin / 2 > 0;
        right = event.getX() - margin / 2 < ref;
        bot = event.getY() - margin / 2 < ref;

        if (left && top && right && bot) {
            ISquare square = getSquare(line, column);
            int leftImage = margin / 2 + ref / NB_SQUARE_PAR_LINE * column + (int) (ref / NB_SQUARE_PAR_LINE * 0.2);
            int topImage = margin / 2 + ref / NB_SQUARE_PAR_LINE * line + (int) (ref / NB_SQUARE_PAR_LINE * 0.2);

            if (selectedSquare != null) {
                switch (square.getStatus()) {
                    case ISquare.STATUS_MOVE:
                        //Move
                        square.add(selectedSquare.getPiece());
                        selectedSquare.getPiece().animate(leftImage, topImage);
                        selectedSquare.remove();
                        upgradePiece(square);
                        addMoves(square.getPiece(),line,column);
                        changeTurn();
                        break;
                    case ISquare.STATUS_TARGETABLE:
                        //Eat
                        square.getPiece().hideImage();
                        square.add(selectedSquare.getPiece());
                        square.getPiece().animate(leftImage, topImage);
                        selectedSquare.remove();
                        upgradePiece(square);
                        addMoves(square.getPiece(),line,column);
                        changeTurn();
                        break;
                }

                //addMoves(square.getPiece(),line,column);
                //changeTurn();
            }

            this.resetSquares();
            if (selectedSquare == null) {
                IPiece piece = square.getPiece();
                if (piece != null && piece.getType() == playerTurn.getColor()) {
                    detectDangerousSquare();
                    piece.detectMoves(this.chessboard, true);
                    selectedSquare = square;
                }
                square.setStatus(ISquare.STATUS_SELECTED);
            } else {
                selectedSquare = null;
            }

            this.invalidate();
        }
        return false;
    }

    private void detectDangerousSquare(){
        for(ISquare square : this.chessboard){
            if(!square.isEmpty()){
                IPiece piece = square.getPiece();
                if(piece.getType() != this.playerTurn.getColor()){
                    piece.detectMoves(this.chessboard,false);
                }
            }
        }
        for(ISquare square : this.chessboard){
            if(!square.isEmpty()){
                IPiece piece = square.getPiece();
                if(piece.getType() == this.playerTurn.getColor()){
                    if(piece.getClass().getName().equals(King.class.getName())){
                        King myKing = (King) piece;
                        currentKingCanMove = myKing.canMove();
                        System.out.println("MY KING CAN MOVE : "+currentKingCanMove);
                    }
                }
            }
        }
    }

    private void upgradePiece(ISquare square) {
        if (square.getClass().getName().equals(SpecialSquare.class.getName())) {
            if (!square.isEmpty() && square.getPiece().getClass().getName().equals(Pawn.class.getName())) {
                PopupUpgrade cdd = new PopupUpgrade(this, square);
                cdd.show();
            }
        }
    }

    public void resetSquares() {
        for (ISquare square : this.chessboard) {
            square.resetStatus();
        }
    }

    public ISquare getSquare(int line, int column) {
        int value = line * 8 + column;
        if (value < this.chessboard.size()) {
            return this.chessboard.get(value);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        String value = "ChessBoard{";
        int i = 0;
        for (ISquare square : chessboard) {
            if (i++ % 8 == 0) {
                value += "\n";
            }
            ;
            value += square.toString() + ",";
        }
        value += "}";
        return value;
    }

    //Allow the other player to play
    private void changeTurn() {
        if (playerTurn == listPlayer.get(0)) {
            playerTurn = listPlayer.get(1);
        } else {
            playerTurn = listPlayer.get(0);
        }
    }

    //Save Moves
    private void addMoves(IPiece piece,int lineEnd, int columnEnd) {
        //Remove comment if we want to print all the move
        /*
        int lineStart=-1,columnStart=-1;
        System.out.println("line : " + lineEnd);
        System.out.println("column  : " + columnEnd);
        */
        //Piece
        String p = refPiece.get(piece.getClass().toString().substring(6));

        /*
        for (int i=0; i < 8 ; i++) {
            for (int j=0; j < 8 ; j++) {
                if(selectedSquare == getSquare(i,j)) {
                    lineStart = i;
                    columnStart = j;
                    break;
                }
            }
        }
        System.out.println("START");
        System.out.println("LINE : " + lineStart);
        System.out.println("COLUMN : " + columnStart);
        //Piece-Start(coumn,line)-End(column,line)

        System.out.println("column name : " + refColumn.get(columnStart));

        System.out.println("RESULT");
        System.out.println(p+refColumn.get(columnStart)+(lineStart+1)+"-"+refColumn.get(columnEnd)+(lineEnd+1));
        */
        //System.out.println(p+refColumn.get(columnEnd)+(lineEnd+1));
        String move = p+refColumn.get(columnEnd)+(lineEnd+1);

        int player;
        if(playerTurn==listPlayer.get(0)) {
            player = 0;
        } else {
            player = 1;
        }
        Message msgObj = new Message();
        Bundle bundle = new Bundle();
        bundle.putInt("player",player);
        bundle.putString("move",move);
        msgObj.setData(bundle);
        myHandler.sendMessage(msgObj);
    }

}

package fr.snak.chess.View;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import fr.snak.chess.Boards.Boards;
import fr.snak.chess.Models.ChessBoard;
import fr.snak.chess.R;



/**
 * Created by sylvain on 09/03/2016.
 */
public class Game extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamev3);
        RelativeLayout layout;    // = (LinearLayout) findViewById(R.id.gameLayoutOne);

        Boards board;
        ChessBoard chessboard;

        WindowManager wm = (WindowManager) this.getSystemService(this.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        int reference;
        if(width>height){
            reference = height;
        }else{
            reference = width;
        }

        RelativeLayout.LayoutParams params;
        params = new RelativeLayout.LayoutParams(reference,reference);

        //TOWER
        //board = new Boards(Boards.BOARD_TEST_MOVES_TOWER);
        //QUEEN
        //board = new Boards(Boards.BOARD_TEST_MOVES_QUEEN);
        //KING
        //board = new Boards(Boards.BOARD_TEST_MOVES_KING);
        //KNIGHT
        //board = new Boards(Boards.BOARD_TEST_MOVES_KNIGHT);
        //DEFAULT
        //board = new Boards(Boards.BOARD_DEFAULT);

        //INIT TEST GAME ONE
        //board = new Boards(Boards.BOARD_TEST_MOVES_GAME_ONE);

        //PAWNS
        layout = (RelativeLayout) findViewById(R.id.gameLayoutPawnsMove);


        board = new Boards(Boards.BOARD_TEST_MOVES_PAWN);
        chessboard = new ChessBoard(this, board.getBoard());
        //chessboard.setMinimumHeight(LayoutParams.WRAP_CONTENT);
        layout.addView(chessboard, params);



        //layoutRelative.addView(chessboard);

        //BISHOPS
        layout = (RelativeLayout) findViewById(R.id.gameLayoutBishopsMove);
        board = new Boards(Boards.BOARD_TEST_MOVES_BISHOP);
        chessboard = new ChessBoard(this, board.getBoard());
        layout.addView(chessboard, params);

        //TOWERS
        layout = (RelativeLayout) findViewById(R.id.gameLayoutTowersMove);
        board = new Boards(Boards.BOARD_TEST_MOVES_TOWER);
        chessboard = new ChessBoard(this, board.getBoard());
        layout.addView(chessboard, params);

        //KNIGHTS
        layout = (RelativeLayout) findViewById(R.id.gameLayoutKnightsMove);
        board = new Boards(Boards.BOARD_TEST_MOVES_KNIGHT);
        chessboard = new ChessBoard(this, board.getBoard());
        layout.addView(chessboard, params);

        //QUEENS
        layout = (RelativeLayout) findViewById(R.id.gameLayoutQueensMove);
        board = new Boards(Boards.BOARD_TEST_MOVES_QUEEN);
        chessboard = new ChessBoard(this, board.getBoard());
        layout.addView(chessboard, params);

        //KINGS
        layout = (RelativeLayout) findViewById(R.id.gameLayoutKingsMove);
        board = new Boards(Boards.BOARD_TEST_MOVES_KING);
        chessboard = new ChessBoard(this, board.getBoard());
        layout.addView(chessboard, params);

        //GAME_ONE
        layout = (RelativeLayout) findViewById(R.id.gameLayoutGameOneMove);
        board = new Boards(Boards.BOARD_DEFAULT);
        chessboard = new ChessBoard(this, board.getBoard());
        layout.addView(chessboard, params);

        //GAME_TWO
        layout = (RelativeLayout) findViewById(R.id.gameLayoutGameTwoMove);
        board = new Boards(Boards.BOARD_TEST_MOVES_GAME_ONE);
        chessboard = new ChessBoard(this, board.getBoard());
        layout.addView(chessboard, params);
    }


}

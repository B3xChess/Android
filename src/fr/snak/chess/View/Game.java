package fr.snak.chess.View;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import android.widget.*;
import fr.snak.chess.Boards.Boards;
import fr.snak.chess.Boards.ChessBoard;
import fr.snak.chess.Models.Player;
import fr.snak.chess.R;
import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by sylvain on 09/03/2016.
 */
public class Game extends Activity {
    //Name
    private TextView textViewFirstPlayer;
    private TextView textViewSecondPlayer;

    //List Move
    private ListView listViewMoveFirstPlayer;
    private ListView listViewMoveSecondPlayer;

    private ArrayList<String> listMoveFirstPlayer;
    private ArrayList<String> listMoveSecondPlayer;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamev3);
        RelativeLayout layout;    // = (LinearLayout) findViewById(R.id.gameLayoutOne);

        //Get listPlayer
        Bundle extras = getIntent().getExtras();
        ArrayList<Player> listPlayer = extras.getParcelableArrayList("listPlayer");

        Boards board;
        ChessBoard chessboard;

        WindowManager wm = (WindowManager) this.getSystemService(this.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        int reference;
        if (width > height) {
            reference = height;
        } else {
            reference = width;
        }

        RelativeLayout.LayoutParams params;
        params = new RelativeLayout.LayoutParams(reference, reference);
/*
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
        */
        //--GAME--\\
        //Name
            //First
        textViewFirstPlayer = (TextView) findViewById(R.id.textViewFirstPlayer);
        textViewFirstPlayer.setText(listPlayer.get(0).getName());
            //Second
        textViewSecondPlayer = (TextView) findViewById(R.id.textViewSecondPlayer);
        textViewSecondPlayer.setText(listPlayer.get(1).getName());

        //Initilisation
        listMoveFirstPlayer = new ArrayList<>();
        listMoveSecondPlayer = new ArrayList<>();

        //handler
        Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                //System.out.println("MESSAGE : " + msg);
                int player = msg.getData().getInt("player");
                String move = msg.getData().getString("move");

                showMoves(player, move);

            }
        };
        //Board
        layout = (RelativeLayout) findViewById(R.id.gameLayoutGameOneMove);
        board = new Boards(Boards.BOARD_DEFAULT);
        //chessboard = new ChessBoard(this, board.getBoard());
        //chessboard = new ChessBoard(this, board.getBoard(),listPlayer);
        chessboard = new ChessBoard(this, board.getBoard(), listPlayer, handler);
        layout.addView(chessboard, params);
    }

    private void showMoves(int player, String move) {
        System.out.println("player : " + player);
        System.out.println("move : " + move);
        switch (player) {
            case 0:
                listMoveFirstPlayer.add(move);
                break;
            case 1:
                listMoveSecondPlayer.add(move);
                break;
        }

        //First Player
        listViewMoveFirstPlayer = (ListView) findViewById(R.id.listViewMoveFirstPlayer);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.liste_view_item, listMoveFirstPlayer);
        listViewMoveFirstPlayer.setAdapter(adapter);

        //Second Player
        listViewMoveSecondPlayer = (ListView) findViewById(R.id.listViewMoveSecondPlayer);
        adapter = new ArrayAdapter<String>(this, R.layout.liste_view_item, listMoveSecondPlayer);
        listViewMoveSecondPlayer.setAdapter(adapter);
    }
}

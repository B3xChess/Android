package fr.snak.chess;

import android.app.Activity;
import android.os.Bundle;
import fr.snak.chess.Models.*;


public class Main extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TestInitGame();
    }

    public void TestInitGame(){
        ChessBoard myChessBoard = new ChessBoard();
        System.out.println(myChessBoard);
        System.out.println("A5 : " + myChessBoard.getSquare('A',5));
        System.out.println("A9 : " + myChessBoard.getSquare('A',9));
        System.out.println("H6 : " + myChessBoard.getSquare('H',6));
        System.out.println("H0 : " + myChessBoard.getSquare('H',0));
        System.out.println("D5 : " + myChessBoard.getSquare('D',5));
    }
}

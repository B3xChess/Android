package fr.snak.chess.Boards;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import fr.snak.chess.Interfaces.ISquare;
import fr.snak.chess.Pieces.Bishop;
import fr.snak.chess.Pieces.Knight;
import fr.snak.chess.Pieces.Qween;
import fr.snak.chess.Pieces.Tower;
import fr.snak.chess.R;

/**
 * Created by Nautile on 22/04/2016.
 */
public class PopupUpgrade extends Dialog implements android.view.View.OnClickListener {

    public Button buttonQueen, buttonBishop, buttonKnight, buttonTower;
    private ISquare square;
    private ChessBoard chessBoard;

    public PopupUpgrade(ChessBoard chessboard, ISquare square) {
        super(chessboard.getContext());
        this.square = square;
        this.chessBoard = chessboard;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup4square);

        //Queen
        buttonQueen = (Button) findViewById(R.id.buttonQueen);
        buttonQueen.setOnClickListener(this);
        //Bishop
        buttonBishop = (Button) findViewById(R.id.buttonBishop);
        buttonBishop.setOnClickListener(this);
        //Knight
        buttonKnight = (Button) findViewById(R.id.buttonKnight);
        buttonKnight.setOnClickListener(this);
        //Tower
        buttonTower = (Button) findViewById(R.id.buttonTower);
        buttonTower.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (!this.square.isEmpty()) {
            int type = square.getPiece().getType();
            square.getPiece().hideImage();
            switch (v.getId()) {
                case R.id.buttonQueen:
                    square.add(new Qween(type));
                    break;
                case R.id.buttonBishop:
                    square.add(new Bishop(type));
                    break;
                case R.id.buttonKnight:
                    square.add(new Knight(type));
                    break;
                case R.id.buttonTower:
                    square.add(new Tower(type));
                    break;
                default:
                    break;
            }
        }
        dismiss();
        chessBoard.invalidate();
    }

}
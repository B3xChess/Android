package fr.snak.chess.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import fr.snak.chess.Boards.ChessBoard;
import fr.snak.chess.Boards.PopupUpgrade;
import fr.snak.chess.Interfaces.IPiece;
import fr.snak.chess.Interfaces.ISquare;
import fr.snak.chess.Models.Player;
import fr.snak.chess.R;
import fr.snak.chess.Squares.SpecialSquare;
import fr.snak.chess.Squares.Square;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sylvain on 03/05/2016.
 */
public class TypeGame extends Activity implements View.OnClickListener {

    //Interface
    private Button buttonOnePlayer;
    private Button buttonTwoPlayer;
    private Button buttonOnline;

    private Activity _instance;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type_game);

        //One Player
        buttonOnePlayer = (Button) findViewById(R.id.buttonOnePlayer);
        buttonOnePlayer.setOnClickListener(this);
        buttonOnePlayer.setText(R.string.onePlayer);

        //Two Player
        buttonTwoPlayer = (Button) findViewById(R.id.buttonTwoPlayer);
        buttonTwoPlayer.setOnClickListener(this);
        buttonTwoPlayer.setText(R.string.twoPlayer);

        //Online
        buttonOnline = (Button) findViewById(R.id.buttonOnline);
        buttonOnline.setOnClickListener(this);
        buttonOnline.setText(R.string.online);

        _instance=this;

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonOnePlayer :
                Toast.makeText(getApplicationContext(), "Not dev yet", Toast.LENGTH_LONG).show();
                break;
            case R.id.buttonTwoPlayer :
                //Player
                ArrayList<Player> listPlayer = new ArrayList<Player>();
                listPlayer.add(new Player("Undefinded 1", IPiece.FRONT_PIECE));
                listPlayer.add(new Player("Undefinded 2", IPiece.BACK_PIECE));

                //Dialog
                TypeGameDialog tgd = new TypeGameDialog(_instance,"Two Players",listPlayer);
                tgd.show();
                break;
            case R.id.buttonOnline :
                Toast.makeText(getApplicationContext(), "Not dev yet", Toast.LENGTH_LONG).show();
                break;
            default:
                //Error
                break;
        }
    }
}

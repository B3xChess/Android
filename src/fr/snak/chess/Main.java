package fr.snak.chess;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import fr.snak.chess.View.Game;
import fr.snak.chess.Models.*;


public class Main extends Activity implements View.OnClickListener {
    /**
     * Called when the activity is first created.
     */
    private Button buttonGame;
    private Button buttonSettings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        buttonGame = (Button) findViewById(R.id.buttonGame);
        buttonGame.setOnClickListener(this);

        buttonSettings = (Button) findViewById(R.id.buttonSettings);
        buttonSettings.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if( v == buttonGame ) {
            Intent intent = new Intent(this, Game.class);
            startActivity(intent);
        }

        if( v == buttonSettings ){
            Toast.makeText(getApplicationContext(), "Not dev yet", Toast.LENGTH_LONG).show();
        }


    }
}

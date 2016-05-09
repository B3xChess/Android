package fr.snak.chess.View;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.*;
import android.widget.*;
import fr.snak.chess.Interfaces.IPiece;
import fr.snak.chess.Models.Player;
import fr.snak.chess.R;
import java.util.ArrayList;

/**
 * Created by sylvain on 03/05/2016.
 */
public class TypeGameDialog extends Dialog implements View.OnClickListener {
    private Activity c;
    public Dialog d;

    private EditText editTextName;
    private TextView buttotextViewName;

    //Title
    private TextView tvTitle;

    //First Player
    private TextView tvFirstPlayer;
    private TextView tvNameFirstPlayer;
    private EditText etNameFirstPlayer;
    private ImageView ivFirstPlayer;

    //Switch
    private ImageView ivSwitch;

    //Second Player
    private TextView tvSecondPlayer;
    private TextView tvNameSecondPlayer;
    private EditText etNameSecondPlayer;
    private ImageView ivSecondPlayer;

    //Layout
    private Button buttonCancel;
    private Button buttonStart;
    private String title;

    private Dialog _instance;

    private ArrayList<Player> listPlayer;
    private boolean repeatFirst;
    private boolean repeatSecond;


    public TypeGameDialog(Activity a, String title, ArrayList<Player> listPlayer) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;

        this.title = title;

        this._instance = this;
        this.listPlayer = listPlayer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.type_game_dialog);

        //Title
        tvTitle = (TextView) findViewById(R.id.textViewTitle);
        tvTitle.setText(title);

        //First Player
        //tvFirstPlayer
        tvFirstPlayer = (TextView) findViewById(R.id.textViewFirstPlayer);
        tvFirstPlayer.setText(R.string.firstPlayer);
        //tvNameFirstPlayer
        tvNameFirstPlayer = (TextView) findViewById(R.id.textViewNameFirstPlayer);
        tvNameFirstPlayer.setText(R.string.namePlayer);
        //etNameFirstPlayer
        etNameFirstPlayer = (EditText) findViewById(R.id.editTextNameFirstPlayer);
        //ivFirstPlayer
        ivFirstPlayer = (ImageView) findViewById(R.id.imageViewFirstPlayer);
        ivFirstPlayer.setOnClickListener(this);

        //Switch
        ivSwitch = (ImageView) findViewById(R.id.imageViewSwitch);
        ivSwitch.setOnClickListener(this);

        //Second Player
        //tvSecondPlayer
        tvSecondPlayer = (TextView) findViewById(R.id.textViewSecondPlayer);
        tvSecondPlayer.setText(R.string.secondPlayer);
        //tvNameSecondPlayer
        tvNameSecondPlayer = (TextView) findViewById(R.id.textViewNameSecondPlayer);
        tvNameSecondPlayer.setText(R.string.namePlayer);
        //etNameSecondPlayer
        etNameSecondPlayer = (EditText) findViewById(R.id.editTextNameSecondPlayer);
        //ivSecondPlayer
        ivSecondPlayer = (ImageView) findViewById(R.id.imageViewSecondPlayer);
        ivSecondPlayer.setOnClickListener(this);

        //Layout
        //Cancel
        buttonCancel = (Button) findViewById(R.id.buttonCancel);
        buttonCancel.setText(R.string.buttonCancel);
        buttonCancel.setOnClickListener(this);
        //Start
        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStart.setText(R.string.buttonStart);
        buttonStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //First Player
            case R.id.imageViewFirstPlayer:
                switchColor();
                break;
            //Second Player
            case R.id.imageViewSecondPlayer:
                switchColor();
                break;
            //SwitchArrow
            case R.id.imageViewSwitch:
                switchColor();
                break;
            //Instance
            case R.id.buttonCancel:
                _instance.cancel();
                break;
            case R.id.buttonStart:
                //Player
                if (etNameFirstPlayer.getText().length() != 0) {
                    listPlayer.get(0).setName(String.valueOf(etNameFirstPlayer.getText()));
                }

                if (etNameSecondPlayer.getText().length() != 0) {
                    listPlayer.get(1).setName(String.valueOf(etNameSecondPlayer.getText()));
                }

                //Game
                Intent intent = new Intent(c, Game.class);
                intent.putExtra("data", "value");
                intent.putParcelableArrayListExtra("listPlayer", listPlayer);
                c.startActivity(intent);

                break;
            default:
                System.out.println("Error");
                break;
        }

        //dismiss();
    }

    private void switchColor() {
        animSwitchArrow();
        animPieceFirst();
        animPieceSecond();
    }


    public void animPieceFirst() {
        //RotateAnimation(float fromDegrees, float toDegrees, float pivotX, float pivotY)
        RotateAnimation rAnim = new RotateAnimation(0, 360, 50, 50);

        rAnim.setDuration(500);
        rAnim.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (repeatFirst) {
                    ivFirstPlayer.setImageResource(R.drawable.wqueen);
                    listPlayer.get(0).setColor(IPiece.FRONT_PIECE);
                    repeatFirst = false;
                } else {
                    ivFirstPlayer.setImageResource(R.drawable.bqueen);
                    listPlayer.get(0).setColor(IPiece.BACK_PIECE);
                    repeatFirst = true;
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        ivFirstPlayer.startAnimation(rAnim);
    }

    public void animPieceSecond() {
        //RotateAnimation(float fromDegrees, float toDegrees, float pivotX, float pivotY)
        RotateAnimation rAnim = new RotateAnimation(0, 360, 50, 50);

        rAnim.setDuration(500);
        rAnim.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (repeatSecond) {
                    ivSecondPlayer.setImageResource(R.drawable.bqueen);
                    listPlayer.get(1).setColor(IPiece.BACK_PIECE);
                    repeatSecond = false;
                } else {
                    ivSecondPlayer.setImageResource(R.drawable.wqueen);
                    listPlayer.get(1).setColor(IPiece.FRONT_PIECE);
                    repeatSecond = true;
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        ivSecondPlayer.startAnimation(rAnim);
    }

    public void animSwitchArrow() {
        //RotateAnimation(float fromDegrees, float toDegrees, float pivotX, float pivotY)
        RotateAnimation rAnim = new RotateAnimation(0, 360, 50, 50);
        rAnim.setDuration(500);

        ivSwitch.startAnimation(rAnim);
    }
}
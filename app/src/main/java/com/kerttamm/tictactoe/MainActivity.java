package com.kerttamm.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    private Button[][] buttons = new Button[3][3];
    private boolean player1Turn = true;
    private boolean lastPlayer1 = true;
    private int roundCount;
    private int player1Points;
    private int player2Points;
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;

    public void DisplayWhichPlayersTurn(){
        if(player1Turn == true){
            textViewPlayer1.setText("PLAYER 1"+" : "+ player1Points+" turn");
            textViewPlayer2.setText("PLAYER 2"+" : "+player2Points);
        }else{
            textViewPlayer2.setText("PLAYER 2"+" : "+player2Points+" turn");
            textViewPlayer1.setText("PLAYER 1"+" : "+ player1Points);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPlayer1 = findViewById(R.id.text_view_p1);
        textViewPlayer2 = findViewById(R.id.text_view_p2);
        textViewPlayer1.setText("PLAYER 1"+" : "+ player1Points+" turn");
        textViewPlayer2.setText("PLAYER 2"+" : "+player2Points);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }

        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        }); // Reset Button functionality

        Button buttonExit = findViewById(R.id.button_exit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitGame();
            }
        }); // Exit button functionality

        getSupportActionBar().hide(); //Hides the Top Action Bar

    }

    public void exitGame(){

        Intent _intentOBJ= new Intent(Intent.ACTION_MAIN);
        _intentOBJ.addCategory(Intent.CATEGORY_HOME);
        _intentOBJ.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        _intentOBJ.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(_intentOBJ);

    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }

        if (player1Turn) {
            ((Button) v).setText("X");
            lastPlayer1=true;
        } else {
            ((Button) v).setText("O");
            lastPlayer1=false;
        }

        roundCount++;

        if (checkForWin()) {
            if (player1Turn) {
                player1Wins();
                player1Turn=false;
            } else {
                player2Wins();
                player1Turn=true;
            }
        } else if (roundCount == 9) {
            draw();
        } else {
            player1Turn = !player1Turn;
        }

        DisplayWhichPlayersTurn();

    }

    private boolean checkForWin() {
        String[][] field = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")) {
                return true;
            }
        }

        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            return true;
        }

        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")) {
            return true;
        }

        return false;
    }

    private void player1Wins() {
        player1Points++;
        Toast.makeText(this, "PLAYER 1 WON!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void player2Wins() {
        player2Points++;
        Toast.makeText(this, "PLAYER 2 WON!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void draw() {
        Toast.makeText(this, "IT'S A DRAW!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void updatePointsText() {
        textViewPlayer1.setText("PLAYER 1: " + player1Points + " turn");
        textViewPlayer2.setText("PLAYER 2: " + player2Points);
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }

        roundCount = 0;

    }

    private void resetGame() {
        player1Points = 0;
        player2Points = 0;
        updatePointsText();
        resetBoard();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("roundCount", roundCount);
        outState.putInt("player1Points", player1Points);
        outState.putInt("player2Points", player2Points);
        outState.putBoolean("player1Turn", player1Turn);
        outState.putBoolean("player1Turn", lastPlayer1);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        roundCount = savedInstanceState.getInt("roundCount");
        player1Points = savedInstanceState.getInt("player1Points");
        player2Points = savedInstanceState.getInt("player2Points");
        player1Turn = savedInstanceState.getBoolean("player1Turn");
        player1Turn = savedInstanceState.getBoolean("lastPlayer1");
    }
}
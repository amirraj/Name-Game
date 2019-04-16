package com.example.aspire.namegame;

import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class HomeActivity extends AppCompatActivity {

    private Button newGameButton,joinGameButton,highScoreButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        newGameButton = (Button)findViewById(R.id.NewGameButton);
        joinGameButton = (Button)findViewById(R.id.JoinGameButton);
        highScoreButton = (Button)findViewById(R.id.HighScoreButton);

        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewGameActivity();
            }
        });

        joinGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openJoinGameActivity();
            }
        });

        highScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHighScoreActivity();
            }
        });

    }
    public void openNewGameActivity()
    {
        Intent intent = new Intent(this,NewGameActivity.class);
        startActivity(intent);
    }

    public void openJoinGameActivity()
    {
        Intent intent = new Intent(this,JoinGameActivity.class);
        startActivity(intent);
    }

    public void openHighScoreActivity()
    {
        Intent intent = new Intent(this,HighScoreActivity.class);
        startActivity(intent);
    }

}

package com.example.aspire.namegame;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HighScoreActivity extends AppCompatActivity {

    DatabaseHelper db;
    SQLiteDatabase mDatabase;
    Button showGameTableButtuon,showPlayerTableButtuon,showScoreTableButtuon;
    private String DB_NAME = "NameGame.db";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        showGameTableButtuon = (Button)findViewById(R.id.ShowGameTable);
        viewGame();
        showPlayerTableButtuon = (Button)findViewById(R.id.ShowPlayertable);
        viewPlayer();
        showScoreTableButtuon = (Button)findViewById(R.id.ShowScoretable);
        viewScore();
        mDatabase = openOrCreateDatabase(DB_NAME,MODE_PRIVATE,null);

        //db = new DatabaseHelper(getApplicationContext());
       // db.addGame("classical","easy","random","flower");
        //Toast.makeText(this,"Value Saved",Toast.LENGTH_SHORT).show();
    }

    public void viewGame()
    {
        showGameTableButtuon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sql = "select * from Game";
                StringBuffer buffer = new StringBuffer();
                Cursor cursor = mDatabase.rawQuery(sql,null);

                if(cursor.moveToFirst())
                {
                    do{
                        String id = cursor.getString(0);
                        buffer.append("Id : "+id+"\n");

                        String mode = cursor.getString(1);
                        buffer.append("Mode : "+mode+"\n");

                        String difficulty = cursor.getString(2);
                        buffer.append("Difficulty : "+difficulty+"\n");

                        String letter = cursor.getString(3);
                        buffer.append("Letter : "+letter+"\n");

                        String topics = cursor.getString(4);
                        buffer.append("Topics : "+topics+"\n\n");
                    }while (cursor.moveToNext());
                }

                showMessage("Games",buffer.toString());

            }

        });
    }

    public void viewPlayer()
    {
        showPlayerTableButtuon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sql = "select * from Player";
                StringBuffer buffer = new StringBuffer();
                Cursor cursor = mDatabase.rawQuery(sql,null);

                if(cursor.moveToFirst())
                {
                    do{
                        String id = cursor.getString(0);
                        buffer.append("Id : "+id+"\n");

                        String name = cursor.getString(1);
                        buffer.append("Name : "+name+"\n\n");


                    }while (cursor.moveToNext());
                }

                showMessage("Players",buffer.toString());

            }

        });
    }

    public void viewScore()
    {
        showScoreTableButtuon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sql = "select * from GamePlay";
                StringBuffer buffer = new StringBuffer();
                Cursor cursor = mDatabase.rawQuery(sql,null);

                if(cursor.moveToFirst())
                {
                    do{
                        String gid = cursor.getString(0);
                        buffer.append("Game id : "+gid+"\n");

                        String pid = cursor.getString(1);
                        buffer.append("Player id : "+pid+"\n");

                        String score = cursor.getString(2);
                        buffer.append("Score : "+score+"\n\n");


                    }while (cursor.moveToNext());
                }

                showMessage("Scores",buffer.toString());

            }

        });
    }
    public void showMessage(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}

package com.example.aspire.namegame;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aspire on 16-Apr-19.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "NameGame.db";
    public static final int DB_VERSION = 1;


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlGame = "create table Game(id INTEGER PRIMARY KEY AUTOINCREMENT, mode TEXT, difficulty TEXT, letter TEXT, topics TEXT);";
        String sqlPlayer = "create table Player(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);";
        String sqlGamePlay = "create table GamePlay(gid INTEGER, pid INTEGER, score INTEGER);";

        sqLiteDatabase.execSQL(sqlPlayer);
        sqLiteDatabase.execSQL(sqlGame);
        sqLiteDatabase.execSQL(sqlGamePlay);

    }
    public boolean addGame(String mode,String difficulty,String letter,String topics)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mode",mode);
        contentValues.put("difficulty",difficulty);
        contentValues.put("letter",letter);
        contentValues.put("topics",topics);
        db.insert("Game",null,contentValues);
        db.close();
        return true;
    }

    public boolean addPlayer(String name)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);

        db.insert("Player",null,contentValues);
        db.close();
        return true;
    }

    public boolean addGamePlay(int gid,int pid,int score)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("gid",gid);
        contentValues.put("pid",pid);
        contentValues.put("score",score);

        db.insert("GamePlay",null,contentValues);
        db.close();
        return true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

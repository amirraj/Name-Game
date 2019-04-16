package com.example.aspire.namegame;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aspire on 13-Apr-19.
 */

public class AssetDatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static AssetDatabaseAccess instance;
    Cursor c = null;

    private AssetDatabaseAccess(Context context)
    {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static AssetDatabaseAccess getInstance(Context context)
    {
        if(instance==null)
        {
            instance = new AssetDatabaseAccess(context);
        }
         return instance;
    }

    public void open()
    {
        this.db = openHelper.getWritableDatabase();
    }
    public void close()
    {
        if(db != null)
            this.db.close();
    }

    public StringBuffer getItem (String topic)
    {
        c = db.rawQuery("select * from "+topic+"",null);
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext())
        {
            String item = c.getString(0);
            buffer.append(item+"\n");
        }
        return buffer;
    }
    public void createTable(String tableName)
    {
        db.execSQL("create table " + tableName + " (item text)",null);
    }
}

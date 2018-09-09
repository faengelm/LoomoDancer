package com.faengelm.broadcastdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "numberDb";
    private static final int DATABASE_VERSION = 1;
 /*   private static final String CREASTE = createtable " +DbContract.TABLE_NAME+"(
    id integer
    primary key
    autoincrement,"DbContract.INCOMING_NUMBER+"text);
 */
    private static final String DROP_TABLE = "drop table if exists " + DbContract.TABLE_NAME;

    public DbHelper(Context context) {  // Constructor

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE);
    }

    public void saveNumber(String number, SQLiteDatabase database){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbContract.INCOMING_NUMBER, number);
        database.insert(DbContract.TABLE_NAME,null,contentValues);

    }

}




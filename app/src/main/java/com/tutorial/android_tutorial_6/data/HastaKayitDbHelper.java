package com.tutorial.android_tutorial_6.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tutorial.android_tutorial_6.data.HastaKayitContract.HastaEntry;
import com.tutorial.android_tutorial_6.data.HastaKayitContract.DoktorEntry;

/**
 * Created by SEYMA1 on 21.7.2017.
 */
public class HastaKayitDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "hastakayit.db";

    public HastaKayitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_HASTA_TABLOSU = "CREATE TABLE " + HastaEntry.TABLE_NAME + "(" +
                HastaEntry._ID + " INTEGER PRIMARY KEY," +
                HastaEntry.COLUMN_HASTA_ISMI + " TEXT NOT NULL," +
                HastaEntry.COLUMN_HASTA_YAS + " INTEGER NOT NULL," +
                HastaEntry.COLUMN_HASTA_ADRES + " TEXT NOT NULL " +
                ")";

        final String SQL_CREATE_DOKTOR_TABLOSU = "CREATE TABLE " + DoktorEntry.TABLE_NAME + "(" +
                DoktorEntry._ID + " INTEGER PRIMARY KEY," +
                DoktorEntry.COLUMN_DOKTOR_ISMI + " TEXT NOT NULL," +
                DoktorEntry.COLUMN_DOKTOR_BRANS + " TEXT NOT NULL" +
                ")";

        db.execSQL(SQL_CREATE_HASTA_TABLOSU);
        db.execSQL(SQL_CREATE_DOKTOR_TABLOSU);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST " + HastaEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXIST " + DoktorEntry.TABLE_NAME);
        onCreate(db);

    }
}


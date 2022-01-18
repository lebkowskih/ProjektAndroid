package com.example.projektandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create table users(login TEXT,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("drop table if exists users");
    }

    public Boolean insertData(String login, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("login",login);
        contentValues.put("password",password);




        long result = myDB.insert("users",null,contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkLogin(String login){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where login=?",new String[] {login});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkLoginPassword(String login, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where login = ? and password = ?",new String[] {login,password});
        System.out.println("Hej look at me" + cursor.getCount());
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}

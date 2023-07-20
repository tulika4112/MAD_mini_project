package com.example.feelsecure;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android. database.sqlite. SQLiteOpenHelper;
import androidx. annotation.Nullable;

public class database extends SQLiteOpenHelper {
    public static final String databaseName="signup.db";
    public database(@Nullable Context context) {
        super(context, "signup.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 = "create table users(username text, email text, password text)";
        sqLiteDatabase.execSQL(qry1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean register(String username, String email, String password) {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("amail", email);
        cv.put("password", password);
        long result=db.insert("users",null,cv);
        db.insert("users",null, cv);
        if(result==-1){
            return false;
        }
        else
        {
            return true;
        }

    }
    public int login(String username,String pass){
        int result=0;

        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("select * from users where username=? and password=?",new String[]{username,pass});
        if(c.getCount()>0){
            result=1;
        }
        return result;

    }




}
package com.example.ma_lab_10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, "users.db", null, 1);
    }

    //Called when Database object is first accessed
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE users(ID INTEGER PRIMARY KEY AUTOINCREMENT, user_name TEXT, user_sub TEXT)";
        db.execSQL(createTableStatement);
    }

    //Called when version number of database changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(Item item){

        SQLiteDatabase db;
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("user_name", item.getName());
        cv.put("user_sub", item.getDuration());

        long insert = db.insert("users", null,cv);

        if(insert == -1){
            return false;
        }
        return true;
    }

    public List<Item> getEveryone(){
        List<Item> returnList = new ArrayList<>();

        String selectQuery = "SELECT * FROM users";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String subs = cursor.getString(2);

                Item item = new Item(name, subs, id);

                returnList.add(item);
            } while (cursor.moveToNext());
        }
        else{
            //No Results From Database, returnList will be returned empty
        }
        cursor.close();
        db.close();
        return returnList;
    }

    public boolean deleteUser(int id){
        SQLiteDatabase db = this.getWritableDatabase();


        String delQuery = "DELETE FROM users WHERE ID ="+id;
        Cursor cursor = db.rawQuery(delQuery, null);

        if(cursor.moveToFirst()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean updateUser(int id, String name, String subs){
        SQLiteDatabase db = this.getWritableDatabase();

        String getUser = "SELECT * FROM users WHERE ID="+id;
        ContentValues cv = new ContentValues();
        cv.put("ID", id);
        cv.put("user_name", name);
        cv.put("user_sub", subs);
        Cursor cursor = db.rawQuery(getUser, null);

        if(cursor.getCount()>0){
            long r = db.update("users", cv,"ID="+id, null);

            if(r==-1) return false;
            else return true;
        }
        else{
            return false;
        }

    }
}

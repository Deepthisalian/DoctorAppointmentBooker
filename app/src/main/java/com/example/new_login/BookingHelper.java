package com.example.new_login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

//Create constructor and methods suitable
public class BookingHelper extends SQLiteOpenHelper {
    public BookingHelper(@Nullable Context context) {
        super(context, "Booking.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS APPOINTMENT(name varchar(20) primary key,age int,gender varchar(10),dates varchar(10),times varchar(6))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    //methods for operations on database
    public long insertData(String name, int age,String gender, String dates, String times) {
        SQLiteDatabase db=getWritableDatabase();  //writable objects
        ContentValues c=new ContentValues();
        c.put("name",name);
        c.put("age",age);
        c.put("gender",gender);
        c.put("dates",dates);
        c.put("times",times);
        return db.insert("APPOINTMENT",null,c);
    }
    public Cursor getData()
    {
        SQLiteDatabase db=getWritableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM STUDENT",null);
        return c;
    }


}
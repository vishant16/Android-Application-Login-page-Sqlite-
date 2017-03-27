package com.example.vishu.attendance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;

import static android.R.attr.name;

/**
 * Created by vishu on 18/1/17.
 */

public class DataBaseHelper extends SQLiteOpenHelper
{
    private static final int Database_version=1;
    private static final String database_name="faculty.db";
    private static final String table_name="login";
    private static final String col_0="id";
    private static final String col_1="name";
    private static final String col_2="branch";
    private static final String col_3="faculty_id";
    private static final String col_4="passcode";



//    faculty_id real not null  default (random()
    private static final String table= "create table login (id integer primary key not null , name text not null , branch text not null, faculty_id text not null,passcode text not null);";
    SQLiteDatabase db;




    public DataBaseHelper(Context context) {
        super(context, database_name, null, Database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(table);
        this.db=db;

    }

    public void insertContact(Contact c)
    {

        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        String query="select * from login";
        Cursor cursor=db.rawQuery(query,null);
        int count=cursor.getCount();


        values.put(col_0,count);
        values.put(col_1,c.getName());
        values.put(col_2,c.getBranch());
        values.put(col_3,c.getFaculty());
        values.put(col_4,c.getPass());

        db.insert(table_name,null,values);
        db.close();
    }

    public String searchPass(String faculty_id)
    {
        db=this.getReadableDatabase();
        String query=" select faculty_id, passcode from "+table_name;
        Cursor cursor=db.rawQuery(query,null);

        String a,b;
        b="not found";
        if(cursor.moveToFirst())
        {
            do
            {
                a=cursor.getString(0);
                if(a.equals(faculty_id))
                {
                    b=cursor.getString(1);
                    break;
                }

            }
            while(cursor.moveToNext());
        }

        return b;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query= " DROP TABLE IF EXISTS "+table_name;
        db.execSQL(query);
        this.onCreate(db);

    }

}

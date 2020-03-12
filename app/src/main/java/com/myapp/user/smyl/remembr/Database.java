package com.myapp.user.smyl.remembr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    //create a database called demo_database.db
    public Database(Context applicationcontext){
        super(applicationcontext, "demo_database.db", null, 1);
    }


    //Creates a Table
    @Override
    public void onCreate(SQLiteDatabase database) {
        String query = "CREATE TABLE tasks(id INTEGER PRIMARY KEY, title TEXT, app TEXT ,date INTEGER,time VARCHAR)";
        database.execSQL(query);
    }


    @Override
    public void onUpgrade(SQLiteDatabase database, int version_old, int current_version) {
        String query;
        query = "DROP TABLE IF EXISTS tasks";
        database.execSQL(query);
        onCreate(database);
    }
    /**
     * Inserts User into SQLite DB
     * @param date,time
     */
    public void saveUser(String title,String app,long date,String time) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("app", app);
        values.put("date",date);
        values.put("time",time);
        database.insert("tasks", null, values);
        database.close();
    }

    /**
     * Get list of Users from SQLite DB as Array List of Persons
     * @return
     */


    /**
     * Get Count of  Number of  SQLite records
     * @return
     */
    public int countRecords()
    {
        int count = 0;
        String sql = "SELECT  * FROM tasks";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        count = cursor.getCount();
        database.close();
        return count;
    }

    /**
     * Delete A record Based on Its ID Number
     * @param id
     *
     */
    public void deleteRecord(String id)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String updateQuery = "DELETE from tasks where id="+id;
        Log.d("query",updateQuery);
        database.delete("tasks","id="+id,null);
        database.close();
    }
}
package com.myapp.user.smyl.remembr;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nabesh-riska on 5/4/17.
 */

public class dataModel{
    public String app;
    public String title;
    public String time;
    public long date;
    public String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApp() {
        return app;

    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
    public List<dataModel> getObjectList() {

        List<dataModel> dataList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM tasks";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                dataModel data = new dataModel();
                data.id = cursor.getString(0);
                data.title = cursor.getString(1);
                data.app = cursor.getString(2);
                data.date = cursor.getLong(3);
                data.time = cursor.getString(4);
                dataList.add(data);
            } while (cursor.moveToNext());
        }
        database.close();
        return dataList;
    }




//        List<dataModel> dataList = new ArrayList<dataModel>();
//        loop
//        dataModel data=new dataModel
//        data.setApp(aString);
//        data.setTitle(anotherString);
//        data.setDate(long);
//        data.setTime(String);
//        dataList.add(data);
//        after loop}return dataList;


//        int[] images=getImages();
//        for (int i = 0; i <images.length ; i++) {
//            dataModel data=new dataModel();
//            data.setImageID(images[i]);
//            dataList.add(data);
//        }
//        return dataList;
//    }
//
//    private static int[] getImages() {
//        return new int[]{R.drawable.edit,R.drawable.trash};
//    }




}
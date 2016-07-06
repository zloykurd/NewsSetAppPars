package com.example.zloykurd.newsetapppars;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper  {
    String LOG_TAG = "zloykurd_DB";

    private static final String DATABASE_NAME = "MyDBNews";
    private static final int DATABASE_VERSION = 4;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String sQuery = "CREATE TABLE NewsDB(id integer primary key autoincrement, news_title text, news_date text, news_desc text, news_image text, news_category text,news_link text,news_source text);";
        db.execSQL(sQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addNews(News news) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("news_title", news.getNews_title());
        cv.put("news_date", news.getNews_date());
        cv.put("news_desc", news.getNews_desc());
        cv.put("news_image", news.getNews_image());
        cv.put("news_category", news.getNews_category());
        cv.put("news_link", news.getNews_link());
        cv.put("news_source", news.getNews_source());
        db.insert("NewsDB", null, cv);
        Log.d("Add news", news.toString());

        db.close();
    }

    public List<News> getAllNews() {
        List<News> newsList = new ArrayList<News>();

        String selectQuery = "SELECT * FROM NewsDB ORDER BY id DESC";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                News news = new News();
                news.setNews_id(Integer.valueOf(cursor.getString(0)));
                news.setNews_title(cursor.getString(1));
                news.setNews_date(cursor.getString(2));
                news.setNews_desc(cursor.getString(3));
                news.setNews_image(cursor.getString(4));
                news.setNews_category(cursor.getString(5));
                news.setNews_link(cursor.getString(6));
                news.setNews_source(cursor.getString(7));
                newsList.add(news);
            } while (cursor.moveToNext());
        }
        db.close();
        return newsList;
    }
    public List<News> get24News() {
        List<News> newsList = new ArrayList<News>();

        String selectQuery = "SELECT * FROM NewsDB ORDER BY id DESC";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                News news = new News();
                news.setNews_image(cursor.getString(4));
                news.setNews_title(cursor.getString(1));
                news.setNews_date(cursor.getString(2));
                news.setNews_desc(cursor.getString(3));
                news.setNews_image(cursor.getString(4));
                news.setNews_category(cursor.getString(5));
                news.setNews_link(cursor.getString(6));
                news.setNews_source(cursor.getString(7));
                newsList.add(news);
            } while (cursor.moveToNext());
        }
        db.close();
        return newsList;
    }
    public void deleteAllPages() {
        Log.d(LOG_TAG, "Удаление таблицы NewsDB ");
        SQLiteDatabase delet = this.getWritableDatabase();
        delet.execSQL("DROP TABLE NewsDB");
        Log.d(LOG_TAG, "создание таблицы NewsDB ");
        onCreate(delet);
    }
}

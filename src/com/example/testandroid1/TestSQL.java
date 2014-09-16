package com.example.testandroid1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TestSQL extends SQLiteOpenHelper {
	
	public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "mySQL.db";
    private static final String SQL_CREATE_ENTRIES =
    	    "CREATE TABLE  table01(_id INTEGER PRIMARY KEY,account VARCHAR,password VARCHAR)";
    	    ;
    	    
    	    
    public TestSQL(Context context) {
    			super(context, DATABASE_NAME, null, DATABASE_VERSION);
    			// TODO Auto-generated constructor stub
    }
	public TestSQL(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(SQL_CREATE_ENTRIES);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
	}

	public void insercontent(String a,String b)
	{
		 SQLiteDatabase db = this.getWritableDatabase();
		 ContentValues cv=new ContentValues();
		 cv.put("account",a);
		 cv.put("password",b);
		 db.insert("table01", null, cv);
	}
	
	public Cursor querycontent()
	{
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor=db.query("table01",new String[]{"account","password"},null,null,null,null,null,null);
		cursor.moveToLast();
		Log.i("adair", "count:"+cursor.getCount());
		return cursor;
	}
}

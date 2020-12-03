package com.example.wastesortingapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class BarDatabase {

	public static final String TAG = "BarDatabase";

	public static BarDatabase database;

	public static String DATABASE_NAME = "bar1.db";

	public static String TABLE_BAR_INFO = "Bar_INFO";

	public static int DATABASE_VERSION = 1;

    private DatabaseHelper dbHelper;

    private SQLiteDatabase db;


    private Context context;

	private BarDatabase(Context context) {
		this.context = context;
	}


	public static BarDatabase getInstance(Context context) {
		if (database == null) {
			database = new BarDatabase(context);
		}

		return database;
	}

    public boolean open() {
    	println("opening database [" + DATABASE_NAME + "].");

    	dbHelper = new DatabaseHelper(context);
    	db = dbHelper.getWritableDatabase();

    	return true;
    }

    public void close() {
    	println("closing database [" + DATABASE_NAME + "].");
    	db.close();
    	database = null;
    }

    public Cursor rawQuery(String SQL) {
		println("\nexecuteQuery called.\n");

		Cursor c1 = null;
		try {
			c1 = db.rawQuery(SQL, null);
			println("cursor count : " + c1.getCount());
		} catch(Exception ex) {
    		Log.e(TAG, "Exception in executeQuery", ex);
    	}

		return c1;
	}

    public boolean execSQL(String SQL) {
		println("\nexecute called.\n");

		try {
			Log.d(TAG, "SQL : " + SQL);
			db.execSQL(SQL);
	    } catch(Exception ex) {
			Log.e(TAG, "Exception in executeQuery", ex);
			return false;
		}

		return true;
	}




    private class DatabaseHelper extends SQLiteOpenHelper {
        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase _db) {
        	// TABLE_Bar_INFO
        	println("creating table [" + TABLE_BAR_INFO + "].");

        	// drop existing table
        	String DROP_SQL = "drop table if exists " + TABLE_BAR_INFO;
        	try {
        		_db.execSQL(DROP_SQL);
        	} catch(Exception ex) {
        		Log.e(TAG, "Exception in DROP_SQL", ex);
        	}

        	// create table
        	String CREATE_SQL = "create table " + TABLE_BAR_INFO + "("
		        			+ "  _id INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT, "
		        			+ "  NUM TEXT, "
		        			+ "  TITLE TEXT, "
		        			+ "  CONTENTS TEXT, "
		        			+ "  CREATE_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP "
		        			+ ")";
            try {
            	_db.execSQL(CREATE_SQL);
            } catch(Exception ex) {
        		Log.e(TAG, "Exception in CREATE_SQL", ex);
        	}
		}

        public void onOpen(SQLiteDatabase db) {
        	println("opened database [" + DATABASE_NAME + "].");

        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        	println("Upgrading database from version " + oldVersion + " to " + newVersion + ".");

        }

		private void insertRecord(SQLiteDatabase _db, String num, String title, String contents) {
			try {
				_db.execSQL( "insert into " + TABLE_BAR_INFO + "(NUM, TITLE, CONTENTS) values ('" + num + "', '" + title + "', '" + contents + "');" );
			} catch(Exception ex) {
				Log.e(TAG, "Exception in executing insert SQL.", ex);
			}
		}

    }

	public void insertRecord(String num, String title, String contents) {
		try {
			db.execSQL( "insert into " + TABLE_BAR_INFO + "(NUM, TITLE, CONTENTS) values ('" + num + "', '" + title + "', '" + contents + "');" );
		} catch(Exception ex) {
			Log.e(TAG, "Exception in executing insert SQL.", ex);
		}
	}

	public String selectAll(String checkname) {
		ArrayList<BarInfo> result = new ArrayList<BarInfo>();

		String strname="";

//		db.execSQL( "delete from " + TABLE_BAR_INFO + ";" );

		try {
			Cursor cursor = db.rawQuery("select NUM, TITLE, CONTENTS from " + TABLE_BAR_INFO, null);
			for (int i = 0; i < cursor.getCount(); i++) {
				cursor.moveToNext();
				String num = cursor.getString(0);
				String title = cursor.getString(1);
				String contents = cursor.getString(2);

				BarInfo info = new BarInfo(num, title, contents);
				result.add(info);

				if(checkname.equals(num)) {
					strname = contents;
				}

			}

		} catch(Exception ex) {
			Log.e(TAG, "Exception in executing insert SQL.", ex);
		}

		return strname;
	}

    private void println(String msg) {
    	Log.d(TAG, msg);
    }


}

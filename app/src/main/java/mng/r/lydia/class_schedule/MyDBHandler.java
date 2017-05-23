package mng.r.lydia.class_schedule;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MyDBHandler extends SQLiteOpenHelper {
    SQLiteDatabase db;

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "schedule";
    private static final String TABLE_CLASS = "class";
    private static final String R_ID = "_id";
    public static final String UNIT = "unit";
    public static final String DAY = "day";
    public static final String DATE = "date";
    public static final String TIME = "time";
    public static final String VENUE = "venue";


    private static final String TABLE_EXAM = "exam";
    private static final String E_ID = "_id";
    public static final String UNI = "unit";
    public static final String DA = "day";
    public static final String DAT = "date";
    public static final String TIM = "time";
    public static final String VENU = "venue";

    private static final String TABLE_TASK = "task";
    private static final String T_ID = "_id";
    public static final String UNT = "unit";
    public static final String NAME = "name";
    public static final String DATE_GIVEN = "dgiven";
    public static final String DATE_SUB = "dsub";


    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

        String CREATE_NOTIFICATIONS = "CREATE TABLE " + TABLE_CLASS + "( " + R_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + UNIT + " TEXT," + DAY + " TEXT," + DATE + " TEXT," + TIME + " TEXT," + VENUE + " TEXT)";
        db.execSQL(CREATE_NOTIFICATIONS);
        Log.d("CREATE TABLE S", "Create Table Successfully");

        String CREATE_NOTIFICATION = "CREATE TABLE " + TABLE_EXAM + "( " + E_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + UNI + " TEXT," + DA + " TEXT," + DAT + " TEXT," + TIM + " TEXT," + VENU + " TEXT)";
        db.execSQL(CREATE_NOTIFICATION);
        Log.d("CREATE TABLE S", "Create Table Successfully");

        String CREATE_NOTIFICATIONSS = "CREATE TABLE " + TABLE_TASK + "( " + T_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + UNT + " TEXT," + NAME + " TEXT," + DATE_GIVEN + " TEXT," + DATE_SUB + " TEXT)";
        db.execSQL(CREATE_NOTIFICATIONSS);
        Log.d("CREATE TABLE S", "Create Table Successfully");


    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLASS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXAM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK);
        // Create tables again
        onCreate(db);
        Log.d("RECREATE TABLE", "RECreate Table Successfully");
    }


    /**
     * ,
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding entry
    void addEntry(String course, String dayee, String datee, String timee, String venuee) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues nots = new ContentValues();
        nots.put(UNIT, course);
        nots.put(DAY, dayee);
        nots.put(DATE, datee);
        nots.put(TIME, timee);
        nots.put(VENUE, venuee);

        db.insert(TABLE_CLASS, null, nots);
        db.close(); // Closing database connection
        Log.d("INSERT", "Insert Successfully to Show");
    }

    void addEntry2(String course, String dayee, String datee, String timee, String venuee) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues nots = new ContentValues();
        nots.put(UNI, course);
        nots.put(DA, dayee);
        nots.put(DAT, datee);
        nots.put(TIM, timee);
        nots.put(VENU, venuee);

        db.insert(TABLE_EXAM, null, nots);
        db.close(); // Closing database connection
        Log.d("INSERT", "Insert Successfully to Show");
    }

    void addEntry3(String course, String namee, String datgi, String datsub) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues nots = new ContentValues();
        nots.put(UNT, course);
        nots.put(NAME, namee);
        nots.put(DATE_GIVEN, datgi);
        nots.put(DATE_SUB, datsub);


        db.insert(TABLE_TASK, null, nots);
        db.close(); // Closing database connection
        Log.d("INSERT", "Insert Successfully to Show");
    }

    //Geting all data
    public List<String> getCourse() {
        List<String> m_array = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + TABLE_CLASS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor crs = db.rawQuery(selectQuery, null);
        if (crs.moveToFirst()) {
            do {
                String msgs = crs.getString(crs.getColumnIndex("unit"));
                m_array.add(msgs);  //Add the map to the message ArrayList
            } while (crs.moveToNext());
        }
        return m_array;

    }

    public List<String> getCourse1() {
        List<String> m_array = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + TABLE_EXAM;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor crs = db.rawQuery(selectQuery, null);
        if (crs.moveToFirst()) {
            do {
                String msgs = crs.getString(crs.getColumnIndex("unit"));
                m_array.add(msgs);  //Add the map to the message ArrayList
            } while (crs.moveToNext());
        }
        return m_array;

    }

    public List<String> getCourse2() {
        List<String> m_array = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + TABLE_TASK;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor crs = db.rawQuery(selectQuery, null);
        if (crs.moveToFirst()) {
            do {
                String msgs = crs.getString(crs.getColumnIndex("unit"));
                m_array.add(msgs);  //Add the map to the message ArrayList
            } while (crs.moveToNext());
        }
        return m_array;

    }

    public List<String> getDay() {
        List<String> m_array = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + TABLE_CLASS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor crs = db.rawQuery(selectQuery, null);
        if (crs.moveToFirst()) {
            do {
                String msgs = crs.getString(crs.getColumnIndex("day"));
                m_array.add(msgs);  //Add the map to the message ArrayList
            } while (crs.moveToNext());
        }
        return m_array;

    }

    public List<String> getDay1() {
        List<String> m_array = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + TABLE_EXAM;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor crs = db.rawQuery(selectQuery, null);
        if (crs.moveToFirst()) {
            do {
                String msgs = crs.getString(crs.getColumnIndex("day"));
                m_array.add(msgs);  //Add the map to the message ArrayList
            } while (crs.moveToNext());
        }
        return m_array;

    }

    public List<String> getNamee() {
        List<String> m_array = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + TABLE_TASK;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor crs = db.rawQuery(selectQuery, null);
        if (crs.moveToFirst()) {
            do {
                String msgs = crs.getString(crs.getColumnIndex("name"));
                m_array.add(msgs);  //Add the map to the message ArrayList
            } while (crs.moveToNext());
        }
        return m_array;

    }

    public List<String> getDate() {
        List<String> m_array = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + TABLE_CLASS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor crs = db.rawQuery(selectQuery, null);
        if (crs.moveToFirst()) {
            do {
                String msgs = crs.getString(crs.getColumnIndex("date"));
                m_array.add(msgs);  //Add the map to the message ArrayList
            } while (crs.moveToNext());
        }
        return m_array;

    }

    public List<String> getDate1() {
        List<String> m_array = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + TABLE_EXAM;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor crs = db.rawQuery(selectQuery, null);
        if (crs.moveToFirst()) {
            do {
                String msgs = crs.getString(crs.getColumnIndex("date"));
                m_array.add(msgs);  //Add the map to the message ArrayList
            } while (crs.moveToNext());
        }
        return m_array;

    }

    public List<String> getDate2() {
        List<String> m_array = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + TABLE_TASK;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor crs = db.rawQuery(selectQuery, null);
        if (crs.moveToFirst()) {
            do {
                String msgs = crs.getString(crs.getColumnIndex("dgiven"));
                m_array.add(msgs);  //Add the map to the message ArrayList
            } while (crs.moveToNext());
        }
        return m_array;

    }

    public List<String> getDate3() {
        List<String> m_array = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + TABLE_TASK;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor crs = db.rawQuery(selectQuery, null);
        if (crs.moveToFirst()) {
            do {
                String msgs = crs.getString(crs.getColumnIndex("dsub"));
                m_array.add(msgs);  //Add the map to the message ArrayList
            } while (crs.moveToNext());
        }
        return m_array;

    }

    public List<String> getTime() {
        List<String> m_array = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + TABLE_CLASS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor crs = db.rawQuery(selectQuery, null);
        if (crs.moveToFirst()) {
            do {
                String msgs = crs.getString(crs.getColumnIndex("time"));
                m_array.add(msgs);  //Add the map to the message ArrayList
            } while (crs.moveToNext());
        }
        return m_array;

    }

    public List<String> getTime1() {
        List<String> m_array = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + TABLE_EXAM;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor crs = db.rawQuery(selectQuery, null);
        if (crs.moveToFirst()) {
            do {
                String msgs = crs.getString(crs.getColumnIndex("time"));
                m_array.add(msgs);  //Add the map to the message ArrayList
            } while (crs.moveToNext());
        }
        return m_array;

    }

    public List<String> getVenue() {
        List<String> m_array = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + TABLE_CLASS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor crs = db.rawQuery(selectQuery, null);
        if (crs.moveToFirst()) {
            do {
                String msgs = crs.getString(crs.getColumnIndex("venue"));
                m_array.add(msgs);  //Add the map to the message ArrayList
            } while (crs.moveToNext());
        }
        return m_array;

    }

    public List<String> getVenue1() {
        List<String> m_array = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + TABLE_EXAM;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor crs = db.rawQuery(selectQuery, null);
        if (crs.moveToFirst()) {
            do {
                String msgs = crs.getString(crs.getColumnIndex("venue"));
                m_array.add(msgs);  //Add the map to the message ArrayList
            } while (crs.moveToNext());
        }
        return m_array;

    }


    // Updating single contact
    public int getCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CLASS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();
    }

    public int getCount1() {
        String countQuery = "SELECT  * FROM " + TABLE_EXAM;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();
    }

    public int getCount2() {
        String countQuery = "SELECT  * FROM " + TABLE_TASK;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();
    }

    // Deleting single notification
    public void deleteCourse(String code) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CLASS, R_ID + " = ?",
                new String[]{(code)});
        //db.delete(TABLE_CLASS, R_ID + "=" + code, null);
        db.close();
    }

    public void deleteCourse1(String code) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_EXAM, E_ID + " = ?",
                new String[]{(code)});
        //db.delete(TABLE_CLASS, R_ID + "=" + code, null);
        db.close();
    }

    public void deleteCourse2(String code) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TASK, T_ID + " = ?",
                new String[]{(code)});
        //db.delete(TABLE_CLASS, R_ID + "=" + code, null);
        db.close();
    }

    public void deleteAllCourses() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_CLASS);
        db.close();
    }

    public void deleteAllCourses1() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_EXAM);
        db.close();
    }

    public void deleteAllCourses2() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_TASK);
        db.close();
    }


    public int getCourses() {
        String countQuery = "SELECT  * FROM " + TABLE_CLASS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();
    }

    public int getCourses1() {
        String countQuery = "SELECT  * FROM " + TABLE_EXAM;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();
    }

    public Cursor Alldata() {
        db = this.getReadableDatabase();
        return db.query(TABLE_CLASS, new String[]{
               "_id", UNIT, DAY, DATE, TIME, VENUE}, null, null, null, null, null,null
        );
    }

    public Cursor Alldata1() {
        db = this.getReadableDatabase();
        return db.query(TABLE_EXAM, new String[]{
                "_id", UNI, DA, DAT, TIM, VENU}, null, null, null, null, null,null
        );
    }

    public Cursor Alldata2() {
        db = this.getReadableDatabase();
        return db.query(TABLE_TASK, new String[]{
                "_id", UNT, NAME, DATE_GIVEN, DATE_SUB}, null, null, null, null, null,null
        );
    }

    public int getCourses2() {
        String countQuery = "SELECT  * FROM " + TABLE_TASK;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        db.close();
    }
}


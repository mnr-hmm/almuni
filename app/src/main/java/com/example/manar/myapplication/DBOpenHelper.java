package com.example.manar.myapplication;

import android.content.Context;

import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;


import android.content.ContentValues;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.BaseColumns;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DBOpenHelper {

    private final static String DB_NAME = "almuni.db";
    private final static int DB_VERSION = 1;
    private Database dbHelper;
    private SQLiteDatabase database;
    private Context mContext;

    // company table attributes
    static final String TABLE_COM = "company";
    static final String COL_NAME = "name";
    static final String COL_Link = "link";
    static final String COL_PIC = "picture";

    // News attributes
    static final String TABLE_NEWS = "news";
    static final String COL_TITLE = "title";
    static final String COL_BODY = "body";

    // MailingList attributes
    private static final String Mailingtablename = "MailingList";
    public static final String Email = "Email";
    public static final String FirstName = "FirstName";
    public static final String SurName = "SurName";
    public static final String Regist_In = "Regist_In";

    //Request attributes
    private static final String Requesttablename = "Request";
    public static final String RequestID = "RequestID";
    public static final String Type = "Type";               //multiValue
    public static final String Status = "Status";
    public static final String ArabicName = "ArabicName";
    public static final String EnglishName = "EnglishName";
    public static final String Birth_Date = "Birth_Date";
    public static final String Age = "Age";
    public static final String Gender = "Gender";
    public static final String Nat_ID = "Nat_ID";
    public static final String Major = "Major";
    public static final String College = "College";
    public static final String Grad_Date = "Grad_Date";
    public static final String Phone = "Phone";
    public static final String Address = "Address";
    public static final String Nationality = "Nationality";
    public static final String Collection_Method = "Collection_Method";
    public static final String Stu_ID = "Stu_ID";
    public static final String Image = "Image";

    //Almuni activities table attributes
    private static final String tablename = "AlumniActivities";
    public static final String date = "date";
    public static final String time = "time";
    public static final String location = "location";
    public static final String ActivitiesID = "ActivitiesID ";
    public static final String pic = "pic";
    public static final String seniorlist = "seniorlist";
    public static final String Emai = "Email";
    public static final String program = "program";
    public static final String statsistics = "statsistics";
    public static final String magazine = "magazine";
    public static final String watchCermony = "";
    public static final String booklet = "booklet";
    public static final String cermonyplan = "cermonyplan";

    // Create News table
    private static final String create_news_table = "CREATE TABLE news (" + "_id INTEGER PRIMARY KEY, " + "title TEXT, " + "body TEXT, " + "picture BLOB);";

    // Create company table
    private static final String create_company_table = "CREATE TABLE company (" + "_id INTEGER PRIMARY KEY, " + "name TEXT, " + "link TEXT, " + "picture BLOB);";

    // Create MailingList table
    private static final String create_MailingList_table = "create table MailingList (Email text primary key , " +
            "FirstName text not null, " + "SurName text not null, " + "Regist_In text not null);";
    // Create Request table
    private static final String create_Request_table = "create table Request (RequestID integer\n" +
            "primary key autoincrement," + "Type text not null, " + "Status, " + "ArabicName text," + "EnglishName text, " +
            "Birth_Date Date, " + " Age integer, " + " Gender text, " + "Nat_ID text, " + "Major text, " + "College text, " + "Grad_Date Date, " +
            "Email text," + "Phone text, " + "Address text, " + "Nationality text, " + "Collection_Method text, " + "Stu_ID text, " + "Image text);";


    // creat a AlumniActivites table
    private static final String create_Activities_table = "create table AlumniActivities (" +
            "ActivitiesID  integer PRIMARY KEY autoincrement ," +
            "magazine TEXT," +
            "date TEXT, " +
            "time TEXT, " +
            "location TEXT, " +
            "watchCermony TEXT, " +
            "booklet TEXT, " +
            "cermonyplan  TEXT," +
            "pic integer);";


    public DBOpenHelper(Context context)
    {
        this.mContext = context;
        dbHelper = new Database(mContext);
    }

    public class Database extends SQLiteOpenHelper implements BaseColumns {


        public Database(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
            //mContext = context;

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(create_news_table);
            db.execSQL(create_company_table);
            db.execSQL(create_MailingList_table);
            db.execSQL(create_Request_table);
            db.execSQL(create_Activities_table);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w("onUpgrade", "Upgrading database from version: " + oldVersion
                    + " to version: " + newVersion);
            db.execSQL("DROP TABLE IF EXISTS news");
            db.execSQL("DROP TABLE IF EXISTS company");
            database.execSQL("DROP TABLE IF EXISTS MailingList");
            database.execSQL("DROP TABLE IF EXISTS Request");
            database.execSQL("DROP TABLE IF EXISTS AlumniActivities");
            onCreate(database);
        }


    }

    public void addNews(String title, String body, int image) {
        final ContentValues cv = new ContentValues();
        cv.put(COL_TITLE, title);
        cv.put(COL_BODY, body);


        final Bitmap bitmap = BitmapFactory.decodeResource(
                mContext.getResources(), image);
        writeBitmap(cv, COL_PIC, bitmap);
        this.connect();
        database.insert(TABLE_NEWS, null, cv);
    }

    public void writeBitmap(ContentValues cv, String name, Bitmap image) {
        if (image != null) {
            try {
                int size = image.getWidth() * image.getHeight() * 2;
                ByteArrayOutputStream out = new ByteArrayOutputStream(size);

                image.compress(Bitmap.CompressFormat.PNG, 100, out);
                out.flush();
                out.close();

                cv.put(name, out.toByteArray());

            } catch (IOException e) {

            }
        }
    }

    public void addCompany(String name,String link,int image) {
        final ContentValues cv = new ContentValues();
        cv.put(COL_NAME, name);
        cv.put(COL_Link, link);
        final Bitmap bitmap = BitmapFactory.decodeResource(
                mContext.getResources(), image);
        writeBitmap(cv, COL_PIC, bitmap);
        this.connect();
        database.insert(TABLE_COM, null, cv);
    }

    public DBOpenHelper connect() throws SQLException
    {
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public Cursor retrieveLink(String name) throws SQLException
    {
        this.connect();
        Cursor c = database.query(true, TABLE_COM, new String [] {COL_Link}, COL_NAME + "= '" + name+  "'" , null, null, null, null, null);
        if (c != null)
        {
            c.moveToFirst();
        }
        return c;
    }

    public Cursor retrieveAllCompanies()
    {
        this.connect();

        return database.query(TABLE_COM, new String[] { COL_NAME,COL_Link, COL_PIC},
                null,
                null, null, null, null);
    }

    public Cursor retrieveAllNews()
    {
        this.connect();

        return database.query(TABLE_NEWS, new String[] { COL_TITLE,COL_BODY, COL_PIC},
                null,
                null, null, null, null);
    }

    //Declaring the insertMailingList() method to add the MailingList request details into the database
    public long insertMailingList(String email, String fname, String sname, int registIn)
    {
        ContentValues cv = new ContentValues();
        cv.put(email, Email);
        cv.put(fname, FirstName);
        cv.put(sname, SurName);
        cv.put(String.valueOf(registIn), Regist_In);
        this.connect();
        return database.insert(Mailingtablename, null, cv);
    }

    //Declaring the insertRequest() method to add the membership/training request details into the database
    public long insertRequest(String type,String arabicName, String englishname, String age, int gender, String nationID, String major, String college,
                              String date,String email, String phone, String address, String studentID)
    {
        ContentValues cv = new ContentValues();
        cv.put(type, Type);
        cv.put(arabicName, ArabicName);
        cv.put(englishname, EnglishName);
        cv.put(age, Age);
        cv.put(String.valueOf(gender), Gender);
        cv.put(nationID, Nat_ID);
        cv.put(major, Major);
        cv.put(college, College);
        cv.put(date, Grad_Date);
        cv.put(email, Email);
        cv.put(phone, Phone);
        cv.put(address, Address);
        cv.put(studentID, Stu_ID);
        this.connect();
        return database.insert(Requesttablename, null, cv);
    }

    public void inserti(String ColName, String Value) {
        this.connect();
        ContentValues cv = new ContentValues();
        cv.put(ColName, Value);
        database.insert(tablename, null, cv);
    }

    // to insert images to database
    public void addBeer(int image) {
        final ContentValues cv = new ContentValues();


        final Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), image);
        writeBitmap(cv, pic, bitmap);

        database.insert(tablename, null, cv);
    }

    // retrieve all from AlumniActivites table
    public Cursor retrieveAll ()
    {
        this.connect();

        Cursor c = database.query(true, tablename, new String[]{ActivitiesID, date, time,
                location}, null, null, null, null, null, null);
        if (c != null) ;


        return c;
    }

    // retrieve from AlumniActivites table
    public Cursor retrieve ( long id) throws SQLException {
        this.connect();
        Cursor c = database.query(true, tablename, new String[]{ActivitiesID, date, time,
                location, cermonyplan,pic}, ActivitiesID + "=" + id, null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }







}

package com.chrisdev.newsroom.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.chrisdev.newsroom.users.*;

public class DatabaseAdapter extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "SchoolApp";

    private static final int DATABASE_VERSION = 1;

    public static final String STUDENT_TABLE_NAME = "student";
    public static final String STAFF_TABLE_NAME = "staff";
    public static final String COURSE_TABLE_NAME = "course";
    public static final String ADMIN_TABLE_NAME = "admin";


    public DatabaseAdapter( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {


            db.execSQL("create table " + STUDENT_TABLE_NAME + "(" +
                    "studentFirstname TEXT NOT NULL, " +
                    "studentMiddlename TEXT NOT NULL," +
                    "studentLastname TEXT NOT NULL," +
                    "studentUsername TEXT PRIMARY KEY," +
                    "studentPassword TEXT NOT NULL)");

            db.execSQL("create table " + STAFF_TABLE_NAME + "(" +
                    "staffFirstname TEXT NOT NULL, " +
                    "staffMiddlename TEXT NOT NULL," +
                    "staffLastname TEXT NOT NULL," +
                    "staffUsername TEXT PRIMARY KEY," +
                    "staffPassword TEXT NOT NULL)");

            db.execSQL("create table " + COURSE_TABLE_NAME + "(" +
                    "courseCode TEXT NOT NULL UNIQUE , " +
                    "courseName TEXT NOT NULL," +
                    "courseCredit TEXT," +
                    "courseStatus TEXT)");


            db.execSQL("create table " + ADMIN_TABLE_NAME + "(" +
                    "AdminName TEXT UNIQUE, " +
                    "AdminPassword TEXT)");


            db.execSQL(" insert into " + ADMIN_TABLE_NAME + " (AdminName, AdminPassword) values ('system','admin')");


        }
        catch (Exception e){
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try{
            db.execSQL(" drop table if exists " + STUDENT_TABLE_NAME);
            db.execSQL(" drop table if exists " + STAFF_TABLE_NAME);
            db.execSQL(" drop table if exists " + ADMIN_TABLE_NAME);
            onCreate(db);}
        catch (Exception e){
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }

    }

    public void addAStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = " insert into " + STUDENT_TABLE_NAME + " values ('" +
                student.getStudentFirstname() + "', '" +
                student.getStudentMiddlename() + "','" +
                student.getStudentLastname() + "', '" +
                student.getStudentUsername() + "', '" +
                student.getStudentPassword() + "')";
        Log.d("query", query);
        db.execSQL(query);
        db.close();
    }

    public Student validateStudent(String userName, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + STUDENT_TABLE_NAME + " where studentUsername='" + userName + "' and studentPassword='" + password + "'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {

            Student student = new Student();

            student.setStudenFirstname(cursor.getString(0));
            student.setStudentMiddlename(cursor.getString(1));
            student.setStudentLastname(cursor.getString(2));
            student.setStudentUsername(cursor.getString(3));
            student.setStudentPassword(cursor.getString(4));
            return student;
        }
        return null;

    }

    public boolean validateAdmin(String username,String password){
        SQLiteDatabase db= this.getWritableDatabase();
//        String password, userName;



        String query = "SELECT * FROM " + ADMIN_TABLE_NAME + " where AdminName='" + username + "' and AdminPassword='" + password + "'";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {

            cursor.getString(0);
            cursor.getString(1);

            return true;
        }
        return false;
    }

    public void addStaff(Staff staff) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = " insert into " + STAFF_TABLE_NAME + " values ('" +
                staff.getstaffFirstname() + "', '" +
                staff.getstaffMiddlename() + "','" +
                staff.getstaffLastname() + "', '" +
                staff.getstaffUsername() + "', '" +
                staff.getstaffPassword() + "')";
        Log.d("query", query);
        db.execSQL(query);
        db.close();
    }

    public Staff validateStaff(String userName, String passWord) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + STAFF_TABLE_NAME + " where staffUsername='" + userName + "' and staffPassword='" + passWord + "'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {

            Staff staff = new Staff();
            staff.setStaffFirstname(cursor.getString(0));
            staff.setStaffMiddlename(cursor.getString(1));
            staff.setStaffLastname(cursor.getString(2));
            staff.setStaffUsername(cursor.getString(3));
            staff.setStaffPassword(cursor.getString(4));
            return staff;
        }
        return null;

    }
}

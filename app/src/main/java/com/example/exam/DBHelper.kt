package com.example.exam

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper (var context: Context): SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION) {
    companion object{
        private var DB_NAME="datadb"
        private var DB_TABEL="Employee"
        private var DB_VERSION=1
        private var DB_ID="ID"
        private var DB_PERSON="Name"
        private var DB_PASSWORD="Password"



    }

    override fun onCreate(p0: SQLiteDatabase?) {
        var query="CREATE TABLE $DB_TABEL ($DB_ID INTEGER PRIMARY KEY AUTOINCREMENT" +
                ",$DB_PERSON TEXT,$DB_PASSWORD TEXT)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        var query="DROP TABLE $DB_TABEL IF EXISTS"
        p0?.execSQL(query)
        onCreate(p0)

    }
    fun insert(emp:EMPL):Boolean {
        var db=writableDatabase
        var cv= ContentValues()
        cv.put(DB_PERSON,emp.empl_name)
        cv.put(DB_PASSWORD,emp.empl_password)
        var flag= db.insert(DB_TABEL,null,cv)
        if (flag>0)
        {
            return true
        }
        else
        {
            return false
        }
    }
    fun retriveall():ArrayList<EMPL>
    {
        var db =readableDatabase
        var cursor=db.query(DB_TABEL,null,null,null,null,null,null)
        var arr:ArrayList<EMPL> = ArrayList()
        while (cursor.moveToNext())
        {
            var name=cursor.getString(1)
            var password=cursor.getString(2)
            var id=cursor.getInt(0)
            var emp=EMPL(id,name,password)
            arr.add(emp)



        }
        return arr


    }

}
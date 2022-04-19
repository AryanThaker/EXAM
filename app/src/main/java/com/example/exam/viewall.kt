package com.example.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_viewall.*

class viewall : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewall)
        updateRecyclerView()
    }

    private fun updateRecyclerView() {
        var db = DBHelper(this)
        var arr=db.retriveall()
        var adapter= EMPAdapter(this,arr)
        EXAM.adapter=adapter
    }
}

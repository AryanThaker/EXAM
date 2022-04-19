package com.example.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etsubmit.setOnClickListener {
            var name=etname.text.toString()
            var password=etpassword.text.toString()
            var empl=EMPL(name,password)

            var db=DBHelper(this)
            var falg=db.insert(empl)
            if(falg)
            {
                Toast.makeText(this,"record inerted", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this,"record not inserted", Toast.LENGTH_LONG).show()
            }
        }
        etviewall.setOnClickListener {
            var intent= Intent(this,viewall::class.java)
            startActivity(intent)
        }

    }
}
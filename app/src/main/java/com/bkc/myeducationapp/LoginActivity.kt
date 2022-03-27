package com.bkc.myeducationapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class LoginActivity: AppCompatActivity() , View.OnClickListener {
lateinit var userid : TextInputEditText;
lateinit var userPAsword : TextInputEditText;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        userid=findViewById(R.id.userid)
        userPAsword=findViewById(R.id.password)
        this.findViewById<View>(R.id.loginbtn).setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.loginbtn ->
                Toast.makeText(this,"clicked", Toast.LENGTH_LONG).show()

        }
        TODO("Not yet implemented")
    }
}
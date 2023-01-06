package com.example.quizapplication2345

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.reflect.Field

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn:Button=findViewById(R.id.StartButton)
        btn.setOnClickListener{
            val name:EditText=findViewById(R.id.nameField)
            name.text= name.text.trim() as? Editable
            if(name.text.isEmpty())
            {
                Toast.makeText(this,"Enter a name to proceed", Toast.LENGTH_LONG).show()
            }
            else
            {
                val intent = Intent(this, QuestionsOfQuiz::class.java)
                intent.putExtra(Constants.USER_NAME, name.text.toString() )
                startActivity(intent)
                //finish()
            }
        }
    }
}
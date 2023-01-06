package com.example.quizapplication2345

import android.graphics.drawable.Drawable

data class Question(
    val id:Int,
    val ques:String,
    val Image:Int,
    val option1:String, val option2:String, val option3:String, val option4:String,
    val correctAns:Int
)

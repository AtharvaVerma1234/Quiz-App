package com.example.quizapplication2345

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapplication2345.Result

class QuestionsOfQuiz : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedOption:Int=0
    private var mCorrectAnswers:Int=0

    private var progressBar:ProgressBar?=null
    private var tvQuestion:TextView?=null
    private var img:ImageView?=null
    private var option1:TextView?=null
    private var option2:TextView?=null
    private var option3:TextView?=null
    private var option4:TextView?=null
    private var tvProgress:TextView?=null
    private var btnSubmit:Button?=null
    private var mUserName:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions_of_quiz)

        mUserName=intent.getStringExtra(Constants.USER_NAME)
        progressBar=findViewById(R.id.ProgressBar)
        tvQuestion=findViewById(R.id.tvQuestion)
        img=findViewById(R.id.ivFlag)
        option1=findViewById(R.id.tvOption1)
        option2=findViewById(R.id.tvOption2)
        option3=findViewById(R.id.tvOption3)
        option4=findViewById(R.id.tvOption4)
        tvProgress=findViewById(R.id.tvProgress)
        btnSubmit=findViewById(R.id.submit_button)
        mQuestionList = Constants.getQuestions()
        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
        setQuestion()
        //We passed the current class using this keyword and made it of OnClickListener type
        // which it already is and we have also overridden the onclick method of this class below

        //defaultOptionView()
    }
    private fun defaultOptionView()
    {
        val options=ArrayList<TextView>()
        option1?.let{
            options.add(0,it)
        }
        option2?.let{
            options.add(1,it)
        }
        option3?.let{
            options.add(2,it)
        }
        option4?.let{
            options.add(3,it)
        }
        for(option in options)
        {
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }
    private fun selectedOptionView(tv:TextView, selectedOption:Int)
    {
        defaultOptionView()
        mSelectedOption=selectedOption
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    private fun setQuestion() {
        defaultOptionView()
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        img?.setImageResource(question.Image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.let{
            val str="$mCurrentPosition/${progressBar?.max}"
            it.text=str}
        tvQuestion?.text = question.ques
        option1?.text = question.option1
        option2?.text = question.option2
        option3?.text = question.option3
        option4?.text = question.option4
        if(mQuestionList!!.size+1==mCurrentPosition)
        {
            btnSubmit?.text="Finish"
        }
        else
        {
            btnSubmit?.text="Submit"
        }
    }

    override fun onClick(view: View?) {
        when(view?.id)
        {
            R.id.tvOption1-> {
                selectedOptionView(option1!!, 1)
            }
            R.id.tvOption2-> {
                selectedOptionView(option2!!, 2)
            }
            R.id.tvOption3-> {
                selectedOptionView(option3!!, 3)
            }
            R.id.tvOption4-> {
                selectedOptionView(option4!!, 4)
            }
            R.id.submit_button->{
                if(mSelectedOption==0)
                {
                    mCurrentPosition++
                    when{
                        mCurrentPosition<=mQuestionList!!.size->{
                            setQuestion()
                        }
                        else->{
//                            Toast.makeText(this,"You made it to the end", Toast.LENGTH_LONG).show()
                            val intent=Intent(this, Result::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList!!.size)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else
                {
                    val question=mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctAns!= mSelectedOption)
                    {
                        answerView(mSelectedOption,R.drawable.wrong_option_border_bg)
                        mCorrectAnswers--
                    }
                        answerView(question!!.correctAns, R.drawable.correct_option_border_bg)
                    mCorrectAnswers++
                    if(mCurrentPosition== mQuestionList!!.size)
                    {
                        btnSubmit?.text="Finish"
                    }
                    else
                    {
                        btnSubmit?.text="Next"
                    }
                    mSelectedOption=0
                }
            }
        }

    }
    private fun answerView(answer:Int, drawableView:Int)
    {
        when(answer)
        {
            1 -> {
                option1?.background=ContextCompat.getDrawable(this,drawableView)
            }
            2 -> {
                option2?.background=ContextCompat.getDrawable(this,drawableView)
            }
            3 -> {
                option3?.background=ContextCompat.getDrawable(this,drawableView)
            }
            4 -> {
                option4?.background=ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
}
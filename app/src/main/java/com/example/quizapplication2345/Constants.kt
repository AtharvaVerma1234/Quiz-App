package com.example.quizapplication2345

object Constants {

    //The below constants help us in retrieving data from one activity to another
    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_questions"


    fun getQuestions():ArrayList<Question>
    {
        val listOfQues= ArrayList<Question>()
        val que1 =Question(1,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
        "Argentina",
        "Nepal",
        "Norway",
            "Brazil",
            1
        )
        listOfQues.add(que1)
        val que2 =Question(2,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Argentina",
            "Australia",
            "Norway",
            "Brazil",
            2
        )
        listOfQues.add(que2)
        val que3 =Question(3,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Uruguay",
            "Nepal",
            "Netherlands",
            "Belgium",
            4
        )
        listOfQues.add(que3)
        val que4 =Question(4,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Bhutan",
            "Nepal",
            "Norway",
            "Brazil",
            4
        )
        listOfQues.add(que4)
        val que5 =Question(5,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "China",
            "India",
            "USA",
            "Bangladesh",
            2
        )
        listOfQues.add(que5)
        val que6 =Question(6,
            "Which country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Mexico",
            "Spain",
            "Germany",
            "Bangladesh",
            2
        )
        listOfQues.add(que6)
        return listOfQues
    }
}
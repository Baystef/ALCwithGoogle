package com.example.debayo.quizzer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup questionOneAnswers;
    RadioGroup questionTwoAnswers;
    RadioGroup questionThreeAnswers;

    RadioButton questionOneAnswerOne;
    RadioButton questionOneAnswerTwo;
    RadioButton questionOneAnswerThree;
    RadioButton questionOneAnswerFour;

    RadioButton questionTwoAnswerOne;
    RadioButton questionTwoAnswerTwo;
    RadioButton questionTwoAnswerThree;
    RadioButton questionTwoAnswerFour;

    RadioButton questionThreeAnswerOne;
    RadioButton questionThreeAnswerTwo;
    RadioButton questionThreeAnswerThree;
    RadioButton questionThreeAnswerFour;

    CheckBox questionFourAnswerOne;
    CheckBox questionFourAnswerTwo;
    CheckBox questionFourAnswerThree;
    CheckBox questionFourAnswerFour;
    CheckBox questionFourAnswerFive;

    EditText questionFiveAnswer;

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RadioGroups
        questionOneAnswers = findViewById(R.id.question_one_answers);
        questionTwoAnswers = findViewById(R.id.question_two_answers);
        questionThreeAnswers = findViewById(R.id.question_three_answers);

        //No. 1
        questionOneAnswerOne = findViewById(R.id.question_one_answer_one);
        questionOneAnswerTwo = findViewById(R.id.question_one_answer_two);
        questionOneAnswerThree = findViewById(R.id.question_one_answer_three);
        questionOneAnswerFour = findViewById(R.id.question_one_answer_four);

        //No. 2
        questionTwoAnswerOne = findViewById(R.id.question_two_answer_one);
        questionTwoAnswerTwo = findViewById(R.id.question_two_answer_two);
        questionTwoAnswerThree = findViewById(R.id.question_two_answer_three);
        questionTwoAnswerFour = findViewById(R.id.question_two_answer_four);

        //No. 3
        questionThreeAnswerOne = findViewById(R.id.question_three_answer_one);
        questionThreeAnswerTwo = findViewById(R.id.question_three_answer_two);
        questionThreeAnswerThree = findViewById(R.id.question_three_answer_three);
        questionThreeAnswerFour = findViewById(R.id.question_three_answer_four);

        //No. 4
        questionFourAnswerOne = findViewById(R.id.question_four_answer_one);
        questionFourAnswerTwo = findViewById(R.id.question_four_answer_two);
        questionFourAnswerThree = findViewById(R.id.question_four_answer_three);
        questionFourAnswerFour = findViewById(R.id.question_four_answer_four);
        questionFourAnswerFive = findViewById(R.id.question_four_answer_five);

        //No. 5
        questionFiveAnswer = findViewById(R.id.question_five_answer);

    }

    /**
     * This method inflates the menu i.e. it adds action bar if it is present
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * This method triggers the functions of the App bar action keys
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.reset:
                //Reset answer fields

                //No. 1
                questionOneAnswers.clearCheck();

                //No. 2
                questionTwoAnswers.clearCheck();

                //No. 3
                questionThreeAnswers.clearCheck();

                //No. 4
                questionFourAnswerOne.setChecked(false);
                questionFourAnswerTwo.setChecked(false);
                questionFourAnswerThree.setChecked(false);
                questionFourAnswerFour.setChecked(false);
                questionFourAnswerFive.setChecked(false);

                //No. 5
                questionFiveAnswer.setText("");

                //Sets score back to zero
                score = 0;

                return (true);
            //This function closes the app when exit is clicked
            case R.id.exit:
                finish();
                return (true);
        }
        return (super.onOptionsItemSelected(item));
    }

    /**
     * This method is called when the submit button is clicked.
     * Each function saves the correct answer selected in its variable type
     */
    public void submit(View v) {
        //if option 2 of question 2 is checked, save the result in boolean isGoogle
        boolean isGoogle = questionOneAnswerTwo.isChecked();

        boolean isYear = questionTwoAnswerFour.isChecked();

        boolean isAndroid = questionThreeAnswerOne.isChecked();

        boolean isFounder = questionFourAnswerTwo.isChecked();

        boolean isFounder2 = questionFourAnswerFive.isChecked();

        String Name = questionFiveAnswer.getText().toString();

        calculateScore(isGoogle, isYear, isAndroid, isFounder, isFounder2, Name);

        //This string contains the result feedback which is passed into the toast
        String message = "You got " + score + " points out of 10";
        //pops up total score the user got
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        score = 0;
    }

    /**
     * This method calculates the number of points got per question answered
     *
     * @param isGoogle   checks whether the user selected the correct answer
     * @param isYear     checks whether the user selected the correct answer
     * @param isAndroid  checks whether the user selected the correct answer
     * @param isFounder  checks whether the user selected the correct answer
     * @param isFounder2 checks whether the user selected the correct answer
     * @param Name       checks if the answer user entered is equal to expected answer
     */

    private void calculateScore(boolean isGoogle, boolean isYear, boolean isAndroid, boolean isFounder, boolean isFounder2, String Name) {
        if (isGoogle) score += 2;

        if (isYear) score += 2;

        if (isAndroid) score += 2;

        if (isFounder && isFounder2) score += 2;

        if (Name.equalsIgnoreCase("BACKRUB")) score += 2;

    }
}

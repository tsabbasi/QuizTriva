package com.example.jay.quiztriv;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import java.io.IOException;
import java.net.URISyntaxException;

public class QuizTrivia extends AppCompatActivity {

    // Global Variables
    public static SQLiteDatabase db;

    private QuestionLibrary mQuestionLibrary= new QuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button quitButton;

    public String mQuestion;
    public String mAnswer;
    public String userChoice;
    private int mScore=0;
    private int mQuestionNumber = 0;
    private String FILENAME = "https://gist.githubusercontent.com/JayDavi/1d7b3be563ed8da85fbd6bbd6d34054a/raw/f2d086ff343d8f313d72107af5787ea9bc967e30/gistfile1.txt";

    public QuizTrivia() throws URISyntaxException, IOException {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_trivia);
        mQuestionLibrary.execute(FILENAME);

        int j = 0;
        for(int i = 0; i<= 700000000;i++){
            j++;
        }
//        System.out.println("made it 1");
        db = openOrCreateDatabase("MyDatabase", MODE_PRIVATE, null);

        db.execSQL("drop table if exists MyTable;");

        db.execSQL("Create table if not exists MyTable (Question text, UserChoice text, CorrectAnswer text);");
//        db.execSQL("Insert into MyTable values (" + mQuestion + "," + mButtonChoice2.getText().toString() + "," + mAnswer + "); ");

//        System.out.println("made it 2");

//        mQuestionLibrary = new QuestionLibrary();

        mScoreView = findViewById(R.id.score);
        mQuestionView = findViewById(R.id.question);
        mButtonChoice1 = findViewById(R.id.choice1);
        mButtonChoice2 = findViewById(R.id.choice2);
        mButtonChoice3 = findViewById(R.id.choice3);
        quitButton = findViewById(R.id.quit);

        updateQuestion();

        //Start of Button Listener for Button 1

        mButtonChoice1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                userChoice = mButtonChoice1.getText().toString();

                if(userChoice.equals(mAnswer)){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    db.execSQL("Insert into MyTable values (" + "'" + mQuestion + "'" + ',' + "'" + userChoice + "'" + ',' + "'" + mAnswer + "'" + "); ");
                    updateQuestion();
                    Toast.makeText(QuizTrivia.this, "CORRECT", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(QuizTrivia.this, "YOU'RE WRONG BOI!!!!!!!", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }

            }
        });
        //End of Button Listener for Button 1

        //Start of Button Listener for Button 2

        mButtonChoice2.setOnClickListener(new View.OnClickListener(){


            public void onClick(View view){
                userChoice = mButtonChoice2.getText().toString();

                db.execSQL("Insert into MyTable values (" + "'" + mQuestion + "'" + ',' + "'" + userChoice + "'" + ',' + "'" + mAnswer + "'" + "); ");

//                System.out.println(mButtonChoice2.getText());
                if(userChoice.equals(mAnswer)){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(QuizTrivia.this, "CORRECT", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(QuizTrivia.this, "YOU'RE WRONG BOI!!!!!!!", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
        //End of Button Listener for Button 2

        //Start of Button Listener for Button 3

        mButtonChoice3.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                userChoice = mButtonChoice3.getText().toString();

                db.execSQL("Insert into MyTable values (" + "'" + mQuestion + "'" + ',' + "'" + userChoice + "'" + ',' + "'" + mAnswer + "'" + "); ");

                if(userChoice.equals(mAnswer)){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(QuizTrivia.this, "CORRECT", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(QuizTrivia.this, "YOU'RE WRONG BOI!!!!!!!", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
        //End of Button Listener for Button 3

        quitButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent i = new Intent(QuizTrivia.this, EndPage.class);
                startActivity(i);
                finish();
            }
        });

    }




    private void updateQuestion() {
        if (mQuestionNumber < mQuestionLibrary.getMQLength()) {

            mQuestion = mQuestionLibrary.getQuestion(mQuestionNumber);

            mQuestionView.setText(mQuestion);
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));

            mAnswer = mQuestionLibrary.getCorrectAnswers(mQuestionNumber);

            System.out.println(mQuestionNumber);
            mQuestionNumber++;

            System.out.println(mQuestionLibrary.getMQLength());

        }

        else{
            Intent i = new Intent(QuizTrivia.this, EndPage.class);
            startActivity(i);
            finish();
        }
    }

        private void updateScore(int point){
            mScoreView.setText("" + mScore);
        }

    }


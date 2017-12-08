package com.example.jay.quiztriv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import java.util.HashMap;
import java.util.*;
import java.io.BufferedReader;

public class QuestionLibrary {

    private String FILENAME = "C:\\Users\\Jay";
    private String QUESTION = "Question";
    private String ANSWER = "Answer";
    private String QA = "QA";
    private String JSONFILE = convJSON(FILENAME);
    private ArrayList<HashMap<String, String>> JSONARRAY = getJSON(JSONFILE);

    private String mQuestions [] = {
            "What is a Thread?",
            "What is deadlock?",
            "What are the necessary conditions for deadlock?",
            "What is Virtual Memory?",
            "What is Thrashing?",
    };

    private String mChoices [] [] = {
            {"A thread is a single sequence stream within in a process.",
                    "No thread",
                    ""},
            {"We didn't cover this", "Virtual Memory", "Deadlock is a situation when two or more processes wait for each other to finish and none of them ever finish"},
            {"Why is this a question", "Operating Systems", "Mutual Exclusion, Hold and Wait, No Preemption, Circular Wait"},
            {"The act of being unknown", "Virtual memory creates an illusion that each user has one or more contiguous address spaces, each beginning at address zero", "Not sure"},
            {"Thrashing is a situation when the performance of a computer increase.", "Thrashing is a situation when the performance of a computer degrades or collapses. ", "What are the key words"},
    };

    private String mCorrectAnswers [] = {"A thread is a single sequence stream within in a process.",
            "Deadlock is a situation when two or more processes wait for each other to finish and none of them ever finish",
            "Mutual Exclusion, Hold and Wait, No Preemption, Circular Wait",
            "Virtual memory creates an illusion that each user has one or more contiguous address spaces, each beginning at address zero",
            "Thrashing is a situation when the performance of a computer degrades or collapses. "};

    private String convJSON(String filename){ //Change File to JSON String
//        File sdcard = Environment.getExternalStorageDirectory();
        StringBuilder toJSON = new StringBuilder();
        File file = new File(filename);
        System.out.println("Made it here");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            System.out.println("Made it here too");
            while ((line = br.readLine()) != null) {
                toJSON.append(line);
            }
            br.close();
            return toJSON.toString();
        } catch (IOException e) {

            e.printStackTrace();
            return null;

        }

    }

    private ArrayList<HashMap<String, String>> getJSON(String json) { //Get Array From JSON
        try {

            ArrayList<HashMap<String, String>> questionList = new ArrayList<HashMap<String, String>>();
            JSONObject jsonObj = new JSONObject(json);


            JSONArray qas = jsonObj.getJSONArray(QA);


            for (int i = 0; i < qas.length(); i++) {
                JSONObject c = qas.getJSONObject(i);

                String question = c.getString(QUESTION);
                String answer = c.getString(ANSWER);


                HashMap<String, String> qsas = new HashMap<String, String>();


                qsas.put(QUESTION, question);
                qsas.put(ANSWER, answer);



                questionList.add(qsas);
            }
            return questionList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    public String getQuestion(int a){

        String questions = JSONARRAY.get(a).get(QUESTION);
        return questions;
    }

    public String getChoice1(int a){
        String choice0 = mChoices[a] [0];
        return choice0;
    }

    public String getChoice2(int a){
        String choice1 = mChoices[a] [1];
        return choice1;
    }

    public String getChoice3(int a){
        String choice2 = mChoices[a] [2];
        return choice2;
    }

    public String getCorrectAnswers(int a){
        String answer = JSONARRAY.get(a).get(ANSWER);
        return answer;
    }

    public int getMQLength(){
        return JSONARRAY.size();
    }


}

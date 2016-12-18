package com.tom.geoquiz;

/**
 * Created by tom on 16/10/16.
 */

public class Question {

    private int mIdQuestion;
    private boolean mAnswer;

    public Question(int idQuestion, boolean answer) {
        mIdQuestion = idQuestion;
        mAnswer = answer;
    }

    public int getIdQuestion() {
        return mIdQuestion;
    }

    public boolean getAnswer() {
        return mAnswer;
    }

    public void setIdQuestion(int idQuestion) {
        mIdQuestion = idQuestion;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}

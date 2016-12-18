package com.tom.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "inedex";

    private TextView mTextView;
    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPreviewButton;
    private Button mCheatButton;

    private Question[] mQuestions = new Question[] {
            new Question(R.string.question_animal, true),
            new Question(R.string.question_city, true),
            new Question(R.string.question_country, false),
            new Question(R.string.question_lake, false),
            new Question(R.string.question_plant, true),
            new Question(R.string.question_moutain, false)};

    private static int mIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "-----onCreate-----");
        setContentView(R.layout.activity_quiz);

        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt(KEY_INDEX);
        }

        mTextView = (TextView)findViewById(R.id.question_text);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIndex = (mIndex + 1) % mQuestions.length;
                setQuestionText();
            }
        });

        mTrueButton = (Button)findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });

        mFalseButton = (Button)findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIndex = (mIndex + 1) % mQuestions.length;
                setQuestionText();
            }
        });

        mPreviewButton = (ImageButton) findViewById(R.id.preview_button);
        mPreviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIndex = mIndex - 1 < 0 ? mIndex - 1 + mQuestions.length : mIndex - 1;
                setQuestionText();
            }
        });

        mCheatButton = (Button)findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(QuizActivity.this, CheatActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("index", mIndex);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        setQuestionText();
    }

    private void checkAnswer(boolean userPressTrue) {
        boolean answerIsTrue = mQuestions[mIndex].getAnswer();

        int messageResId = 0;

        if (answerIsTrue == userPressTrue) {
            messageResId = R.string.true_toast;
        } else {
            messageResId = R.string.false_toast;
        }

        Toast.makeText(QuizActivity.this, messageResId, Toast.LENGTH_SHORT).show();
    }

    private void setQuestionText() {
        int question = mQuestions[mIndex].getIdQuestion();
        mTextView.setText(question);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "-----onStart-----");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "-----onResume-----");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "-----onRestart-----");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "-----onPause-----");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "-----onStop-----");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "-----onDestroy-----");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_INDEX, mIndex);
    }
}
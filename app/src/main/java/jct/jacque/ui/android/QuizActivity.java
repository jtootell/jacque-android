package jct.jacque.ui.android;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class QuizActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        ConstraintLayout rootQuizContainer = findViewById(R.id.rootQuizContainer);

        LinearLayout answerArea = (LinearLayout) rootQuizContainer.getViewById(R.id.answerArea);

        for(int i=0;i<3;i++){

            TextView tvQ = new TextView(this);
            tvQ.setText("This is question " + String.valueOf(i));
            tvQ.setId(View.generateViewId());

            answerArea.addView(tvQ);

        }


    }

}

package jct.jacque.ui.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import jct.jacque.core.database.DatabaseManager;

public class MainActivity extends AppCompatActivity {

    private static final int READ_REQUEST_CODE = 42;
    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String databasePath = "";

        Button btnOpenConfig = (Button)findViewById(R.id.btnOpenConfig);

        btnOpenConfig.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

//                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
//                intent.addCategory(Intent.CATEGORY_OPENABLE);
//                intent.setType("application/octet-stream");
//                startActivityForResult(intent, READ_REQUEST_CODE);

                //System.out.println("clicked");

            Intent intent = new Intent()
                    .setType("*/*")
                    .setAction(Intent.ACTION_GET_CONTENT);

            startActivityForResult(Intent.createChooser(intent, "Select a file"), 123);

            }

        });

        databaseManager = new DatabaseManager(databasePath);

        Button btnOpenQuizzingActivity = (Button)findViewById(R.id.btnOpenQuizzingActivity);

        btnOpenQuizzingActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent quizIntent = new Intent(MainActivity.this,
                        QuizActivity.class);

                startActivity(quizIntent);

            }
        });


    } // end onCreate()

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==123 && resultCode==RESULT_OK) {
            Uri selectedfile = data.getData(); //The uri with the location of the file
        }
    }
}

package com.example.aspire.namegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.String.join;

public class MainGameActivity extends AppCompatActivity {
    public static String[] GetStringArray(ArrayList<String> arr)
    {

        // declaration and initialise String Array
        String str[] = new String[arr.size()];

        // ArrayList to Array Conversion
        for (int j = 0; j < arr.size(); j++) {

            // Assign each value to String array
            str[j] = arr.get(j);
        }

        return str;
    }


    LinearLayout linearLayout;
    private Button button;
    private String mode,difficulty,letter;
    String[] str;
    DatabaseHelper db;
    private String DB_NAME = "NameGame.db";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        Intent intent = getIntent();
        ArrayList<String> topics = intent.getStringArrayListExtra("topics");
        str = GetStringArray(topics);

        String listString = "";

        for (String s : topics)
        {
            listString += s + " ";
        }

        mode = intent.getStringExtra("mode");
        difficulty = intent.getStringExtra("difficulty");
        letter = intent.getStringExtra("letter");

        db = new DatabaseHelper(getApplicationContext());
        db.addGame(mode,difficulty,letter,listString);




        linearLayout = findViewById(R.id.linear_layout);

        for(int i =0;i<str.length;i++)
        {
            TextView textView = new TextView(this);
            textView.setText(str[i]);
            textView.setPadding(50,100,100,0);
            EditText editText = new EditText(this);
            editText.setPadding(100,0,100,100);
            editText.setTag(str[i]);
            linearLayout.addView(textView);
            linearLayout.addView(editText);

        }
        button = new Button(this);
        button.setText("SUBMIT");
        linearLayout.addView(button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomeActivity();
            }
        });

    }

    public void openHomeActivity()
    {

        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
}

package com.example.aspire.namegame;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class NewGameActivity extends AppCompatActivity {

    private Spinner modeSpinner,letterSpinner,difficultySpinner;
    private String mode,difficulty,letter;
    private ArrayList<StateVO> listVOs;
    private MyAdapter myAdapter;
    Button addMemberButton,startGameButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);


        startGameButton = (Button)findViewById(R.id.StartGameButton);
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainGameActivity();
            }
        });

        addMemberButton = (Button)findViewById(R.id.AddMemberButton);
        //viewAll();

        addMemberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddMemberActivity();
            }
        });

        modeSpinner = (Spinner) findViewById(R.id.ModeSpinner);

        ArrayAdapter<String> modeAdapter = new ArrayAdapter<String>(NewGameActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.mode));
        modeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modeSpinner.setAdapter(modeAdapter);

        difficultySpinner = (Spinner) findViewById(R.id.DifficultySpinner);

        ArrayAdapter<String> difficultyAdapter = new ArrayAdapter<String>(NewGameActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.difficulty));
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(difficultyAdapter);

        letterSpinner = (Spinner) findViewById(R.id.LetterSpinner);

        ArrayAdapter<String> letterAdapter = new ArrayAdapter<String>(NewGameActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.letter));
        letterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        letterSpinner.setAdapter(letterAdapter);

        modeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        mode = adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(adapterView.getContext(),"Selected: "+item,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            };
        });

        difficultySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                difficulty = adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(adapterView.getContext(),"Selected: "+item,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            };
        });

        letterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                letter = adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(adapterView.getContext(),"Selected: "+item,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            };
        });

        final String[] select_qualification = {
                "Select Topics","Animal","Bird", "Book", "Country", "Currency","Flower", "Fruit", "Movie"};
        Spinner topicSspinner = (Spinner) findViewById(R.id.TopicSpinner);

        listVOs = new ArrayList<>();

        for (int i = 0; i < select_qualification.length; i++) {
            StateVO stateVO = new StateVO();
            stateVO.setTitle(select_qualification[i]);
            stateVO.setSelected(false);
            listVOs.add(stateVO);
        }
        myAdapter = new MyAdapter(NewGameActivity.this, 0,
                listVOs);
        topicSspinner.setAdapter(myAdapter);
    };
    public void openMainGameActivity()
    {
        ArrayList<StateVO> listState = myAdapter.listState;
        ArrayList<String> topics = new ArrayList<>();
        //topics.add("hello");
        for(int i =0 ;i<listState.size();i++)
        {
            if(listState.get(i).isSelected())
            {
                topics.add(listState.get(i).getTitle());
            }
        }
        if(topics.size()==0)
        {
            Toast toast = Toast.makeText(getApplicationContext(),"No Topic Selected",Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        Intent intent = new Intent(this,MainGameActivity.class);
        intent.putExtra("topics",topics);
        intent.putExtra("mode",mode);
        intent.putExtra("difficulty",difficulty);
        intent.putExtra("letter",letter);

        startActivity(intent);


    }


        public void openAddMemberActivity()
        {
            Intent intent = new Intent(this,AddMemberActivity.class);
            startActivity(intent);
        }

    public void showMessage(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }



}

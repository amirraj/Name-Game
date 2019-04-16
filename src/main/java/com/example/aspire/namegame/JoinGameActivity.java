package com.example.aspire.namegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class JoinGameActivity extends AppCompatActivity {

    private ArrayList<StateVO> listVOs;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_game);

        /*Button nextButton = (Button)findViewById(R.id.next);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNextActivity();
            }
        });
        final String[] select_qualification = {
                "Select Qualification", "10th / Below", "12th", "Diploma", "UG",
                "PG", "Phd"};
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        listVOs = new ArrayList<>();

        for (int i = 0; i < select_qualification.length; i++) {
            StateVO stateVO = new StateVO();
            stateVO.setTitle(select_qualification[i]);
            stateVO.setSelected(false);
            listVOs.add(stateVO);
        }
        myAdapter = new MyAdapter(JoinGameActivity.this, 0,
                listVOs);
        spinner.setAdapter(myAdapter);

*/
    }
    public void openNextActivity()
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
        /*Intent intent = new Intent(this,MainGameActivity.class);
        intent.putExtra("topics",topics);
        startActivity(intent);*/
    }
}

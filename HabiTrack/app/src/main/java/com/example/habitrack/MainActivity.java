package com.example.habitrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_HTYPE_CREATE = 1;
    private Button createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createButton = (Button) findViewById(R.id.createHabitButtonID);

        createButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                Intent newHabitTypeIntent = new Intent(v.getContext(), NewHabitTypeActivity.class);
                //startActivityForResult(newHabitTypeIntent, REQ_HTYPE_CREATE);
                startActivity(newHabitTypeIntent);

            }
        }
        );

    }
}

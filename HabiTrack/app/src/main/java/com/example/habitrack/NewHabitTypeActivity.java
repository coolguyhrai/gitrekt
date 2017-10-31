package com.example.habitrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewHabitTypeActivity extends AppCompatActivity {

    private String title;
    private String reason;

    private Button submitButton;
    private EditText titleBox;
    private EditText reasonBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_habit_type);

        submitButton = (Button) findViewById(R.id.submitButton);
        titleBox = (EditText) findViewById(R.id.titleBox);
        reasonBox = (EditText) findViewById(R.id.reasonBox);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createHabitType();
            }
        }
        );

    }

    private void createHabitType(){

        title = titleBox.getText().toString();
        reason = reasonBox.getText().toString();

        finish();
    }
}

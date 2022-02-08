package com.example.juhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

public class BachelorProgramActivity extends AppCompatActivity {

private Button btnNext;
private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bachelor_program);

        btnNext = (Button) findViewById(R.id.button_enter);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);

        btnNext.setOnClickListener(v -> {
            if(radioGroup.getCheckedRadioButtonId()==R.id.rd1){
                Intent intent = new Intent(BachelorProgramActivity.this,FirstYearActivity.class);
                startActivity(intent);
            }else if(radioGroup.getCheckedRadioButtonId()==R.id.rd2){
                Intent intent = new Intent(BachelorProgramActivity.this,FirstYearActivity.class);
                startActivity(intent);
            }else if(radioGroup.getCheckedRadioButtonId()==R.id.rd3){
                Intent intent = new Intent(BachelorProgramActivity.this,FirstYearActivity.class);
                startActivity(intent);
            }else if(radioGroup.getCheckedRadioButtonId()==R.id.rd4){
                Intent intent = new Intent(BachelorProgramActivity.this,FirstYearActivity.class);
                startActivity(intent);
            }
        });
    }
}
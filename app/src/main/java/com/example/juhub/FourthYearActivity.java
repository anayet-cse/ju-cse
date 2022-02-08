package com.example.juhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FourthYearActivity extends AppCompatActivity {

    private Button btn_first, btn_second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_year);


        btn_first = (Button) findViewById(R.id.button_fist_semester);
        btn_second = (Button) findViewById(R.id.button_second_semester);

        btn_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FourthYearActivity.this, FourthYearFirstSemesterActivity.class);
                startActivity(intent);
            }
        });
        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FourthYearActivity.this, FourthYearSecondSemesterActivity.class);
                startActivity(intent);
            }
        });
    }
}
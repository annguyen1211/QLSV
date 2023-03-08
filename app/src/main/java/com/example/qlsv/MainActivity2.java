package com.example.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView name_tv, date_tv, school_tv, gender_tv, hobby_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name_tv = findViewById(R.id.name_tv);
        date_tv = findViewById(R.id.date_tv);
        school_tv = findViewById(R.id.school_tv);
        gender_tv = findViewById(R.id.gender_tv);
        hobby_tv = findViewById(R.id.hobby_tv);


        Intent data = MainActivity2.this.getIntent();

        Bundle bundle = data.getBundleExtra(MainActivity.KEY_BUNDLE);
        name_tv.setText(bundle.getString(MainActivity.KEY_NAME));
        date_tv.setText(bundle.getString(MainActivity.KEY_DATE));
        school_tv.setText(bundle.getString(MainActivity.KEY_SCHOOL));
        gender_tv.setText(bundle.getString(MainActivity.KEY_GENDER));
        hobby_tv.setText(bundle.getString(MainActivity.KEY_HOBBY));
    }
}
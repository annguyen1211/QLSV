package com.example.qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_NAME = "NAME";
    public static final String KEY_BUNDLE = "BUNDLE";
    public static final String KEY_DATE = "DATE";
    public static final String KEY_SCHOOL = "SCHOOL";
    public static final String KEY_GENDER = "GENDER";
    public static final String KEY_HOBBY = "HOBBY";

    Button output_btn, reset_btn;
    EditText name_edt, date_edt, school_edt;
    CheckBox hobby1_cb, hobby2_cb, hobby3_cb;
    RadioButton male_rb, female_rb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output_btn = findViewById(R.id.output_btn);
        reset_btn = findViewById(R.id.reset_btn);
        name_edt = findViewById(R.id.name_edt);
        date_edt = findViewById(R.id.date_edt);
        school_edt = findViewById(R.id.school_edt);
        hobby1_cb = findViewById(R.id.hobby1_cb);
        hobby2_cb = findViewById(R.id.hobby2_cb);
        hobby3_cb = findViewById(R.id.hobby3_cb);
        male_rb = findViewById(R.id.male_rb);
        female_rb = findViewById(R.id.female_rb);


        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_edt.getText().clear();
                date_edt.getText().clear();
                school_edt.getText().clear();
                if (hobby1_cb.isChecked()) {
                    hobby1_cb.setChecked(false);
                }
                if (hobby2_cb.isChecked()) {
                    hobby2_cb.setChecked(false);
                }
                if (hobby3_cb.isChecked()) {
                    hobby3_cb.setChecked(false);
                }
                if (male_rb.isChecked()) {
                    male_rb.setChecked(false);
                }
                if (female_rb.isChecked()) {
                    female_rb.setChecked(false);
                }
            }
        });


        output_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MainActivity2.class);


                Bundle bundle = new Bundle();
                bundle.putString(KEY_NAME, name_edt.getText().toString());
                bundle.putString(KEY_DATE, date_edt.getText().toString());
                bundle.putString(KEY_SCHOOL, school_edt.getText().toString());

                if(male_rb.isChecked()){
                    bundle.putString(KEY_GENDER, male_rb.getText().toString());
                }
                if (female_rb.isChecked()) {
                    bundle.putString(KEY_GENDER, female_rb.getText().toString());
                }

                String hobby = "";
                if (hobby1_cb.isChecked()) {
                    hobby += hobby1_cb.getText()+ ", ";

                }
                if (hobby2_cb.isChecked()) {
                    hobby += hobby2_cb.getText()+ ", ";

                }
                if (hobby3_cb.isChecked()) {
                    hobby += hobby3_cb.getText()+ ", ";
                }
                bundle.putString(KEY_HOBBY, hobby);


                intent.putExtra(KEY_BUNDLE, bundle);
                startActivity(intent);
            }
        });


    }
}
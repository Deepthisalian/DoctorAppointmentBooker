package com.example.new_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class appoint extends AppCompatActivity {
    EditText t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoint);
        t=findViewById(R.id.edittextm);

        Intent it=getIntent();
        String name=it.getStringExtra("Name");
        String date=it.getStringExtra("date");
        String time=it.getStringExtra("time");
        String ap="";
        ap= ap+" ->"+name+" ->"+date+" ->"+time+"\n";
        t.setText(ap);
    }
}
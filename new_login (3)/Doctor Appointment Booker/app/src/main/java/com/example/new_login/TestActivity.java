package com.example.new_login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {
    CardView c1,c2,c3,c4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        //getSupportActionBar().hide();
        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        c3=findViewById(R.id.c3);
        c4=findViewById(R.id.c4);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ie=new Intent(TestActivity.this,second.class);
                startActivity(ie);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii=new Intent(TestActivity.this,third.class);
                startActivity(ii);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(TestActivity.this,fourth.class);
                startActivity(in);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ik=new Intent(TestActivity.this,fifth.class);
                startActivity(ik);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.i1) {
            Intent i = new Intent(TestActivity.this, ProfileActivity.class);
            startActivity(i);
        }
        else if( id==R.id.i2) {
            Toast.makeText(TestActivity.this, "You have no apppointments for now", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(TestActivity.this, "App runs", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
package com.example.new_login;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class fourth extends AppCompatActivity {
    Button c1,b1,c2,b2,c3,b3,c4,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        c1=findViewById(R.id.cb1);
        b1=findViewById(R.id.bc1);
        c2=findViewById(R.id.cb2);
        c3=findViewById(R.id.cb3);
        b2=findViewById(R.id.bc2);
        b3=findViewById(R.id.bc3);
        c4=findViewById(R.id.cb4);
        b4=findViewById(R.id.bc4);

        c1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:5864267969"));
                if(checkSelfPermission(Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1);
                }
                else{
                    startActivity(callIntent);
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(fourth.this,booking1.class);
                startActivity(i1);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:7598643151"));
                if(checkSelfPermission(Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1);
                }
                else{
                    startActivity(callIntent);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(fourth.this,booking2.class);
                startActivity(i2);

            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:9545276441"));
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
                } else {
                    startActivity(callIntent);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3=new Intent(fourth.this,booking3.class);
                startActivity(i3);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:9615345789"));
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
                } else {
                    startActivity(callIntent);
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i4=new Intent(fourth.this,booking4.class);
                startActivity(i4);

            }
        });

    }
}
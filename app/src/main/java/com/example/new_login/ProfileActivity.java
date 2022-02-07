package com.example.new_login;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    Button b1;
    EditText e1,e2,e3,e4,e5,f;
    TextView t1,t2,t3,t4,t5;
    SharedPreferences sp;
    ImageButton ib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        e4=findViewById(R.id.e4);
        e5=findViewById(R.id.e5);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        f=findViewById(R.id.fullname);
        ib=findViewById(R.id.imageButton);
        b1=findViewById(R.id.set);

        Intent it=getIntent();
        sp=getSharedPreferences("Details",MODE_PRIVATE);
        e1.setText(sp.getString("FirstName",""));
        e2.setText(sp.getString("LastName",""));
        e3.setText(sp.getString("Phone",""));
        e4.setText(sp.getString("DOB",""));
        e5.setText(sp.getString("Email",""));

        String s1=e1.getText().toString();
        String s2=e2.getText().toString();
        f.setText(""+s1+" "+""+s2);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,1);
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "Profile is set successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK){
            Uri u=data.getData();
            ib.setImageURI(u);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor e=sp.edit();
        e.putString("FirstName",e1.getText().toString());
        e.putString("LastName",e2.getText().toString());
        e.putString("Phone",e3.getText().toString());
        e.putString("DOB",e4.getText().toString());
        e.putString("Email",e5.getText().toString());
        e.commit(); //commit the changes i.e. load the content of the file in the app
    }
}
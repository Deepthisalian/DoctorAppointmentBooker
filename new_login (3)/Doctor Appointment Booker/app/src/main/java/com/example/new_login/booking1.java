package com.example.new_login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class booking1 extends AppCompatActivity {
    Button b1,b2,b3;
    EditText e1,e2,e3,e4;
    RadioGroup radioGroup;
    //SQLiteDatabase db;
    BookingHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking1);
        b1 = findViewById(R.id.date);
        b2 = findViewById(R.id.time);
        e1 = findViewById(R.id.et);
        e2 = findViewById(R.id.ed);
        e3 = findViewById(R.id.en);
        e4 = findViewById(R.id.ea);
        b3 = findViewById(R.id.bd);
        radioGroup = findViewById(R.id.groupradio);

      /*  db = openOrCreateDatabase("AppointmentsDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS APPOINTMENT(Name varchar(20) primary key,Age varchar(3),Date varchar(10),Time varchar(6))");*/

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int year1 = c.get(Calendar.YEAR);
                int month1 = c.get(Calendar.MONTH);
                int day1 = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dp = new DatePickerDialog(booking1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        e2.setText(day + "/" + (month + 1) + "/" + year);
                    }
                }, year1, month1, day1);
                dp.show(); //show the datepicker
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int min = c.get(Calendar.MINUTE);
                TimePickerDialog tp = new TimePickerDialog(booking1.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int i, int i1) {
                        e1.setText(i + ":" + i1);
                    }
                }, hour, min, true);
                tp.show();
            }
        });
        radioGroup.clearCheck();

      /*  radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override

            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // Get the selected Radio Button
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                String r = radioButton.getText().toString();
            }
        });*/

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=e3.getText().toString();
                Integer a= Integer.parseInt(e4.getText().toString());
                String d=e2.getText().toString();
                String t=e1.getText().toString();

               /*Cursor c=db.rawQuery("SELECT * FROM APPOINTMENT",null);
                if(c.getCount()==0){
                    db.execSQL("INSERT INTO APPOINTMENT VALUES('" + n + "'," + a + ",'" + d + "'," + t + ")");
                    Toast.makeText(booking1.this, "Booking is successful", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(booking1.this, "Error in Booking....Try Again", Toast.LENGTH_SHORT).show();
                }*/

                db = new BookingHelper(booking1.this);
                long res = db.insertData(e3.getText().toString(), Integer.parseInt(e4.getText().toString()), ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString(), e2.getText().toString(), e1.getText().toString());
                if (res == -1) {
                    Toast.makeText(booking1.this, "Error in booking", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(booking1.this, "Booked Successfully", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
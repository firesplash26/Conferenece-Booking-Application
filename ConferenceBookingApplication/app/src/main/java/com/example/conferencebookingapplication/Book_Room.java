package com.example.conferencebookingapplication;
import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class Book_Room extends AppCompatActivity implements OnClickListener, AdapterView.OnItemSelectedListener {

    private TextView from_date;
    private TextView to_date;
    private DatePickerDialog.OnDateSetListener from_dateSetListener;
    private DatePickerDialog.OnDateSetListener to_dateSetListener;
    Spinner room_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_book__room);

        room_spinner=(Spinner) findViewById(R.id.spinner3);
        Bundle bundle=getIntent().getExtras();
        if (bundle != null){
            room_spinner.setPrompt(bundle.getString("RoomName"));
        }

        to_date=(TextView)findViewById(R.id.t_date);

        to_date.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Calendar cal2=Calendar.getInstance();
                int year2=cal2.get(Calendar.YEAR);
                int month2=cal2.get(Calendar.MONTH);
                int day2=cal2.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog= new DatePickerDialog(Book_Room.this,android.R.style.Theme_DeviceDefault_Dialog_MinWidth,to_dateSetListener,year2,month2,day2);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        to_dateSetListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year2, int month2, int day2) {
                month2=month2+1;
                String date2=day2+"/"+month2+"/"+year2;
                to_date.setText(date2);
            }
        };

        from_date=(TextView) findViewById(R.id.f_date);
        from_date.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Calendar cal1=Calendar.getInstance();
                int year1=cal1.get(Calendar.YEAR);
                int month1=cal1.get(Calendar.MONTH);
                int day1=cal1.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog=new DatePickerDialog(Book_Room.this,android.R.style.Theme_DeviceDefault_Dialog_MinWidth,from_dateSetListener,year1,month1,day1);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        from_dateSetListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year1, int month1, int day1) {
                month1=month1+1;
                String date1=day1+"/"+month1+"/"+year1;
                from_date.setText(date1);

            }
        };


        Spinner spinner=findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.ChooseRoom,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button5 = findViewById(R.id.button5);

        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    @Override

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                startActivity(new Intent(Book_Room.this, Book_Room.class));
                finish();
                break;

            case R.id.button3:
                startActivity(new Intent(Book_Room.this, View_Facilities.class));
                finish();
                break;

            case R.id.button5:
                startActivity(new Intent(Book_Room.this, Room_Booking.class));
                finish();
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sign_out_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.sign_out:
                startActivity(new Intent(Book_Room.this, MainActivity.class));
                finish();
        }

        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text=parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


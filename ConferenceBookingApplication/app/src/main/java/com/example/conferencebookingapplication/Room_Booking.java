package com.example.conferencebookingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Room_Booking extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_room__booking);

        Button button2 = findViewById(R.id.button7);
        Button button3 = findViewById(R.id.button8);

        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }

    @Override

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button7:
                startActivity(new Intent(Room_Booking.this, Book_Room.class));
                finish();
                break;

            case R.id.button8:
                startActivity(new Intent(Room_Booking.this, View_Facilities.class));
                finish();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.sign_out_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.sign_out:
                finish();
                startActivity(new Intent(Room_Booking.this, MainActivity.class));
        }
        return true;
    }

}

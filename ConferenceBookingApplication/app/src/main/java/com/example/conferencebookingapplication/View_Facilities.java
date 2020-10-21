package com.example.conferencebookingapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class View_Facilities extends AppCompatActivity implements View.OnClickListener {

    ListView list;
    String rooms[] = {"Room 1","Room 2","Room 3","Room 4","Room 5"};
    String description[]= {"20 seater","30 seater","30  seater","20 seater","40 seater"};
    String  vc[] ={"YES","NO","YES","YES","NO"};
    String  projector[] ={"YES","NO","YES","NO","NO"};
    String camera[]={"YES","NO","YES","NO","YES"};
    String ips[]={"10.100.21.53","10.100.21.54","10.100.21.34","10.100.34.32","10.100.23.12"};
    String ext[]={"234","443","423","231","341"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__facilities);

        list=findViewById(R.id.list1);
        MyAdapter adapter= new MyAdapter(this, rooms,description,vc,projector, camera,ips,ext);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(View_Facilities.this,Book_Room.class);
                intent.putExtra("RoomName", list.getItemAtPosition(position).toString());
                finish();
                startActivity(intent);
            }
        });
        Button button2 = findViewById(R.id.button4);
        Button button3 = findViewById(R.id.button6);

        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String myrooms[];
        String mydescriptions[];
        String myvc[];
        String myprojector[];
        String mycamera[];
        String myips[];
        String myext[];

        MyAdapter(Context c,String[] rooms,String[] description,String[] vc,String[] projector, String[] camera,String[] ips,String[] ext){
            super(c,R.layout.custom_listadapter,R.id.R_name,rooms);
            this.context=c;
            this.myrooms=rooms;
            this.mydescriptions=description;
            this.myvc=vc;
            this.myprojector=projector;
            this.mycamera=camera;
            this.myips=ips;
            this.myext=ext;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater= (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View custom_listadapter=layoutInflater.inflate(R.layout.custom_listadapter,parent, false);
            TextView myrooms=custom_listadapter.findViewById(R.id.R_name);
            TextView mydescription=custom_listadapter.findViewById(R.id.des);
            TextView myvc=custom_listadapter.findViewById(R.id.vc);
            TextView myprojector=custom_listadapter.findViewById(R.id.proj);
            TextView mycamera=custom_listadapter.findViewById(R.id.cam);
            TextView myips=custom_listadapter.findViewById(R.id.ip);
            TextView myext=custom_listadapter.findViewById(R.id.extno);
            myrooms.setText(rooms[position]);
            mydescription.setText(description[position]);
            myvc.setText(vc[position]);
            myprojector.setText(projector[position]);
            mycamera.setText(camera[position]);
            myips.setText(ips[position]);
            myext.setText(ext[position]);
            return custom_listadapter;
        }
    }

    @Override

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button4:
                startActivity(new Intent(View_Facilities.this, Book_Room.class));
                finish();
                break;

            case R.id.button6:
                startActivity(new Intent(View_Facilities.this, View_Facilities.class));
                finish();
                break;

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
                startActivity(new Intent(View_Facilities.this, MainActivity.class));
                finish();
        }

        return true;
    }


}


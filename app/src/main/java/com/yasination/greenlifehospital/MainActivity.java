package com.yasination.greenlifehospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ListView myListView;
    ArrayList<HashMap<String, String>> myArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = findViewById(R.id.myListView);

        MyAdapter myAdapter = new MyAdapter();
        myListView.setAdapter(myAdapter);

        for (int i = 1; i <= 25; i++) {
            String name = getString(getResources().getIdentifier("doctor" + i + "_name", "string", getPackageName()));
            String subject = getString(getResources().getIdentifier("doctor" + i + "_subject", "string", getPackageName()));
            String appointment = getString(getResources().getIdentifier("doctor" + i + "_appointment", "string", getPackageName()));

            HashMap<String, String> myHashMap = new HashMap<>();
            myHashMap.put("Name", name);
            myHashMap.put("Subject", subject);
            myHashMap.put("Appointment", appointment);

            myArrayList.add(myHashMap);
        }



    } //------------------------------onCreate End   -----------

    private class MyAdapter extends BaseAdapter {

        LayoutInflater layoutInflater;
        @Override
        public int getCount() {
            return myArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.single_view,parent, false);

            TextView tvName = myView.findViewById(R.id.tvName);
            TextView tvSubject = myView.findViewById(R.id.tvSubject);
            LinearLayout myLayout = myView.findViewById(R.id.myLayout);


            HashMap <String, String> getHashMapItem =myArrayList.get(position);
            String Name = getHashMapItem.get("Name");
            String Subject = getHashMapItem.get("Subject");
            String Appointment =getHashMapItem.get("Appointment");

            tvName.setText(Name);
            tvSubject.setText(Subject);

            myLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ContentActivity.doctorName = Name;
                    ContentActivity.doctorSubject = Subject;
                    ContentActivity.doctorAppointment = Appointment;

                    Intent i = new Intent(MainActivity.this,ContentActivity.class);
                    startActivity(i);
                }
            });

            return myView;
        }
    }
}
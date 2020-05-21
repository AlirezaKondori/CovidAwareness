package com.example.medicaldevice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Lion's Gate Hospital", "St. Paul's Hospital", "Vancouver General Hospital", "Burnaby hosptial", "BC Women's Hospital"};
    String mDistance[] = {"1.3 mi", "4.7 mi", "5.8 mi", "6.7 mi", "6.9 mi"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.list);
        myAdapter adapter = new myAdapter(this, mTitle, mDistance);
        listView.setAdapter(adapter);
    }

    class myAdapter extends ArrayAdapter<String> {
        Context context;
        String rstring[];
        String rdistance[];

        myAdapter(Context c, String title[], String distance[] ) {
            super(c, R.layout.row, R.id.location, title);
            this.context = c;
            this.rstring = title;
            this.rdistance = distance;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView myTitle = row.findViewById(R.id.location);
            TextView myDistance = row.findViewById(R.id.distance);
            myTitle.setText(rstring[position]);
            myDistance.setText(rdistance[position]);



            return row;
        }
    }
}

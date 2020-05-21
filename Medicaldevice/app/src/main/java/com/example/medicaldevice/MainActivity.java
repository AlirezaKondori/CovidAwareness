package com.example.medicaldevice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView text1;
    TextView text2;
    TextView text3;
    Button button;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.Text1);
        text2 = (TextView)findViewById(R.id.Text2);
        text3 = (TextView)findViewById(R.id.Text3);
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        new doit().execute();

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main3Activity.class));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }
    public class doit extends AsyncTask<Void,Void,Void>{

        String cases;
        List<String> myList;
        String num_cases;
        String num_deaths;
        String num_recovered;
        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Document doc = Jsoup.connect("https://www.worldometers.info/coronavirus/").get();
                cases = doc.select("div.maincounter-number").select("span").text() + " ";
                myList = new ArrayList<String>(Arrays.asList(cases.split(" ")));
                num_cases = myList.get(0);
                num_deaths = myList.get(1);
                num_recovered = myList.get(2);
            }catch(Exception e) {e.printStackTrace();}
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            text1.setText(num_cases);
            text2.setText(num_deaths);
            text3.setText(num_recovered);

        }
    }
}

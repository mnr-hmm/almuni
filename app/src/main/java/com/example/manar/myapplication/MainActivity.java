package com.example.manar.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
// values for each coulmn to be insrted

    public static final String date="date";
    public static final String time="time";
    public static final String location="location";
    private static final String timeTl = "الساعة8:30  مساء";
    private static final  String locationTl = "فندق الشهداء";
    private static final  String dateTl = "ابريل  22 الموافق شعبان 6 الاحد";
    private static final String timeAlumni = "الساعة 6 مساء";
    private static final  String locationAlumni = "الاستاند الرياضي بالمدينة الجامعية الجديدة";
    private static final  String dateAlumni = "ابريل  22 الموافق شعبان 6 الاحد";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBOpenHelper d= new DBOpenHelper(this);

        // call insert method
        d.inserti(date,timeTl);
        d.inserti(time,locationTl);
        d.inserti(location,dateTl);
        d.inserti(date,dateAlumni);
        d.inserti(time,timeAlumni);
        d.inserti(location,locationAlumni);
        d.addBeer(R.drawable.talaqi);
        d.addBeer(R.drawable.talaqi1);
        d.addBeer(R.drawable.talaqi2);
        d.addBeer(R.drawable.inside_first);
//        d.addBeer(R.drawable.cer_first);
//        d.addBeer(R.drawable.cer_sec);
//        d.addBeer(R.drawable.cer_third);



    }

    public void toCompany(View v){

        Intent i = new Intent(MainActivity.this,company.class);
        startActivity(i);

    }

    public void toNews(View v){

        Intent i = new Intent(MainActivity.this,news.class);
        startActivity(i);

    }

    public void toGradParties(View v){

        Intent i = new Intent(MainActivity.this,outside.class);
        startActivity(i);

    }

    public void toTalaqi(View v){

        Intent i = new Intent(MainActivity.this,talaqi.class);
        startActivity(i);

    }

    public void toServices(View v){

        Intent i = new Intent(MainActivity.this,MainServices.class);
        startActivity(i);

    }
}

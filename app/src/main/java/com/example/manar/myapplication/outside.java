package com.example.manar.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;


public class outside extends AppCompatActivity

{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outside);
//            ImageView pic1= (ImageView)findViewById(R.id.img1);
//            ImageView pic2= (ImageView)findViewById(R.id.img2);
//            ImageView pic3= (ImageView)findViewById(R.id.img3);
        DBOpenHelper dh = new DBOpenHelper(this);

//            Cursor c1 =dh.retrieve(11);
//            if(c1.moveToFirst())
//            {
//                byte[] image = c1.getBlob(5);
//                Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
//                pic1.setImageBitmap(bitmap);
//
//
//            } else {
//                Toast.makeText(getBaseContext(), "No Record Found", Toast.LENGTH_LONG).show();
//            }
//
//            Cursor c2 =dh.retrieve(12);
//            if(c2.moveToFirst())
//            {
//                byte[] image = c2.getBlob(5);
//                Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
//                pic2.setImageBitmap(bitmap);
//
//
//            } else {
//                Toast.makeText(getBaseContext(), "No Record Found", Toast.LENGTH_LONG).show();
//            }
//
//            Cursor c3 =dh.retrieve(13);
//            if(c3.moveToFirst())
//            {
//                byte[] image = c3.getBlob(5);
//                Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
//                pic3.setImageBitmap(bitmap);
//
//
//            } else {
//                Toast.makeText(getBaseContext(), "No Record Found", Toast.LENGTH_LONG).show();
//            }



    }

    // intent to go to inside class
    public void clk (View view ) {

        Intent i = new Intent(outside.this, inside.class);
        startActivity(i);


    }
}

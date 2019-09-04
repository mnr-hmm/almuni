package com.example.manar.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class talaqi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.talaqi);
        DBOpenHelper dh = new DBOpenHelper(this);

        // link each component to its id
        ImageView ic= (ImageView)findViewById(R.id.imageView6);
        ImageView ic1= (ImageView)findViewById(R.id.Cerimg);
        ImageView ic2= (ImageView)findViewById(R.id.img2);

        try{

// retrieve image 1
            Cursor c =dh.retrieve(7);
            if(c.moveToFirst())
            {
                byte[] image = c.getBlob(5);
                Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
                ic.setImageBitmap(bitmap);


            } else {
                Toast.makeText(getBaseContext(), "No Record Found", Toast.LENGTH_LONG).show();
            }

        }

        catch (Exception e){

        }


        try{

            // retrieve image 2
            Cursor c1 =dh.retrieve(8);
            if(c1.moveToFirst())
            {
                byte[] image = c1.getBlob(5);
                Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
                ic1.setImageBitmap(bitmap);


            } else {
                Toast.makeText(getBaseContext(), "No Record Found", Toast.LENGTH_LONG).show();
            }

        }

        catch (Exception e){

        }


        try{

            // retrieve image 3
            Cursor c2 =dh.retrieve(9);
            if(c2.moveToFirst())
            {
                byte[] image = c2.getBlob(5);
                Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
                ic2.setImageBitmap(bitmap);


            } else {
                Toast.makeText(getBaseContext(), "No Record Found", Toast.LENGTH_LONG).show();
            }

        }

        catch (Exception e){

        }


    }



    // open talaqinside class
    public void clickTalaqi (View view) {


        Intent i = new Intent(talaqi.this, Talaqinside.class);
        startActivity(i);



    }


}
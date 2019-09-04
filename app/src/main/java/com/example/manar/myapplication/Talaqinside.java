package com.example.manar.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Talaqinside extends AppCompatActivity {

    private static final  String seniorlistAlumni = "https://docs.google.com/spreadsheets/d/1RI8lGH9IrXM9oXJOj8nTS1BZDIMguUL7Pu9U0Bn9BcA/edit#gid=0";
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.talaqinside);

        // link each compoenets to its id
        TextView dateV = (TextView)findViewById(R.id.dateT);
        TextView timeV = (TextView)findViewById(R.id.timeT);
        TextView locationV =(TextView) findViewById(R.id.locationT);
        Button s= (Button) findViewById(R.id.slider);
// objects
        DBOpenHelper d= new DBOpenHelper(this);
        webview=  new WebView(this);
        try{




// insert time , date and location
            Cursor c =d.retrieve(1);
            Cursor c1=d.retrieve(2);
            Cursor c2=d.retrieve(3);


// retrive time , date and location
            if(c.moveToFirst())
            {

                dateV.setText(c.getString(1));

            } else {
                Toast.makeText(getBaseContext(), "No Record Found", Toast.LENGTH_LONG).show();
            }

            if(c1.moveToFirst())
            {


                timeV.setText(c1.getString(2));


            } else {
                Toast.makeText(getBaseContext(), "No Record Found", Toast.LENGTH_LONG).show();
            }



            if(c2.moveToFirst())
            {


                locationV.setText((c2.getString(3)));

            } else {
                Toast.makeText(getBaseContext(), "No Record Found", Toast.LENGTH_LONG).show();
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    // slider for images
    public void clkSlider (View view){
        Intent i = new Intent(Talaqinside.this, Slider.class);
        startActivity(i);

    }

    // registration google form
    public void clkReg ( View view) {

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://gsuite.google.com/intl/en/products/forms/?utm_source=google&utm_medium=cpc&utm_campaign=emea-sa-all-en-dr-bkws-all-all-trial-e-t1-1003964&utm_content=text-ad-none-none-DEV_c-CRE_167742349370-ADGP_Hybrid%20%7C%20AW%20SEM%20%7C%20BKWS%20~%20EXA_M:1_SA_EN_Forms_misc-KWID_43700016330456348-kwd-19885114058-userloc_9051475&utm_term=KW_google%20form-ST_google%20form&ds_rl=1259922&gclid=Cj0KCQiAurjgBRCqARIsAD09sg-8z8ZNmxkKBfo6PKrxsU56nyNnVqp4nIrHwc7TE3ykipc7Ckisj0gaApZUEALw_wcB&gclsrc=aw.ds"));
        startActivity(i);

    }

    public void ClickList (View view){

        webview.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url="+ seniorlistAlumni);
//        Intent i = new Intent(Intent.ACTION_VIEW);
//        i.setData(Uri.parse(seniorlistAlumni));
//        startActivity(i);
    }


}
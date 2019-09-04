package com.example.manar.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class company extends AppCompatActivity {
    ImageView img1,img2,img3,img4,img5,img6,img7,img8;
    Button healthBtn,engbtn,edcbtn,adabbtn;
    DBOpenHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        ImageView[] img ;
        img = new ImageView[]{
                img1 = findViewById(R.id.img1),
                img2 = findViewById(R.id.img2),
                img3 = findViewById(R.id.img3),
                img4 = findViewById(R.id.img4),
                img5 = findViewById(R.id.img5),
                img6 = findViewById(R.id.img6),
                img7 = findViewById(R.id.img7),
                img8 = findViewById(R.id.img8)};
        healthBtn = findViewById(R.id.healthbtn);
        engbtn = findViewById(R.id.engbtn);
        edcbtn = findViewById(R.id.edcbtn);
        adabbtn = findViewById(R.id.adabbtn);
        db = new DBOpenHelper(this);
        db.addCompany("King Fahad Hospital","https://www.kfsh.med.sa/KFSH_Website/Ar/",R.drawable.lmlk_fhd_ltkhssy);
        db.addCompany("ProCare","http://www.procare.com.sa/default.aspx?lang=en-us",R.drawable.procare);
        db.addCompany("General Authority of Civil Aviation","https://gaca.gov.sa/web/ar-sa/page/home",R.drawable.gacanewlogo);
        db.addCompany("Saudi Aramco Company","https://www.saudiaramco.com/",R.drawable.saudi_aramco);
        db.addCompany("King Fahad Hospital","https://www.kfsh.med.sa/KFSH_Website/Ar/",R.drawable.lmlk_fhd_ltkhssy);
        db.addCompany("Royal Commission for Jubail & Yanbu","https://www.rcjy.gov.sa/en-US/Pages/default.aspx",R.drawable.rcjylogonew);
        db.addCompany("Johns Hopkins Medicine","https://www.hopkinsmedicine.org/international/international_affiliations/middle_east/johns_hopkins_aramco_healthcare.html",R.drawable.images);
        db.addCompany("King Fahad Medical City","https://www.kfmc.med.sa/#ET",R.drawable.lmlk_fhd_ltby);



        int counter =0;
        Cursor c = db.retrieveAllCompanies();
        if(c.moveToFirst())
       do {

            byte[] image = c.getBlob(2);
            Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
            img[counter].setImageBitmap(bitmap);
            counter++;
;
        }
        while(c.moveToNext() && counter < 8);


    }

    public void toKingFahad(View v ){
        Cursor c = db.retrieveLink("King Fahad Hospital");

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(c.getString(0)));
        startActivity(i);

    }

    public void toProCare(View v ){
        Cursor c = db.retrieveLink("ProCare");

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(c.getString(0)));
        startActivity(i);

    }

    public void toGACA(View v ){
        Cursor c = db.retrieveLink("General Authority of Civil Aviation");

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(c.getString(0)));
        startActivity(i);

    }
    public void toSaudiAramco(View v ){
        Cursor c = db.retrieveLink("Saudi Aramco Company");

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(c.getString(0)));
        startActivity(i);

    }


    public void toJubail(View v ){
        Cursor c = db.retrieveLink("Royal Commission for Jubail & Yanbu");

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(c.getString(0)));
        startActivity(i);

    }

    public void toKFMC(View v ){
        Cursor c = db.retrieveLink("King Fahad Medical City");

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(c.getString(0)));
        startActivity(i);

    }

    public void toJHM(View v ){
        Cursor c = db.retrieveLink("Johns Hopkins Medicine");

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(c.getString(0)));
        startActivity(i);

    }
    public void hideShowHealth(View v){
        if(img1.getVisibility()==View.VISIBLE) {
            healthBtn.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_add_white_24dp),null,null,null);
            img1.setVisibility(View.GONE);
            img2.setVisibility(View.GONE);
        }

        else if(img1.getVisibility()==View.GONE){
            healthBtn.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_remove_black_24dp),null,null,null);

            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.VISIBLE);

    }}

    public void hideShowEng(View v){
        if(img3.getVisibility()==View.VISIBLE) {
            engbtn.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_add_white_24dp),null,null,null);
            img3.setVisibility(View.GONE);
            img4.setVisibility(View.GONE);
        }

        else if(img3.getVisibility()==View.GONE){
            engbtn.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_remove_black_24dp),null,null,null);

            img3.setVisibility(View.VISIBLE);
            img4.setVisibility(View.VISIBLE);

        }}

    public void hideShowEdc(View v){
        if(img5.getVisibility()==View.VISIBLE) {
            edcbtn.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_add_white_24dp),null,null,null);
            img5.setVisibility(View.GONE);
            img6.setVisibility(View.GONE);
        }

        else if(img5.getVisibility()==View.GONE){
            edcbtn.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_remove_black_24dp),null,null,null);

            img5.setVisibility(View.VISIBLE);
            img6.setVisibility(View.VISIBLE);

        }}

    public void hideShowAdab(View v){
        if(img7.getVisibility()==View.VISIBLE) {
            adabbtn.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_add_white_24dp),null,null,null);
            img7.setVisibility(View.GONE);
            img6.setVisibility(View.GONE);
        }

        else if(img7.getVisibility()==View.GONE){
            adabbtn.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_remove_black_24dp),null,null,null);

            img7.setVisibility(View.VISIBLE);
            img8.setVisibility(View.VISIBLE);

        }}


}

package com.example.manar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.app.AlertDialog.Builder;

public class MailingList extends Activity implements View.OnClickListener {

    EditText firstName;
    EditText surName;
    EditText email;
    RadioGroup radioGroup;
    Button send;
    int regist_in = 1;

    // create an instance from the openHelper database class "AlmuniDBHelper.java"
    final DBOpenHelper almuniDBHelper = new DBOpenHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mailing);

        //binding the UI's controls defined in "activity_main.xml" to JAVA code
        firstName = (EditText) findViewById(R.id.firstName);
        surName = (EditText) findViewById(R.id.surName);
        email = (EditText) findViewById(R.id.email);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup2);
        send = (Button) findViewById(R.id.send);

        //LISTENER: wiring the Button widget to event-&-code
        send.setOnClickListener(this);

    }// onCreate()

    @Override
    public void onClick(View view){
        // show error message if one of the fields is empty
        if (firstName.getText().toString().trim().length()==0||
                surName.getText().toString().trim().length()==0||
                email.getText().toString().trim().length()==0)
        {
            showMessage("خطأ", "يرجى إدخال جميع البيانات");
            return;
        }

        if (!email.getText().toString().trim().contains("@"))
        {
            showMessage("خطأ", "يرجى إدخال البريد الإلكتروني بشكل صحيح");
            return;
        }

        String fname = firstName.getText().toString();
        String sname = surName.getText().toString();
        String eml = email.getText().toString();
        int regist = regist_in;

        //insert into MailingList table
        almuniDBHelper.insertMailingList(fname,sname,eml,regist);
        showMessage("نجاح", "تمت الإضافة بنجاح");
        clearText();



    }//onClick ()

    public void onRadoiButtonClick(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            // "التوجيه"
            case R.id.R1:
                if(checked)
                    regist_in = 1;
                break;
            //"التبرعات"
            case R.id.R2:
                if(checked)
                    regist_in = 2;
                break;
            // "لنشرة الإخبارية"
            case R.id.R3:
                if(checked)
                    regist_in = 3;
                break;
        }

    }// onRadoiButtonClick()

    public void showMessage(String title,String message)
    {
        Builder builder=new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }//showMessage()

    public void clearText()
    {
        firstName.setText("");
        surName.setText("");
        email.setText("");
        radioGroup.clearCheck();
        firstName.requestFocus();
    }//clearText()

}//class
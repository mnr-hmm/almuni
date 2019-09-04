package com.example.manar.myapplication;


import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainServices extends Activity implements View.OnClickListener {
    Button mailingList;
    Button trainingReq;
    Button membershipReq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_services);

        //binding the UI's controls defined in "activity_main.xml" to JAVA code
        mailingList = (Button) findViewById(R.id.mailingList);
        trainingReq = (Button) findViewById(R.id.trainig);
        membershipReq = (Button) findViewById(R.id.membership);

        //LISTENER: wiring the Button widget to event-&-code
        mailingList.setOnClickListener(this);
        trainingReq.setOnClickListener(this);
        membershipReq.setOnClickListener(this);
    }//onCreate

    @Override
    public void onClick(View view){
        if(view.getId()==mailingList.getId()){
            Intent intent = new Intent(this, MailingList.class);
            startActivity(intent);
        }
        if(view.getId()==trainingReq.getId()){
            Intent intent = new Intent(this, Training.class);
            startActivity(intent);
        }
        if(view.getId()==membershipReq.getId()){
            Intent intent = new Intent(this, Membership.class);
            startActivity(intent);
        }

    }//onClick
}//class
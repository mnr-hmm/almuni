package com.example.manar.myapplication;
import android.os.Bundle;
import android.app.Activity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.app.AlertDialog.Builder;
import android.widget.Toast;

public class Training extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText arbName,engName,age,natID,stuID,major,gradDate,phone,email,address;
    RadioGroup genderRadioGroup;
    Spinner collegeSpinner;
    Button send;
    int gender = 1;
    String college = "كلية الطب";

    // create an instance from the openHelper database class "AlmuniDBHelper.java"
    final DBOpenHelper almuniDBHelper = new DBOpenHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.membership);

        //binding the UI's controls defined in "activity_main.xml" to JAVA code
        arbName = (EditText) findViewById(R.id.arabic_Name);
        engName = (EditText) findViewById(R.id.english_Name);
        age = (EditText) findViewById(R.id.age);
        natID = (EditText) findViewById(R.id.nat_id);
        stuID = (EditText) findViewById(R.id.stu_id);
        major = (EditText) findViewById(R.id.major);
        gradDate = (EditText) findViewById(R.id.grad_date);
        phone = (EditText) findViewById(R.id.phone);
        email = (EditText) findViewById(R.id.email);
        address = (EditText) findViewById(R.id.address);
        genderRadioGroup = (RadioGroup) findViewById(R.id.GenderRadioGroup);
        send = (Button) findViewById(R.id.send);
        //Spinner with a drop down list
        collegeSpinner = (Spinner) findViewById(R.id.College);
        ArrayAdapter<String> collegeAdapter = new ArrayAdapter<String>(Training.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.colleges));
        collegeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        collegeSpinner.setAdapter(collegeAdapter);

        //LISTENER: wiring the Button widget to event-&-code
        send.setOnClickListener(this);
        collegeSpinner.setOnItemSelectedListener(this);
    }// onCreate()

    @Override
    public void onClick(View view){
        // show error message if one of the fields is empty
        if (arbName.getText().toString().trim().length()==0||
                engName.getText().toString().trim().length()==0||
                age.getText().toString().trim().length()==0||
                natID.getText().toString().trim().length()==0||
                stuID.getText().toString().trim().length()==0||
                major.getText().toString().trim().length()==0||
                gradDate.getText().toString().trim().length()==0||
                phone.getText().toString().trim().length()==0||
                email.getText().toString().trim().length()==0||
                address.getText().toString().trim().length()==0)
        {
            showMessage("خطأ", "يرجى إدخال جميع البيانات");
            return;
        }

        if (!email.getText().toString().trim().contains("@"))
        {
            showMessage("خطأ", "يرجى إدخال البريد الإلكتروني بشكل صحيح");
            return;
        }

        if(natID.getText().toString().trim().length()!=10||
                natID.getText().toString().trim().length()!=10||
                phone.getText().toString().trim().length()!=10)
        {
            showMessage("خطأ", "يرجى التأكد من أن رقم الهوية أو الرقم الأكاديمي أو رقم الهاتف يتكون من 10 أرقام فقط");
            return;
        }

        String arabicName = arbName.getText().toString();
        String englishname = engName.getText().toString();
        String Age = age.getText().toString();
        String nationID = natID.getText().toString();
        String Major = major.getText().toString();
        String date = gradDate.getText().toString();
        String eml = email.getText().toString();
        String Phone = phone.getText().toString();
        String Address = address.getText().toString();
        String studentID = stuID.getText().toString();
        int gnd = gender;

        //insert into MailingList table
        almuniDBHelper.insertRequest("Training",arabicName,englishname,Age,gnd,nationID,Major,college,date,eml,Phone,Address,studentID);
        showMessage("نجاح", "تمت الإضافة بنجاح");
        clearText();

    }//onClick ()

    public void onRadoiButtonClick(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            // "Male"
            case R.id.male:
                if(checked)
                    gender = 1;
                break;
            //"Female"
            case R.id.female:
                if(checked)
                    gender = 2;
                break;
        }

    }// onRadoiButtonClick()

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedItemText= (String) parent.getItemAtPosition(position);
        college = selectedItemText;

    }// onItemClick()

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }// onNothingSelected()

    public void showMessage(String title,String message)
    {
        Builder builder=new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }// showMessage()

    public void clearText()
    {
        arbName.setText("");
        engName.setText("");
        age.setText("");
        natID.setText("");
        stuID.setText("");
        major.setText("");
        gradDate.setText("");
        phone.setText("");
        email.setText("");
        address.setText("");
        genderRadioGroup.clearCheck();
        arbName.requestFocus();
    }// clearText()


}//class
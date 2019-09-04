package com.example.manar.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Pair;
public class news extends AppCompatActivity {
    TextView title,body;
    ImageView img;
    Cursor c ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        final DBOpenHelper db = new DBOpenHelper(this);
        title = findViewById(R.id.title);
        body = findViewById(R.id.body);
        img = findViewById(R.id.img);
        db.addNews("يسر مركز الخريجين والتنمية المهنية تقديم استشارات مهنية ", "انطلاقاً من رؤية المملكة 2030م، والخطة الاستراتيجية للجامعة، بتوسيع فرص تعلم ومشاركة الطلبة بمساعدتهم على تحقيق تطلعاتهم الأكاديمية والمهنية، ومن ثم دعم التنمية وتنوع رأس المال الاقتصادي والبشري، وذلك من خلال المواءمة بين متطلبات سوق العمل وخريجي الجامعة يسر مركز الخريجين والتنمية المهنية تقديم استشارات مهنية خلال شهر ديسمبر 2018م.",
                R.drawable.iau);

        db.addNews("أمير المنطقة الشرقية يفتتح ملتقى المهنة لجامعة الدمام في نسخته الثالثة ",
                "افتتح صاحب السمو الملكي الأمير سعود بن نايف بن عبدالعزيز أمير المنطقة الشرقية يوم الاحد 10 رجب 1437 هـ ملتقى المهنة 2016 في نسخته الثالثة، الذي تنظمه جامعة الدمام، بحضور محافظ الخبر سليمان بن عبدالرحمن الثنيان وعدد من المسئولين بالمنطقة، وذلك في مقر مركز معارض الظهران الدولية في محافظة الخبر." ,
                R.drawable.tlqy3);

        db.addNews("استبيان قياس الارتباط المهني (الوظيفي)",
                "أطلقت وكالة عمادة شؤون أعضاء هيئة التدريس والموظفين استبيان قياس الارتباط المهني (الوظيفي) لموظفي الخدمة المدنية 1440 هــ - 2018 م.\n" ,
                R.drawable.measuring);

        db.addNews("مع ذكرى مرور عام على الأمر السامي بالسماح للمرأة بقيادة المركبة، ينشر الفريق البحثي السعودي/البريطاني النتائج الأولية للمشروع البحثي She Drives KSA",
                "بالتزامن مع مرور عام على صدور الأمر السامي بالسماح للمرأة بقيادة المركبة، نشر الفريق البحثي السعودي/البريطاني برئاسة عميدة خدمة المجتمع والتنمية المستدامة، أستاذ جغرافية النقل ونظم المعلومات الجغرافية المشارك بجامعة الإمام عبد الرحمن بن فيصل الدكتورة نجاح بنت مقبل القرعاوي التقرير الخاص بنتائج المرحلة الأولى من المشروع البحثي «أثر قيادة المرأة للسيارة على التنمية المستدامة والسلامة المرورية في المملكة العربية السعودية»، والذي يُعنى برصد وتوثيق المرحلة الانتقالية ما بين حظر قيادة المرأة للسيارة والسماح لها بذلك، حيث تم إطلاق المرحلة الأولى منه (قبل قيادة المرأة للسيارة بتاريخ 10 /10/ 1439هـ الموافق 24 /6 / 2018م) وذلك بالشراكة بين جامعة الإمام عبدالرحمن بن فيصل وجامعة UCL البريطانية." ,
                R.drawable.drivee_01);

        c = db.retrieveAllNews();
        if(c.moveToFirst())
        {

                title.setText(c.getString(0));
                body.setText(c.getString(1));
                byte[] image = c.getBlob(2);
                Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
                img.setImageBitmap(bitmap);


        }

    }

    public void readNext(View v){
           if(c.moveToNext())
        {

            title.setText(c.getString(0));
            body.setText(c.getString(1));
            byte[] image = c.getBlob(2);
            Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
            img.setImageBitmap(bitmap);

        }}

        public void readPre(View v){

            if(c.moveToPrevious())
            {

                title.setText(c.getString(0));
                body.setText(c.getString(1));
                byte[] image = c.getBlob(2);
                Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
                img.setImageBitmap(bitmap);

            }



    }



}
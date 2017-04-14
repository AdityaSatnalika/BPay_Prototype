package com.vituniversity.hackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class NewBlog extends AppCompatActivity {

    LinearLayout paymentFields;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_blog);

        paymentFields = (LinearLayout) findViewById(R.id.paymentFields);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rgPaymentStatus);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbPaid:
                        paymentFields.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rbFree:
                        paymentFields.setVisibility(View.GONE);
                        break;
                }
            }
        });
    }
}

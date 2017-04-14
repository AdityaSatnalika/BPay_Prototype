package com.vituniversity.hackathon;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

public class ViewBlog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_view_blog);

        LinearLayout clickToProceed = (LinearLayout) findViewById(R.id.clickToProceed);
        boolean isPaid = getIntent().getBooleanExtra("isPaid", false);
        if (isPaid) {
            clickToProceed.setVisibility(View.VISIBLE);
            Button bPay = (Button) findViewById(R.id.bPay);
            bPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("PAY", "clicked");
                    Intent intent = new Intent(getBaseContext(), PayPalReg.class);
                    startActivity(intent);
                }
            });
        }
        else
            clickToProceed.setVisibility(View.GONE);
    }
}

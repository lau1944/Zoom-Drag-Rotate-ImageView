package com.easystudio.rotateimageview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RotateZoomImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout playground = findViewById(R.id.playground);
        iv = findViewById(R.id.rotate);
        /*  iv = new RotateZoomImageView(getApplicationContext());
            iv.setImageDrawable(getDrawable(R.drawable.money));
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(250, 250);
            lp.addRule(RelativeLayout.BELOW);
            iv.setLayoutParams(lp);
            playground.addView(iv);
        */
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return iv.onTouch(v,event);
            }
        });
    }
}

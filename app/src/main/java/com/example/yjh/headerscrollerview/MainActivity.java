package com.example.yjh.headerscrollerview;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements HeaderScrollerView.ScrollViewListener{

    private HeaderScrollerView scrollview;

    private TextView tv;

    private ImageView imageView;

    private RelativeLayout title_rl;

    private int imageHeight;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollview = (HeaderScrollerView) findViewById(R.id.sv);
        imageView = (ImageView) findViewById(R.id.imageview);
        title_rl = (RelativeLayout) findViewById(R.id.title_rl);
        scrollview.setOnScrollViewListener(this);
        ViewTreeObserver vto = imageView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                imageHeight = imageView.getHeight();

                scrollview.setOnScrollViewListener(MainActivity.this);
            }
        });
    }

    @Override
    public void onScrollChanged(HeaderScrollerView headerScrollerView, int x, int y, int oldx, int oldy) {
        if ( y <= 0 ){
            title_rl.setBackgroundColor(Color.argb((int)0,227,29,26));
        }else if (y > 0 && y <= imageHeight){
            // y 要转float
            float scale =  (float) y / imageHeight;
            float alpha = 255 * scale;
            Log.e("***y****",y +"");
            Log.e("***imageHeight****",imageHeight+"");
            Log.e("***alpha****",alpha+"");
            title_rl.setBackgroundColor(Color.argb((int)alpha,227,29,26));
        }else {
            title_rl.setBackgroundColor(Color.argb((int)225,227,29,26));
        }
    }
}

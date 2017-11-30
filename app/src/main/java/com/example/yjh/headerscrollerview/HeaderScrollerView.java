package com.example.yjh.headerscrollerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.widget.ScrollView;
import android.widget.Scroller;

/**
 * Created by sungoin on 2017/11/30.
 */

public class HeaderScrollerView extends ScrollView {

    public HeaderScrollerView(Context context) {
        super(context);
    }

    public HeaderScrollerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HeaderScrollerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public interface ScrollViewListener{
        void onScrollChanged(HeaderScrollerView headerScrollerView, int x, int y, int oldx, int oldy);
    }

    private ScrollViewListener scrollViewListener;

    public void setOnScrollViewListener(ScrollViewListener scrollViewListener){
        this.scrollViewListener = scrollViewListener;
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
        }
    }

}

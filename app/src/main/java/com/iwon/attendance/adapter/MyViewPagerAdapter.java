package com.iwon.attendance.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class MyViewPagerAdapter extends PagerAdapter {
    private static final String TAG = MyViewPagerAdapter.class.getSimpleName();
    public int[] layouts;
    public Context context;

    public MyViewPagerAdapter(Context context, int[] layouts){
        this.layouts = layouts;
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        Log.d(TAG, "instantiateItem: " + position);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layouts[position], container, false);
        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        View view = (View) object;
        container.removeView(view);
    }

}

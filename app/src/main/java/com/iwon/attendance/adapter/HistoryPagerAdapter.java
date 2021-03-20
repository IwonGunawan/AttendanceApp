package com.iwon.attendance.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.iwon.attendance.R;
import com.iwon.attendance.fragment.history.DayFragment;
import com.iwon.attendance.fragment.history.MonthFragment;
import com.iwon.attendance.fragment.history.WeekFragment;
import com.iwon.attendance.fragment.history.YearFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class HistoryPagerAdapter extends FragmentStatePagerAdapter {
    private static final String TAG = HistoryPagerAdapter.class.getSimpleName();

    Context mContext;
    public HistoryPagerAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0 :
                fragment = new DayFragment();
                break;
            case 1:
                fragment = new WeekFragment();
                break;
            case 2:
                fragment = new MonthFragment();
                break;
            case 3:
                fragment = new YearFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String[] title = mContext.getResources().getStringArray(R.array.history_tab_label);

        return title[position];
    }
}

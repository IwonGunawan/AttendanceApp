package com.iwon.attendance.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.iwon.attendance.R;
import com.iwon.attendance.adapter.HistoryPagerAdapter;

public class HistoryFragment extends Fragment {
    private static final String TAG = HistoryFragment.class.getSimpleName();

    ViewPager viewPager;
    TabLayout tabLayout;
    HistoryPagerAdapter historyPagerAdapter;

    public HistoryFragment() {
        // Required empty public constructor
    }

    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        viewPager = view.findViewById(R.id.view_pager);
        tabLayout = view.findViewById(R.id.tab_layout);

        setupViewPager();
        setupTabLayout();

        return view;
    }

    private void setupViewPager(){
        historyPagerAdapter = new HistoryPagerAdapter(getChildFragmentManager(), getActivity());
        viewPager.setAdapter(historyPagerAdapter);
    }

    private void setupTabLayout(){
        tabLayout.setupWithViewPager(viewPager);
    }
}
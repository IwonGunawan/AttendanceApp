package com.iwon.attendance.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.iwon.attendance.R;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = HomeFragment.class.getSimpleName();

    Button btnCheckIn, btnCheckOut;
    RelativeLayout rlLocation1, rlLocation2, rlLocation3, rlLocation4;

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btnCheckIn = view.findViewById(R.id.btn_check_in);
        btnCheckOut = view.findViewById(R.id.btn_check_out);
        rlLocation1 = view.findViewById(R.id.rl_location_1);
        rlLocation2 = view.findViewById(R.id.rl_location_2);
        rlLocation3 = view.findViewById(R.id.rl_location_3);
        rlLocation4 = view.findViewById(R.id.rl_location_4);

        btnCheckIn.setOnClickListener(this);
        btnCheckOut.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_check_in:
                checkIn();
                break;

            case R.id.btn_check_out:
                checkOut();
                break;
        }
    }

    private void checkIn(){
        showBtnCheckOut();
    }

    private void checkOut(){
        showBtnCheckIn();
    }

    private void showBtnCheckIn(){
        btnCheckIn.setVisibility(View.VISIBLE);
        btnCheckOut.setVisibility(View.GONE);

        rlLocation1.setVisibility(View.VISIBLE);
        rlLocation2.setVisibility(View.VISIBLE);
        rlLocation3.setVisibility(View.VISIBLE);
        rlLocation4.setVisibility(View.GONE);
    }

    private void showBtnCheckOut(){
        btnCheckIn.setVisibility(View.GONE);
        btnCheckOut.setVisibility(View.VISIBLE);

        rlLocation1.setVisibility(View.GONE);
        rlLocation2.setVisibility(View.GONE);
        rlLocation3.setVisibility(View.GONE);
        rlLocation4.setVisibility(View.VISIBLE);
    }
}
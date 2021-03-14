package com.iwon.attendance.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.iwon.attendance.R;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = HomeFragment.class.getSimpleName();

    Button btnCheckIn, btnCheckOut;

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

                break;
        }
    }

    private void checkIn(){
        Toast.makeText(getContext(), "Show btn check in", Toast.LENGTH_SHORT).show();
    }
}
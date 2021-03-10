package com.iwon.attendance.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.iwon.attendance.DashboardActivity;
import com.iwon.attendance.R;

public class SignupFragment extends Fragment implements View.OnClickListener {

    TextView tvLogin;
    Button btnSignUp;

    public SignupFragment() {
        // Required empty public constructor
    }

    public static SignupFragment newInstance(String param1, String param2) {
        SignupFragment fragment = new SignupFragment();
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
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        btnSignUp = view.findViewById(R.id.btn_sign_up);
        tvLogin = view.findViewById(R.id.tv_login);

        btnSignUp.setOnClickListener(this);
        tvLogin.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_sign_up:
                viewDashboard();
                break;

            case R.id.tv_login:
                toLogin();
                break;
        }
    }

    private void signUp(){
        Toast.makeText(getContext(), "Event Button Sign Up", Toast.LENGTH_SHORT).show();
    }

    private void toLogin(){
        LoginFragment loginFragment = new LoginFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_sign_up, loginFragment, "login_page")
                .addToBackStack(null)
                .commit();
    }

    public void viewDashboard(){
        Intent intent = new Intent(getContext(), DashboardActivity.class);
        startActivity(intent);
    }
}
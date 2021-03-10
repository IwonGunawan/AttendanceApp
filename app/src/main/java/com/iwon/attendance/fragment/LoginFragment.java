package com.iwon.attendance.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.iwon.attendance.DashboardActivity;
import com.iwon.attendance.R;

public class LoginFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = LoginFragment.class.getSimpleName();

    TextView tvForgotPassword, tvSignUp;
    Button btnLogin;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        btnLogin = view.findViewById(R.id.btn_login);
        tvSignUp = view.findViewById(R.id.tv_sign_up);
        tvForgotPassword = view.findViewById(R.id.tv_forgot_password);

        btnLogin.setOnClickListener(this);
        tvSignUp.setOnClickListener(this);
        tvForgotPassword.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                viewDashboard();
                break;

            case R.id.tv_sign_up:
                toSignUp();
                break;

            case R.id.tv_forgot_password:
                toForgotPassword();
                break;
        }
    }

    private void login(){
        Toast.makeText(getContext(), "Event Button login show", Toast.LENGTH_SHORT).show();
    }

    private void toSignUp(){
        SignupFragment signupFragment = new SignupFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_login, signupFragment, "sign_up_page")
                .addToBackStack(null)
                .commit();
    }

    private void toForgotPassword(){
        ForgotFragment forgotFragment = new ForgotFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_login, forgotFragment, "forgot_page")
                .addToBackStack(null)
                .commit();
    }

    public void viewDashboard(){
        Intent intent = new Intent(getContext(), DashboardActivity.class);
        startActivity(intent);
    }
}
package com.iwon.attendance.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.iwon.attendance.R;

public class ForgotFragment extends Fragment implements View.OnClickListener {

    TextView tvLogin;
    Button btnForgotPassword;

    public ForgotFragment() {
        // Required empty public constructor
    }

    public static ForgotFragment newInstance(String param1, String param2) {
        ForgotFragment fragment = new ForgotFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
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
        View view = inflater.inflate(R.layout.fragment_forgot, container, false);

        btnForgotPassword = view.findViewById(R.id.btn_forgot_password);
        tvLogin = view.findViewById(R.id.tv_login);

        btnForgotPassword.setOnClickListener(this);
        tvLogin.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_forgot_password:
                forgotPassword();
                break;

            case R.id.tv_login:
                toLogin();
                break;
        }
    }

    private void forgotPassword(){
        Toast.makeText(getContext(), "Event button Forgot Password Show", Toast.LENGTH_SHORT).show();
    }

    private void toLogin(){
        LoginFragment loginFragment = new LoginFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_forgot, loginFragment)
                .addToBackStack(null)
                .commit();
    }
}
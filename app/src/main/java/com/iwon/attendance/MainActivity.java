package com.iwon.attendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.iwon.attendance.fragment.ForgotFragment;
import com.iwon.attendance.fragment.LoginFragment;
import com.iwon.attendance.fragment.SignupFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin    = findViewById(R.id.btn_login);
        btnSignUp   = findViewById(R.id.btn_signup);

        btnLogin.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                toLogin();
                break;

            case R.id.btn_signup:
                toSignUp();
                break;
        }
    }

    private void toLogin(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        LoginFragment loginFragment = new LoginFragment();
        fragmentTransaction.add(R.id.fL_container, loginFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void toSignUp(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        SignupFragment signupFragment = new SignupFragment();
        fragmentTransaction.add(R.id.fL_container, signupFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
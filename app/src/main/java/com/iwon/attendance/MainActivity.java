package com.iwon.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
                Toast.makeText(this, "show dialog Login", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_signup:
                Toast.makeText(this, "show dialog sign up", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
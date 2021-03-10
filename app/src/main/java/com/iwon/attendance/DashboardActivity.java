package com.iwon.attendance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.iwon.attendance.fragment.HistoryFragment;
import com.iwon.attendance.fragment.HomeFragment;
import com.iwon.attendance.fragment.ProfileFragment;

public class DashboardActivity extends AppCompatActivity {
    private static final String TAG = DashboardActivity.class.getSimpleName();

    BottomNavigationView bnvDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bnvDashboard = findViewById(R.id.bnv_dashboard);

        bottomNavigationMenu();
        init();
    }

    private void init(){
        firstLoadPage();
    }


    public void bottomNavigationMenu(){
        bnvDashboard.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.iHome:
                        fragment = new HomeFragment();
                        break;

                    case R.id.iHistory:
                        fragment = new HistoryFragment();
                        break;

                    case R.id.iProfile:
                        fragment = new ProfileFragment();
                        break;
                }

                return loadPage(fragment);
            }
        });
    }

    private void firstLoadPage(){
        Fragment fragment = new HomeFragment();
        loadPage(fragment);
    }

    private boolean loadPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_dashboard, fragment)
                    .commit();
            return true;
        }

        return false;
    }
}
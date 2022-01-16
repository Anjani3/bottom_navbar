package com.anjani.bottom_navbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.anjani.bottom_navbar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate (getLayoutInflater ( ));
        setContentView (R.layout.activity_main);

        replaceFragment (new HomeFragment ( ));


        activityMainBinding.bottomNavigationView.setOnItemSelectedListener (item -> {

            switch (item.getItemId ( )) {

                case R.id.home:
                    replaceFragment (new HomeFragment ( ));
                    break;
                case R.id.profile:
                    replaceFragment (new ProfileFragment ( ));
                    break;
                case R.id.settings:
                    replaceFragment (new SettingFragment ( ));
                    break;
            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = getSupportFragmentManager ( ).beginTransaction ( );
        fragmentTransaction.replace (R.id.frame_layout, fragment);
        fragmentTransaction.commit ( );


    }


}
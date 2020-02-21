package com.rrdev.bottomnavigationbar.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.rrdev.bottomnavigationbar.R;
import com.rrdev.bottomnavigationbar.fragment.FragmentOne;
import com.rrdev.bottomnavigationbar.fragment.FragmentThree;
import com.rrdev.bottomnavigationbar.fragment.FragmentTwo;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new FragmentOne());

        navigationView = findViewById(R.id.menu_Nav);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment (Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout,fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case  R.id.one_menu:
                fragment = new FragmentOne();
                break;
            case R.id.two_menu:
                fragment = new FragmentTwo();
                break;
            case R.id.three_menu:
                fragment = new FragmentThree();
                break;

        }
        return loadFragment(fragment);
    }
}
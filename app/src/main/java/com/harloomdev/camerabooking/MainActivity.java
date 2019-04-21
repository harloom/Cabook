package com.harloomdev.camerabooking;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.harloomdev.camerabooking.Fragment.AccountFragment;
import com.harloomdev.camerabooking.Fragment.HomeFragment;
import com.harloomdev.camerabooking.Fragment.OrdersFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new HomeFragment());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

    }


    private void initUI(){


    }

    private  boolean loadFragment(Fragment fragment){
        if(fragment !=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_navigation,fragment)
                    .commit();
            return  true;
        }

        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.navigation_home:

                fragment = new HomeFragment();
//                    item.setChecked(true);
                break;
            case R.id.navigation_order:
                fragment = new OrdersFragment();
                break;
            case R.id.navigation_profile:
                fragment =  new AccountFragment();
                break;
        }
        return loadFragment(fragment);
        }

}

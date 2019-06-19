package com.example.leliao;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    clickTab(0);
                    return true;
                case R.id.navigation_dashboard:
                    clickTab(1);
                    return true;
                case R.id.navigation_notifications:
                    clickTab(2);
                    return true;
                case R.id.navigation_mine:
                    clickTab(3);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews () {
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mViewPage = findViewById(R.id.viewpager);

        navView.setLabelVisibilityMode(1);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.navigation_home);

        //为viewpager设置adapter
        mViewPage.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }

    private void clickTab (int index) {
        mViewPage.setCurrentItem(index);
    }

}


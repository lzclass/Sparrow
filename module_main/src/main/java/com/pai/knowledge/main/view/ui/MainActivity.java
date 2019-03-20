package com.pai.knowledge.main.view.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.TextView;

import com.pai.knowledge.common.base.BaseActivity;
import com.pai.knowledge.common.base.BaseFragment;
import com.pai.knowledge.main.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_data:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_my:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BaseFragment[] fragmentList = new BaseFragment[4];
        fragmentList[0] = HomeFragment.newInstance();
        fragmentList[1] = HomeFragment.newInstance();
        fragmentList[2] = HomeFragment.newInstance();
        fragmentList[3] = HomeFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fl_content, fragmentList[0]);
        fragmentTransaction.add(R.id.fl_content, fragmentList[1]);
        fragmentTransaction.add(R.id.fl_content, fragmentList[2]);
        fragmentTransaction.add(R.id.fl_content, fragmentList[3]);
    }

}

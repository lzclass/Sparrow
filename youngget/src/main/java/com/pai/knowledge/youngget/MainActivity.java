package com.pai.knowledge.youngget;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.pai.knowledge.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int i = item.getItemId();
            if (i == R.id.navigation_home) {
                switchFragment(0);
//                    startActivity(new Intent(MainActivity.this, SideSlipCloseActivity.class));
                return true;
            } else if (i == R.id.navigation_dashboard) {
                return true;
            } else if (i == R.id.navigation_notifications) {
                return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        webViewFragment = WebViewFragment.newInstance();
        fragments = new ArrayList<>();
        fragments.add(webViewFragment);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_content, webViewFragment);
        fragmentTransaction.commit();
    }

    private WebViewFragment webViewFragment;
    private List<Fragment> fragments;

    private void switchFragment(int pos) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_NONE);
        for (int i = 0; i < fragments.size(); i++) {
            if (i == pos) {
                transaction.show(fragments.get(i));
                fragments.get(i).setUserVisibleHint(true);
            } else {
                transaction.hide(fragments.get(i));
                fragments.get(i).setUserVisibleHint(false);
            }
        }
        transaction.commitAllowingStateLoss();
    }

}

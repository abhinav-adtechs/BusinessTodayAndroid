package io.cse325.businesstoday.View.Feed;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.MenuItem;

import io.cse325.businesstoday.R;
import io.cse325.businesstoday.View.CustomViews.BaseActivity;
import io.cse325.businesstoday.View.Dashboard.DashboardFragment;
import io.cse325.businesstoday.View.Requests.RequestsFragment;
import io.cse325.businesstoday.View.Settings.SettingsFragment;

public class MainActivity extends BaseActivity {

    private Fragment currentFragment = null ;
    private Fragment nextFragment = null ;
    private ActionBar actionBarMain ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBarMain = getSupportActionBar() ;

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigaton_activity_main);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        currentFragment = new FeedFragment() ;
       // makeFragmentTransaction(currentFragment);

        addFragmentTransaction(currentFragment);
    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_feed:
                    nextFragment = new FeedFragment() ;
                    actionBarMain.setTitle("Feed");
                    makeFragmentTransaction(nextFragment) ;
                    break;

                case R.id.navigation_dashboard:
                    nextFragment = new DashboardFragment() ;
                    actionBarMain.setTitle("Dashboard");
                    makeFragmentTransaction(nextFragment) ;
                    break;

                case R.id.navigation_requests:
                    nextFragment = new RequestsFragment() ;
                    actionBarMain.setTitle("Requests");
                    makeFragmentTransaction(nextFragment) ;
                    break;

                case R.id.navigation_settings:
                    nextFragment = new SettingsFragment() ;
                    actionBarMain.setTitle("Settings");
                    makeFragmentTransaction(nextFragment) ;
                    break;
            }



            return true ;
        }

    };




    private void makeFragmentTransaction(Fragment nextFragment) {

        Log.i("TAG", "makeFragmentTransaction: ");

        if (nextFragment != null && currentFragment.getClass() != nextFragment.getClass()){
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_layout_activity_main_fragment, nextFragment)
                    .commit();

            currentFragment = nextFragment ;
        }

    }

    private void addFragmentTransaction(Fragment currentFragment) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.frame_layout_activity_main_fragment, currentFragment)
                    .commit();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        FragmentManager fm = getSupportFragmentManager();

        if(fm.getBackStackEntryCount()>=2) {
            String selectedText = fm.getBackStackEntryAt((fm.getBackStackEntryCount() - 2)).getName();
            actionBarMain.setTitle(selectedText);
        }else if (fm.getBackStackEntryCount() == 1){
            super.onBackPressed() ;
        }

    }
}


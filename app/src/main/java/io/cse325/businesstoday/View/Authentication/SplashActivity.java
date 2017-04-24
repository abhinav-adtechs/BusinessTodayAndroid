package io.cse325.businesstoday.View.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.github.ybq.android.spinkit.SpinKitView;

import io.cse325.businesstoday.R;
import io.cse325.businesstoday.View.CustomViews.BaseActivity;
import io.cse325.businesstoday.View.Feed.MainActivity;


public class SplashActivity extends BaseActivity {

    private SpinKitView spinKitView ;
    private Intent intent  ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        uiInit() ;

        intent = new Intent(this, LoginActivity.class) ;

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        }, 2000) ;
    }

    private void uiInit() {
        spinKitView = (SpinKitView) findViewById(R.id.spinkit_activity_splash_loading) ;
    }

    @Override
    protected void onResume() {
        super.onResume();

        getSupportActionBar().hide();
    }
}

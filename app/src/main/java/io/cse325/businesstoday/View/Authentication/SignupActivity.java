package io.cse325.businesstoday.View.Authentication;

import android.os.Bundle;
import android.support.annotation.Nullable;

import io.cse325.businesstoday.R;
import io.cse325.businesstoday.View.CustomViews.BaseActivity;



public class SignupActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);
    }
}

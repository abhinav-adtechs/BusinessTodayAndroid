package io.cse325.businesstoday.View.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import io.cse325.businesstoday.R;
import io.cse325.businesstoday.View.CustomViews.BaseActivity;
import io.cse325.businesstoday.View.Feed.MainActivity;


public class SignupActivity extends BaseActivity implements View.OnClickListener{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);

        uiInit() ;
    }

    private void uiInit() {

        findViewById(R.id.btn_activity_signup_signin).setOnClickListener(this);
        findViewById(R.id.btn_activity_signup_register).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_activity_signup_signin:
                startActivity(new Intent(this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
                break;
            case R.id.btn_activity_signup_register:
                startActivity(new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
                break;

        }
    }
}

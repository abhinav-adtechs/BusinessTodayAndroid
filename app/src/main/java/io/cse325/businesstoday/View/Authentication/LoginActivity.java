package io.cse325.businesstoday.View.Authentication;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import io.cse325.businesstoday.R;
import io.cse325.businesstoday.View.CustomViews.BaseActivity;
import io.cse325.businesstoday.View.Feed.MainActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private Button btnLogin ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        uiInit() ;
    }

    @Override
    protected void onResume() {
        super.onResume();

        getSupportActionBar().hide();
    }


    private void uiInit() {

        btnLogin = (Button) findViewById(R.id.btn_activity_login_loginbtn) ;
        btnLogin.setOnClickListener(this);
        findViewById(R.id.btn_activity_login_signupbtn).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_activity_login_loginbtn :
                Intent intent = new Intent(this, MainActivity.class) ;
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY|Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
                startActivity(intent);
                finish();
                break;

            case R.id.btn_activity_login_signupbtn:
                Intent intent1 = new Intent(this, SignupActivity.class) ;
                intent1.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY) ;
                startActivity(intent1);
                break;

        }
    }
}

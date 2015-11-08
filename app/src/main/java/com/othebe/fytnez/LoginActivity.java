package com.othebe.fytnez;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.login.widget.LoginButton;
import com.othebe.fytnez.facebook.LoginButtonHelper;

public class LoginActivity extends AppCompatActivity {
  private LoginButtonHelper _facebookLoginButtonHelper;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_login);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    // Setup Facebook login button.
    LoginButton facebookLoginButton = (LoginButton) findViewById(R.id.fb_login_button);
    LoginButtonHelper.getCallbackManager(facebookLoginButton).onActivityResult(
        requestCode, resultCode, data);
  }
}

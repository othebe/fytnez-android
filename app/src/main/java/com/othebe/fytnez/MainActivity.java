package com.othebe.fytnez;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.othebe.fytnez.onboarding.OnboardingActivity;

/**
 * This class routes the application to either the login or Fytnez code.
 */
public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    final MainActivity self = this;
    FacebookSdk.sdkInitialize(getApplicationContext(), new FacebookSdk.InitializeCallback() {
      @Override
      public void onInitialized() {
        // Choose starting activity.
        self.startActivity(new Intent(self.getApplicationContext(),
            this._requiresLogin() ? LoginActivity.class : OnboardingActivity.class));
      }

      /**
       * Determines if a login is required.
       */
      private boolean _requiresLogin() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if (accessToken == null) {
          return true;
        } else {
          return accessToken.isExpired();
        }
      }
    });
  }
}

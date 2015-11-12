package com.othebe.fytnez;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.othebe.fytnez.onboarding.OnboardingActivity;
import com.othebe.fytnez.onboarding.models.OnboardingModel;
import com.othebe.fytnez.profile.ProfileActivity;

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
        // Choose starting class.
        Class intentClass = null;
        if (this._requiresLogin()) {
          intentClass = LoginActivity.class;
        }
        else if (this._requiresOnboarding()) {
          intentClass = OnboardingActivity.class;
        }
        else {
          intentClass = ProfileActivity.class;
        }

        self.startActivity(new Intent(self.getApplicationContext(), intentClass));
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

      /**
       * Determines if an onboarding is required.
       */
      private boolean _requiresOnboarding() {
        return OnboardingModel.getOnboardingData() == null;
      }
    });
  }
}

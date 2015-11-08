package com.othebe.fytnez.facebook;

import android.app.Activity;
import android.content.Intent;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by otheb on 11/1/2015.
 */
public class LoginButtonHelper {
  /**
   * Register a Facebook login button by binding callbacks.
   * @param loginButton Facebook login button to setup for callback.
   */
  public static CallbackManager getCallbackManager(LoginButton loginButton) {
    CallbackManager callbackManager = CallbackManager.Factory.create();
    loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
      @Override
      public void onSuccess(LoginResult loginResult) {

      }

      @Override
      public void onCancel() {

      }

      @Override
      public void onError(FacebookException error) {

      }
    });

    return callbackManager;
  }
}

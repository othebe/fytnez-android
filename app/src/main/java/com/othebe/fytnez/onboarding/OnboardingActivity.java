package com.othebe.fytnez.onboarding;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.othebe.fytnez.R;
import com.othebe.fytnez.onboarding.fragments.ExerciseFrequency;
import com.othebe.fytnez.onboarding.fragments.FitnessGoals;
import com.othebe.fytnez.onboarding.fragments.FitnessLevel;
import com.othebe.fytnez.profile.ProfileActivity;

public class OnboardingActivity extends AppCompatActivity implements IOnboardingStepListener {
  private final int MAX_ONBOARDING_STEP = 2;
  private int _onboardingStep;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this._onboardingStep = 0;

    setContentView(R.layout.activity_onboarding);

    this._handleNextButton();

    this._loadOnboardingFragment();
  }

  /**
   * Handle next button click.
   */
  private void _handleNextButton() {
    final OnboardingActivity self = this;
    Button nextButton = (Button) findViewById(R.id.onboarding__next);
    View.OnClickListener onClickListener = new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        self._nextOnboardingStep();
      }
    };
    nextButton.setOnClickListener(onClickListener);
  }

  /**
   * Next onboarding step.
   */
  private void _nextOnboardingStep() {
    this._onboardingStep++;
    if (this._onboardingStep > MAX_ONBOARDING_STEP) {
      this._finishOnboarding();
      return;
    }

    this.setNextEnabled(false);
    this._setProgressBar();
    this._loadOnboardingFragment();
    this._changeNextToFinishIfLast();
  }

  /**
   * Set progress bar.
   */
  private void _setProgressBar() {
    ProgressBar progressBar = (ProgressBar) findViewById(R.id.onboarding__progress_bar);
    progressBar.setProgress(this._onboardingStep + 1);
  }

  /**
   * Load an onboarding step fragment.
   */
  private void _loadOnboardingFragment() {
    Fragment onboardingStepFragment = null;

    switch(this._onboardingStep) {
      case 0:
        onboardingStepFragment = new FitnessLevel();
        break;
      case 1:
        onboardingStepFragment = new ExerciseFrequency();
        break;
      case 2:
        onboardingStepFragment = new FitnessGoals();
        break;
    }

    FragmentManager fragmentManager = this.getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    if (this._onboardingStep == 0) {
      fragmentTransaction.add(R.id.onboarding__data_container, onboardingStepFragment);
    } else {
      fragmentTransaction.replace(R.id.onboarding__data_container, onboardingStepFragment);
    }
    fragmentTransaction.commit();
  }

  /**
   * Possibly change the next button to say finish if at the last step.
   */
  private void _changeNextToFinishIfLast() {
    if (this._onboardingStep == MAX_ONBOARDING_STEP) {
      Button nextButton = (Button) findViewById(R.id.onboarding__next);
      nextButton.setText(R.string.finish);
    }
  }

  /**
   * Load post-onboarding activity.
   */
  private void _finishOnboarding() {
    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
  }

  @Override
  public void setNextEnabled(boolean isEnabled) {
    Button nextButton = (Button) findViewById(R.id.onboarding__next);
    nextButton.setEnabled(isEnabled);
  }
}

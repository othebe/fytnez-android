package com.othebe.fytnez.onboarding.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioGroup;

import com.othebe.fytnez.R;
import com.othebe.fytnez.onboarding.IOnboardingStepListener;
import com.othebe.fytnez.onboarding.OnboardingActivity;

/**
 * This fragment gathers the user's fitness level.
 */
public class FitnessLevel extends Fragment {
  private IOnboardingStepListener _onboardingStepListener;
  private View _view;

  public FitnessLevel() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_fitness_level, container, false);
  }

  @Override
  public void onAttach(Activity activity) {
    super.onAttach(activity);
    try {
      this._onboardingStepListener = (IOnboardingStepListener) activity;
    } catch (ClassCastException e) {
      throw new ClassCastException(activity.toString()
          + " must implement IOnboardingStepListener");
    }
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    this._view = view;

    this._setOptionHandlers();
  }

  /**
   * Set handlers for the radio buttons.
   */
  private void _setOptionHandlers() {
    final FitnessLevel self = this;
    RadioGroup radioGroup = (RadioGroup) this._view.findViewById(
        R.id.onboarding__fitness_level);
    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(RadioGroup group, int checkedId) {
        self._onboardingStepListener.setNextEnabled(true);
      }
    });
  }
}

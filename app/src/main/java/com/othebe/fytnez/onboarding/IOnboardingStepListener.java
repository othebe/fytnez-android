package com.othebe.fytnez.onboarding;

/**
 * This interface contains methods to communicate between the onboarding activity and onboarding
 * step fragments.
 */
public interface IOnboardingStepListener {
  /**
   * Enables or disables the next button.
   * @param isEnabled Determines if the next button is enabled.
   */
  public void setNextEnabled(boolean isEnabled);
}

package com.othebe.fytnez.profile.models;

import com.facebook.Profile;

/**
 * Created by otheb on 11/12/2015.
 */
public class ProfileModel {
  private String _firstName;
  private String _lastName;
  private String _facebookId;

  /**
   * Lookup current profile using a Facebook ID as the identifier.
   * @return ProfileModel
   */
  public static ProfileModel getCurrentProfileUsingFacebook() {
    Profile profile = Profile.getCurrentProfile();

    // TODO (othebe): Check local storage.
    ProfileModel profileModel = new ProfileModel();
    profileModel.setFirstName(profile.getFirstName());
    profileModel.setLastName(profile.getLastName());

    return profileModel;
  }

  /**
   * Set first name.
   * @param firstName
   */
  public void setFirstName(String firstName) {
    this._firstName = firstName;
  }

  /**
   * Get first name.
   * @return String
   */
  public String getFirstName() {
    return this._firstName;
  }

  /**
   * Set last name.
   * @param lastName
   */
  public void setLastName(String lastName) {
    this._lastName = lastName;
  }

  /**
   * Get last name.
   * @return
   */
  public String getLastName() {
    return this._lastName;
  }
}

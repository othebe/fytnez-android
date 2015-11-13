package com.othebe.fytnez.profile;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.facebook.Profile;
import com.othebe.fytnez.R;
import com.othebe.fytnez.layout.fragments.Footer;
import com.othebe.fytnez.profile.models.ProfileModel;

public class ProfileActivity extends AppCompatActivity {
  private ProfileModel _profileModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    this._profileModel = ProfileModel.getCurrentProfileUsingFacebook();

    setContentView(R.layout.activity_profile);

    this._populateView();
    this._addFooter();
  }

  /**
   * Add footer.
   */
  private void _addFooter() {
    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
    fragmentTransaction.add(R.id.profile__footer_container, new Footer());
    fragmentTransaction.commit();
  }

  /**
   * Populate view.
   */
  private void _populateView() {
    // Set name.
    String name = this._profileModel.getFirstName();
    String lastName = this._profileModel.getLastName();
    name += (lastName == null) ? "" : lastName;
    TextView nameTextView = (TextView) findViewById(R.id.profile_content__name);
    nameTextView.setText(name);
  }
}

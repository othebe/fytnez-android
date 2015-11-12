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

import com.othebe.fytnez.R;
import com.othebe.fytnez.layout.fragments.Footer;

public class ProfileActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile);

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
}

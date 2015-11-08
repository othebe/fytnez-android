package com.othebe.fytnez.layout.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.othebe.fytnez.R;

/**
 * This represents the app footer.
 */
public class Footer extends Fragment {
  public Footer() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_footer, container, false);
  }


}

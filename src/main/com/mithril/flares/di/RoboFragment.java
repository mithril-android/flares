package com.mithril.flares.di;

import android.app.Fragment;
import android.os.Bundle;
import roboguice.RoboGuice;

public class RoboFragment extends Fragment {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    RoboGuice.getInjector(this.getActivity()).injectMembersWithoutViews(this);
  }
}

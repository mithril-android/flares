package com.mithril.flares.di;

import android.app.ListFragment;
import android.os.Bundle;
import roboguice.RoboGuice;

public class RoboListFragment extends ListFragment {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    RoboGuice.getInjector(this.getActivity()).injectMembersWithoutViews(this);
  }

}

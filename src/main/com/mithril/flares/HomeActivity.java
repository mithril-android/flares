package com.mithril.flares;

import android.os.Bundle;
import com.google.inject.Inject;
import roboguice.activity.RoboActivity;

public class HomeActivity extends RoboActivity {

  @Inject
  private FragmentDocker docker;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.home);

  }

  @Override
  protected void onResume() {
    super.onResume();
    docker.dockInitial();

  }
}


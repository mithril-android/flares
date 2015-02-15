package com.mithril.flares;

import android.app.Application;
import com.mithril.flares.di.CustomRoboModule;
import roboguice.RoboGuice;

public class FlaresApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    RoboGuice.setBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE,
      RoboGuice.newDefaultRoboModule(this), new CustomRoboModule());
  }
}

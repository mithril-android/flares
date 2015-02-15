package com.mithril.flares.di;

import android.app.FragmentManager;
import com.google.inject.AbstractModule;

public class CustomRoboModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(FragmentManager.class).toProvider(FragmentManagerProvider.class);
  }
}

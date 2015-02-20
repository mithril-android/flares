package com.mithril.flares.di;

import android.app.FragmentManager;
import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import org.skk.tide.EventBus;

import javax.inject.Scope;

public class CustomRoboModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(FragmentManager.class).toProvider(FragmentManagerProvider.class);
    bind(EventBus.class).toProvider(EventBusProvider.class).asEagerSingleton();
  }
}

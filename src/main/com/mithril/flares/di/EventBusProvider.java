package com.mithril.flares.di;

import com.google.inject.Provider;
import org.skk.tide.EventBus;

public class EventBusProvider implements Provider<EventBus> {
  @Override
  public EventBus get() {
    return EventBus.getInstance();
  }
}

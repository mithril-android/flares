package com.mithril.flares.event;

import org.skk.tide.Event;

public class FetchComplete extends Event {
  public Event withData(String s) {
    AllGameData allGameData = new AllGameData(s);
    return withData(allGameData);
  }
}

package com.mithril.flares;

import android.app.FragmentManager;
import com.google.inject.Inject;

/**
 * Docker:
 * noun
 * a person employed in a port to load and unload ships.
 * This guy loads and unloads fragments
 */
public class FragmentDocker {

  private FragmentManager manager;

  @Inject
  public FragmentDocker(FragmentManager manager){

    this.manager = manager;
  }

}
    
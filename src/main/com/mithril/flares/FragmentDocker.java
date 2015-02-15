package com.mithril.flares;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
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


  public void dockDefault(){
    GameListFragment gameListFragment = new GameListFragment();

    FragmentTransaction fragmentTransaction = manager.beginTransaction();

    fragmentTransaction.add(R.id.fragment_container, gameListFragment);
    fragmentTransaction.addToBackStack(null);

    fragmentTransaction.commit();
  }

}
    
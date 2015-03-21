package com.mithril.flares;

import android.app.Fragment;
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


  public void dockInitial(){
    WisdomFragment fragment = new WisdomFragment();

    dockFragment(fragment, false);
  }

  private void dockFragment(Fragment fragment, boolean addToBackstack) {
    FragmentTransaction fragmentTransaction = manager.beginTransaction();

    fragmentTransaction.replace(R.id.fragment_container, fragment);

    if(addToBackstack)
      fragmentTransaction.addToBackStack(null);

    fragmentTransaction.commit();
  }

  public void dockStarter(){
    GameListFragment fragment = new GameListFragment();

    dockFragment(fragment, false);
  }

}
    
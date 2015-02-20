package com.mithril.flares;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.inject.Inject;
import com.mithril.flares.di.RoboListFragment;

public class GameListFragment extends RoboListFragment {

  @Inject
  private GameListAdaptor adaptor;

  @Inject
  private GameService service;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View inflate = inflater.inflate(R.layout.game_list, null);

    service.fetchAllGames();
    setListAdapter(adaptor);
    return inflate;
  }
}

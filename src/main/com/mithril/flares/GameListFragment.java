package com.mithril.flares;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.google.inject.Inject;
import com.mithril.flares.di.RoboListFragment;

import static com.mithril.flares.R.layout;

public class GameListFragment extends RoboListFragment {

  @Inject
  private GameListAdaptor adaptor;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View inflate = inflater.inflate(R.layout.game_list, null);


    setListAdapter(adaptor);
    return inflate;
  }
}

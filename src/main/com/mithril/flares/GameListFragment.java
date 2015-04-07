package com.mithril.flares;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import com.google.inject.Inject;
import com.mithril.flares.di.RoboFragment;
import com.mithril.flares.di.RoboListFragment;

public class GameListFragment extends RoboFragment implements AdapterView.OnItemClickListener, TextWatcher {

  @Inject
  private GameListAdaptor adaptor;

  @Inject
  private GameService service;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View inflate = inflater.inflate(R.layout.game_list, null);

    ListView listView = (ListView) inflate.findViewById(R.id.game_list_view);
    listView.setAdapter(adaptor);
    listView.setOnItemClickListener(this);

    EditText searchGame = (EditText) inflate.findViewById(R.id.searchGame);
    searchGame.addTextChangedListener(this);

    service.fetchAllGames();

    return inflate;
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }


  @Override
  public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

  }

  @Override
  public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

  }

  @Override
  public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    adaptor.filter(charSequence.toString());
  }

  @Override
  public void afterTextChanged(Editable editable) {

  }
}

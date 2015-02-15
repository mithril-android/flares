package com.mithril.flares;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.inject.Inject;

public class GameListAdaptor extends BaseAdapter {

  private Context context;

  @Inject
  public GameListAdaptor(Context context){

    this.context = context;
  }

  private String[] games = new String[] {"Assassin's Creed 1", "Assassin's Creed 2", "Assassin's Creed 3", "Assassin's Creed 4", "Assassin's Creed 5", "Assassin's Creed 6", "Assassin's Creed 7", "Assassin's Creed 8: Liberations", "Assassin's Creed 9: Kishore", "Assassin's Creed 10: Sandeep" };


  @Override
  public int getCount() {
    return games.length;
  }

  @Override
  public Object getItem(int i) {
    return games[i];
  }

  @Override
  public long getItemId(int i) {
    return 0;
  }

  @Override
  public View getView(int i, View view, ViewGroup viewGroup) {
    LayoutInflater inflater = LayoutInflater.from(context);
    view = inflater.inflate(R.layout.game_list_item, null);

    TextView gameItem = (TextView) view.findViewById(R.id.game_item);

    gameItem.setText(games[i]);

    return view;
  }
}

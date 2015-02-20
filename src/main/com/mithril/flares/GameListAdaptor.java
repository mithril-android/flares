package com.mithril.flares;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.inject.Inject;
import com.mithril.flares.domain.Game;
import com.mithril.flares.event.AllGameData;
import com.mithril.flares.event.FetchComplete;
import org.skk.tide.EventBus;
import org.skk.tide.EventHandler;
import org.skk.tide.HandleEvent;

import java.util.ArrayList;

public class GameListAdaptor extends BaseAdapter implements EventHandler {

  private Context context;

  private EventBus bus;


  @Inject
  public GameListAdaptor(Context context, EventBus bus){

    this.context = context;
    this.bus = bus;

    bus.register(this, FetchComplete.class);
  }

  private String[] games = new String[] {"Loading, please wait."};

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
    if(view == null)
      view = inflater.inflate(R.layout.game_list_item, null);

    TextView gameItem = (TextView) view.findViewById(R.id.game_item);

    gameItem.setText(games[i]);

    return view;
  }

  @HandleEvent(eventType = FetchComplete.class)
  public void handleData(AllGameData data){
    ArrayList<Game> allGames = data.getAllGames();
    ArrayList<String> strings = new ArrayList<String>();
    for(Game game : allGames){
      strings.add(game.getName());
    }

    games = strings.toArray(games);
    notifyDataSetChanged();
  }
}

package com.mithril.flares;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.inject.Inject;
import com.mithril.flares.domain.Game;
import com.mithril.flares.event.AllGameData;
import com.mithril.flares.event.FetchComplete;
import com.squareup.picasso.Picasso;
import org.skk.tide.EventBus;
import org.skk.tide.EventHandler;
import org.skk.tide.HandleEvent;

import java.io.IOException;
import java.util.ArrayList;

public class GameListAdaptor extends BaseAdapter implements EventHandler {

  private Context context;

  @Inject
  public GameListAdaptor(Context context, EventBus bus){

    this.context = context;
    games = new Game[]{};

    bus.register(this, FetchComplete.class);
  }

  private Game[] games;

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

    String imageUrl = games[i].getImageUrl();

    TextView gameItem = (TextView) view.findViewById(R.id.game_item);
    ImageView imageView = (ImageView) view.findViewById(R.id.game_image);

    gameItem.setText(games[i].getName());
    Picasso.with(context).load(imageUrl).into(imageView);

    return view;
  }

  @HandleEvent(eventType = FetchComplete.class)
  public void handleData(AllGameData data){
    ArrayList<Game> allGames = data.getAllGames();
    games = allGames.toArray(games);
    notifyDataSetChanged();
  }
}

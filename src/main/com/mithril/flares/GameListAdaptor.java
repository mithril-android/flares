package com.mithril.flares;

import android.content.Context;
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

import java.util.ArrayList;

public class GameListAdaptor extends BaseAdapter implements EventHandler {

  private Context context;

  @Inject
  public GameListAdaptor(Context context, EventBus bus){

    this.context = context;
    filteredList = new ArrayList<Game>();

    bus.register(this, FetchComplete.class);
  }

  private ArrayList<Game> filteredList;
  private ArrayList<Game> allGamesList;

  @Override
  public int getCount() {
    return filteredList.size();
  }

  @Override
  public Object getItem(int i) {
    return filteredList.get(i);
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

    String imageUrl = filteredList.get(i).getImageUrl();

    TextView gameItem = (TextView) view.findViewById(R.id.game_item);
    ImageView imageView = (ImageView) view.findViewById(R.id.game_image);

    gameItem.setText(filteredList.get(i).getName());
    Picasso.with(context).load(imageUrl).into(imageView);

    return view;
  }

  public void filter(String searchString){
    filteredList.clear();

    for(Game game : allGamesList){
      if(game.getName().toLowerCase().startsWith(searchString.toLowerCase()))
        filteredList.add(game);
    }


    notifyDataSetChanged();
  }


  @HandleEvent(eventType = FetchComplete.class)
  public void handleData(AllGameData data){
    allGamesList = data.getAllGames();
    filter("");
  }
}

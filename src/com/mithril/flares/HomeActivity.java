package com.mithril.flares;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.home_layout);

    String[] games = new String[] {"Assassin's Creed 1", "Assassin's Creed 2", "Assassin's Creed 3", "Assassin's Creed 4", "Assassin's Creed 5", "Assassin's Creed 6", "Assassin's Creed 7", "Assassin's Creed 8: Liberations", "Assassin's Creed 9: Kishore", "Assassin's Creed 10: Sandeep" };

    ListView gamesListView = (ListView) findViewById(R.id.game_list_view);

    gamesListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, games));
  }
}

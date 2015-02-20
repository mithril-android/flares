package com.mithril.flares.event;

import com.google.gson.Gson;
import com.mithril.flares.domain.Game;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.skk.tide.EventData;

import java.util.ArrayList;

public class AllGameData implements EventData {

  private String rawData;

  public AllGameData(String rawData) {

    this.rawData = rawData;

  }

  public ArrayList<Game> getAllGames() {

    ArrayList<Game> games = new ArrayList<Game>();

    try {
      JSONObject jsonObject = new JSONObject(rawData);
      JSONArray jsonArray = jsonObject.getJSONArray("games");

      for (int i = 0; i < jsonArray.length(); i++) {
        String o = jsonArray.getString(i);

        Game game = new Gson().fromJson(o, Game.class);


        games.add(game);
      }



    } catch (JSONException e) {
      e.printStackTrace();
    }


    return games;
  }
}

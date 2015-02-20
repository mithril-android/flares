package com.mithril.flares;

import com.google.inject.Inject;
import org.skk.tide.EventBus;

public class GameService {

  private GateKeeper keeper;


  @Inject
  public GameService(GateKeeper keeper){

    this.keeper = keeper;
  }

  public void fetchAllGames(){

    keeper.sendRequest("http://10.0.2.2:8000/api/games");
  }
}

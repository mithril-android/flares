package com.mithril.flares;

import com.google.inject.Inject;

public class GameService {

  private GateKeeper keeper;

  @Inject
  public GameService(GateKeeper keeper){

    this.keeper = keeper;
  }

  public void getAllGames(){
    keeper.sendRequest("http://localhost/game/all");
  }
}

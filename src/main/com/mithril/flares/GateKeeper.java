package com.mithril.flares;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GateKeeper extends AsyncTask<String, String, String>{

  public void sendRequest(String apiUrl){

    try {
      URL url = new URL(apiUrl);

      HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

      BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());

      bufferedInputStream.read();
    }
    catch (Exception e){

    }
  }

  @Override
  protected String doInBackground(String... strings) {


    return null;
  }


}

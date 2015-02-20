package com.mithril.flares;

import android.os.AsyncTask;
import com.google.inject.Inject;
import com.mithril.flares.event.FetchComplete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.skk.tide.EventBus;
import org.skk.tide.HandlerMethodNotFoundException;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;

public class GateKeeper {

  private EventBus bus;

  @Inject
  public GateKeeper(EventBus bus) {
    this.bus = bus;
  }

  public void sendRequest(String apiUrl){
    new FetchDataAsync().execute(apiUrl);
  }

  private class FetchDataAsync extends AsyncTask<String, String, String>{

    @Override
    protected String doInBackground(String... strings) {
      try {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet(strings[0]);

        BasicResponseHandler basicResponseHandler = new BasicResponseHandler();

        String execute = defaultHttpClient.execute(httpGet, basicResponseHandler);

        return execute;
      }
      catch (Exception e){
        e.printStackTrace();
      }

      return null;
    }

    @Override
    protected void onPostExecute(String s) {

      super.onPostExecute(s);

      try {
        bus.raiseEvent(new FetchComplete().withData(s));

      } catch (InvocationTargetException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (HandlerMethodNotFoundException e) {
        e.printStackTrace();
      }
    }
  }
}

package com.mithril.flares;


import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.inject.Inject;
import com.mithril.flares.di.RoboFragment;
import com.mithril.flares.domain.Quote;
import com.mithril.flares.domain.Wisdom;

public class WisdomFragment extends RoboFragment implements View.OnTouchListener {

  @Inject
  private Wisdom wisdom;

  @Inject
  private FragmentDocker docker;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View inflate = inflater.inflate(R.layout.wisdom, null);

    TextView quoteText = (TextView) inflate.findViewById(R.id.quoteText);
    TextView quoteAuthor = (TextView) inflate.findViewById(R.id.quoteAuthor);

    Quote quote = wisdom.get();
    quoteText.setText("“" + quote.getTheQuote() + "“");
    quoteAuthor.setText(" - " + quote.getAuthor());

    Typeface indieFlowerFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/IndieFlower.ttf");

    quoteText.setTypeface(indieFlowerFont);
    quoteAuthor.setTypeface(indieFlowerFont);


    inflate.setOnTouchListener(this);
    return inflate;
  }


  @Override
  public boolean onTouch(View view, MotionEvent motionEvent) {

    docker.dockStarter();
    return false;
  }
}

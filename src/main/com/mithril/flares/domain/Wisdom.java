package com.mithril.flares.domain;

public class Wisdom {


  public Quote get(){

    Quote[] quotes = Quote.allQuotes();

    int v = (int) (Math.random() * (quotes.length - 1));

    return quotes[v];

  }
}

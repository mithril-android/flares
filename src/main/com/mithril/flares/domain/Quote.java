package com.mithril.flares.domain;

public class Quote {
  public static Quote Default = new Quote("Of all creatures that breathe and move upon the earth, nothing is bred that is weaker than man.", "Homer, The Odyssey");
  private final String theQuote;
  private final String author;

  public Quote(String theQuote, String author) {

    this.theQuote = theQuote;
    this.author = author;
  }

  @Override
  public String toString() {
    return "“" + theQuote + "”";
  }

  public String getTheQuote() {
    return theQuote;
  }

  public String getAuthor() {
    return author;
  }

  public static Quote[] allQuotes(){
    Quote quote = new Quote("The mind can be a powerful ally, or your greatest enemy", "A Wise person");
    Quote quote1 = new Quote("Man is least himself when he talks in his own person. Give him a mask, and he will tell you the truth.", "Oscar Wilde");
    Quote quote2 = new Quote("We are told to remember the idea, not the man, because a man can fail. He can be caught, he can be killed and forgotten, but 400 years later, an idea can still change the world.", "Evey Hammond, V");
    Quote quote3 = new Quote(" Beneath this mask there is more than flesh. Beneath this mask there is an idea, Mr. Creedy. And ideas are bulletproof.", "V");
    Quote quote4 = new Quote(" The True Mind can wither all the lies and illusions without being lost. The True Heart can tough the poison of hatred without being harmed. Since beginningless time, Darkness thrives in the void but always yields to purifying Light.", "The Lion Turtle");
    Quote quote5 = new Quote("You reap what you sow. Force answers force, war breeds war, and death only brings death. To break this vicious circle one must do more than act without any thought or doubt.", "Khan, Metro 2033");

    Quote quote6 = new Quote("Of all creatures that breathe and move upon the earth, nothing is bred that is weaker than man.", "Homer, The Odyssey");
    Quote quote7 = new Quote("choose wisely, for while the true Grail will bring you life, the false Grail will take it from you.", "Grail Knight");
    Quote[] quotes = {quote, quote1, quote2, quote3, quote4, quote5, quote6, quote7};

    return quotes;
  }
}
//
//("The mind can be a powerful ally, or your greatest enemy", "A Wise person");

//“Of all creatures that breathe and move upon the earth, nothing is bred that is weaker than man.”
//
//
//  ― Homer, The Odyssey

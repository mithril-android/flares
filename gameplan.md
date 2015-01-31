# Game Plan

**Game** - describes the game

**Gamer** - describes the person associated with instance of the app running(aka logged in user)  
    -> has many <- **Game**  
    -> has many <- **Gamer** as friends  
 	
**TheQuoteGuy** - gives a random quote, gives a random quote for a given game.  
**GameMaster** - gives the list of games  
**GamerQueen** - gives info about a given gamer.  

As a gamer, I want to see a list of all games available in the world,  
so that I can add them to my list.

As a gamer, I want to add another gamer as my friend, so that I can  
see all the games they have in their list.

As a gamer, I want to mark the current status of my game in my game list,  
so that my friends can see them.

As a gamer, I want to see a game suggestion list based on my list, fron people of similar taste,  
so that I can play  them.

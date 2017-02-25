package proj3sp15;
/**
 * <p>Title: The Project3 Application class</p>
 *
 * <p>Description: This class is written for testing method in the Deck class
 * by crating Deck object in difference (default size, small size, large size, 
 * and empty size) testing the methods on each object. Also, testing method in 
 * DiscardPile (addCard, removeCards, removeCard, isEmpty, size, and toString) </p>
 * 
 * @author <Thita Charoentham>
 */
public class Proj3App {

	public static void main(String[] args) throws DeckException {

		/**
		 * testing crateJoker method--
		 * testing default & parameterized constructor on Deck class
		 * instantiate emptyDeck & someDeck which contains more deck and joker.   
		 */
		Card jokerCard = Card.createJoker();
		System.out.println("Test crateJoker method: \nValue: " + jokerCard.getValue() + "\nSuit: " + jokerCard.getSuit());
		Deck theDeck = new Deck();
		System.out.println("\ntesting default constructor theDeck now contains:\n" + theDeck.toString());
		Deck emptyDeck = new Deck(0,0);
		System.out.println("testing parameterized constructor emtyDeck now contains:\n" + emptyDeck.toString());
		Deck someDeck = new Deck(3,3);
		System.out.println("testing parameterized constructor someDeck now contains:\n" + someDeck.toString());
		Deck smallDeck = new Deck(0,5);
		System.out.println("testing parameterized constructor smallDeck now contains:\n" + smallDeck.toString());

		/**
		 * testing isEmpty method 
		 * in Deck class on emptyDeck, theDeck, someDeck, smallDeck
		 */
		System.out.println("Testing isEmpty method on emptyDeck: " + emptyDeck.isEmpty());
		System.out.println("Testing isEmpty method on theDeck: " + theDeck.isEmpty());
		System.out.println("Testing isEmpty method on someDeck: " + someDeck.isEmpty());
		System.out.println("Testing isEmpty method on smallDeck: " + smallDeck.isEmpty() + "\n");

		
		/** testing shuffleDeck
		 *  on emptyDeck, theDeck, someDeck
		 */
		emptyDeck.shuffleDeck();	
		System.out.println("Testing suffleDeck method on emptyDeck\n" + emptyDeck.toString());
		theDeck.shuffleDeck();
		System.out.println("Testing suffleDeck method on theDeck\n" + theDeck.toString());
		someDeck.shuffleDeck();
		System.out.println("Testing suffleDeck method on someDeck\n" + someDeck.toString());
		
		/** testing dealCard method
		 * on emtyDeck, someDeck, and smallDeck
		 */
		Card aDealCard;
		System.out.println("Testing dealCard method on someDeck deal 150 cards");
		for(int i=0; i<150; i++)
		{
			aDealCard = someDeck.dealCard();
			System.out.println("Deal card " + (i+1) + ": "+ aDealCard.toString());
		}
		try{
			aDealCard = emptyDeck.dealCard();
		}
		catch(DeckException ex){
			System.out.println("\nCalls dealCard method on the empty deck:\n" + ex.getMessage() + "\n");
		}
		while(!smallDeck.isEmpty()){
			aDealCard = smallDeck.dealCard();
			System.out.println("Call dealCard deal the following card from smallDeck: " 
					+ aDealCard.toString());
		}
		System.out.println("\nNow smallDeck is empty: " + smallDeck.isEmpty());

		
		/** testing cut method
		 * on someDeck, theDeck, emptyDeck
		 */
		
		System.out.println("\nsomeDeck now contains:\n" + someDeck.toString());
		someDeck.cut();
		System.out.println("Cut cards on someDeck: " +
				"\n\nNow someDeck contains:\n" + someDeck.toString());
		someDeck.shuffleDeck();
		System.out.println("Shuffle someDeck now contains:\n" + someDeck.toString());
		someDeck.cut();
		System.out.println("Cut cards on someDeck: " +
				"\n\nNow someDeck contains:\n" + someDeck.toString());
		
		System.out.println("\ntheDeck now contains:\n" + theDeck.toString());
		theDeck.cut();
		System.out.println("Cut cards on theDeck: " +
				"\n\nNow someDeck contains:\n" + theDeck.toString());
		
		System.out.println("Calls cut method on emptyDeck:");
		try{ 
			emptyDeck.cut();
		}
		catch(DeckException ex)
		{
			System.out.println(ex.getMessage());
		}
		
		/**
		 * testing dealCard and cut method -- when size is become smaller
		 */
		System.out.println("\nCalls dealCard on someDeck:");
		for(int i=0; i<6; i++)
		{
			aDealCard = someDeck.dealCard();
			System.out.println("Deal card " + (i+1) + ": "+ aDealCard.toString());
		}
		System.out.println("\nsomeDeck now contains:\n" + someDeck.toString());
		someDeck.shuffleDeck();
		System.out.println("Shuffle someDeck now contains:\n" + someDeck.toString());
		someDeck.cut();
		System.out.println("Cut cards on someDeck : " + 
				"\n\nNow someDeck contains:\n" + someDeck.toString());

		/** testing putCardInDeck method
		 * creates array of cards to be put in deck object
		 * try on someDeck, smallDeck, emptyDeck 
		 */
		Card [] cardArray = new Card[5];
		cardArray[0] = new Card(10);
		cardArray[1] = new Card(18);
		cardArray[2] = new Card(21);
		cardArray[3] = new Card(9);
		cardArray[4] = Card.createJoker();

		Card [] tempArray = new Card[2];
		tempArray[0] = new Card(9);
		tempArray[1] = new Card(33);
		
		System.out.println("Array of Card to be put on Deck now contains:");
		System.out.println("1st Card put in is: "+ cardArray[0].toString());
		System.out.println("2nd Card put in is: "+ cardArray[1].toString());
		System.out.println("3rd Card put in is: "+ cardArray[2].toString());
		System.out.println("4th Card put in is: "+ cardArray[3].toString());
		System.out.println("5th Card put in is: "+ cardArray[4].toString());
		
		//testing putCardInDeck on smallDeck which has size small as equal size value 
		System.out.println("\nsmallDeck now contain:\n" + smallDeck);
		smallDeck.putCardsInDeck(cardArray);
		System.out.println("put the those cards from Array of Card in smallDeck now contain:\n" + smallDeck.toString());
		
		Card [] copyOfCardArray = new Card[5];
		copyOfCardArray[0] = new Card(10);
		copyOfCardArray[1] = new Card(18);
		copyOfCardArray[2] = new Card(21);
		copyOfCardArray[3] = new Card(9);
		copyOfCardArray[4] = Card.createJoker();
		
		Card [] copyOfTempArray = new Card[2];
		copyOfTempArray[0] = new Card(9);
		copyOfTempArray[1] = new Card(33);
		
		someDeck.putCardsInDeck(copyOfCardArray);
		System.out.println("\nputCardsInDeck put those cards from Array of Card in someDeck now contain:\n" + someDeck.toString());
		//testing putCardInDeck on the Deck which is empty
		System.out.println("Testing putCardsInDeck method on emptyDeck which is empty: " + emptyDeck.isEmpty());
		try{
			emptyDeck.putCardsInDeck(copyOfTempArray);
			System.out.println(emptyDeck);
		}
		catch(DeckException ex){
			System.out.println(ex.getMessage());
		}
		//testing putCardInDeck when put card grater thanDeck size
		System.out.println("\nTesting putCardsInDeck method when theDeck which is full:"); 
		try{
			theDeck.putCardsInDeck(tempArray);
		}
		catch(DeckException ex){
			System.out.println(ex.getMessage());
		}

		/**testing DiscardPile
		 * instantiate object for testing
		 */
		DiscardPile aPile = new DiscardPile();
		Card card1 = Card.createJoker();
		Card card2 = new Card (11);
		Card card3 = new Card (12);
		Card card4 = new Card (13);
		Card card5 = new Card (10);
		Card card6 = new Card (22);
		Card card7 = new Card (4);
		Card card8 = new Card (7);
		Card card9 = Card.createJoker();
		
		/**
		 * testing isEmty method
		 */
		System.out.println("\n\n\nTesting DiscardPile class methods:");
		System.out.println("\nCall isEmpty on aPile which now empty :\nisEmpty: " + aPile.isEmpty());
		System.out.println("Now aPile contains:\n" + aPile.toString() + "aPile size is : " + aPile.size());

		/**
		 * testing addCard method
		 */
		aPile.addCard(card1);
		aPile.addCard(card2);
		aPile.addCard(card3);
		
		System.out.println("\nAdd cards to aPile Now contains:\n" + aPile.toString()
				+ "aPile size is : " + aPile.size() + 
				"\nCall isEmpty on aPile which now have 3 cards isEmpty: " + aPile.isEmpty());
		
		/**
		 * testing removeCard method
		 * removeCard until aPile is empty, try catch when the method get call when is empty
		 */
		while(!aPile.isEmpty())
		{
			aPile.removeCard();
			System.out.println("\nCalls removeCard remove one card on aPile Now aPile contains:\n" 
				+ aPile.toString() + "aPile size is : " + aPile.size());
		}
		try{
			System.out.println("\nCalls removeCard one card on aPile which now empty:");
			aPile.removeCard();
		}
		catch(DiscardPileException ex){
			System.out.println(ex.getMessage());
		}

		aPile.addCard(card1);
		aPile.addCard(card2);
		aPile.addCard(card3);
		aPile.addCard(card4);
		aPile.addCard(card5);
		aPile.addCard(card6);
		aPile.addCard(card7);
		aPile.addCard(card8);
		aPile.addCard(card9);
		
		System.out.println("\nCalls addCard added 9 cards to aPile Now contains:\n" + aPile.toString() 
				+ "aPile size is : " + aPile.size() + "\nisEmpty: " + aPile.isEmpty());
		
		/**
		 * testing removeCards method
		 * try catch when argument larger than number of card in aPile,
		 * tests small and equal number of card in aPile
		 */
		try{
			System.out.println("\nCalls removeCards sent 10 as an argument which number grater than aPile size:\n"
					+ "aPile size is : " + aPile.size());
			aPile.removeCards(10);
		}
		catch(DiscardPileException ex){
			System.out.println(ex.getMessage());
		}
		
		Card[] removeArrayCard = aPile.removeCards(3);
		System.out.println("\nCalls removeCards remove 3 cards aPile Now contains:\n" + aPile.toString()
				+ "aPile size is : " + aPile.size() + "\nThe method will remove the following cards:");
		for(int i=0; i<removeArrayCard.length;i++)
			System.out.println("Card " + (i+1) + " :"+ removeArrayCard[i].toString());
		
		
		System.out.println("\naPile Now contains:\n" + aPile.toString()
				+ "aPile size is : " + aPile.size() + "\nisEmpty: " + aPile.isEmpty());
		removeArrayCard = aPile.removeCards(6);
		System.out.println("\nCalls removeCards remove 6 cards aPile Now contains:\n" + aPile.toString()
				+ "aPile size is : " + aPile.size() + "\nThe method will remove the following cards:");
		for(int i=0; i<removeArrayCard.length;i++)
			System.out.println("Card " + (i+1) + " :"+ removeArrayCard[i].toString());
		
		try{
			System.out.println("\nCalls removeCards when aPile is empty:\naPile now size is: " + aPile.size());
			aPile.removeCards(9);
		}
		catch(DiscardPileException ex){
			System.out.println(ex.getMessage());
		}
	}

}

package proj3sp15;
/**
 * <p>Title: WarApp class</p>
 *
 * <p>Description: This class is written for playing War card game for 2 player.
 * This class creates a deck, shuffle, cut, deal card on the deck of 2 player.
 * Each player have initial card 26. Each round top card face up and compare value,
 * if they are same value is war then compare another cards based on number of card
 * have left in have in hand and determined who is the winner. The game will end
 * when one player have no more card in hand.</p>
 * 
 * @author  <Thita Charoentham>
 */
public class WarApp {

	public static void main(String[] args) throws DeckException{

		/**
		 * creates a deck
		 * shuffle the deck
		 * cut the deck
		 * deal card for 2 players 
		 * initial each player has cards half of the deck
		 * deal top card from each players on DiscardPile object
		 * compare value of card 
		 * if they are tier deal 2 more cards and compare the second card
		 * if the second are tier again deal more 2 cards until get a winner  
		 * else if who have the greater card value will be win
		 * the player who win each round will take all cards from DiscardPile add in hand
		 * when the player have no more card the game end
		 */
		Deck theDeck = new Deck();
		DiscardPile disCard = new DiscardPile();
		WarsHand myHand = new WarsHand();
		WarsHand anotherHand = new WarsHand();
		int numCardInMyHand = 0;
		int numCardInAnotherHand = 0;
		Card temp;
		//Card [] tempArray;

		System.out.println("Creates theDeck now contains:\n" + theDeck);
		// shuffle and cut theDeck
		theDeck.shuffleDeck();
		System.out.println("shuffle theDeck now theDeck now contains:\n" + theDeck);
		System.out.println("\n\ntheDeck now contains:\n" + theDeck);
		System.out.println("deal card from theDeck for the player:\n");

		while(!theDeck.isEmpty())
		{
			temp = theDeck.dealCard();
			myHand.addCard(temp);
			temp = theDeck.dealCard();
			anotherHand.addCard(temp);
			numCardInMyHand++;
			numCardInAnotherHand++;
		}
		// display card in each player hand
		System.out.println("myHand now contains:\n" + myHand);
		System.out.println("yourHand now contains:\n" + anotherHand);
		
		
		/**
		 * start the game 
		 */

		Card myCard;
		Card anotherCard;
		int round = 1;

		while (!myHand.isEmpty() && !anotherHand.isEmpty()) 
		{
			System.out.println("Round:" + round);
			myCard = myHand.dealCard();
			anotherCard = anotherHand.dealCard();
			disCard.addCard(myCard);
			disCard.addCard(anotherCard);
			numCardInMyHand--;
			numCardInAnotherHand--;

			System.out.println("myCard first deal is: " + myCard);
			System.out.println("anotherCard first deal is: " + anotherCard);
			
			while (myHand.areTied(myCard, anotherCard))	// both are equal value
			{
				if (numCardInMyHand >=2 && numCardInAnotherHand >=2 ) // both have card to complete the war
				{
					for (int i=0; i<2; i++)
					{
						myCard = myHand.dealCard();
						anotherCard = anotherHand.dealCard();
						disCard.addCard(myCard);
						disCard.addCard(anotherCard);
						numCardInMyHand--;
						numCardInAnotherHand--;
					}
					System.out.println("myCard secound deal is: " + myCard);
					System.out.println("anotherCard secound deal is: " + anotherCard);
				}
				else if (numCardInMyHand == 1 || numCardInAnotherHand == 1 ) // when have only one card left
				{
					myCard = myHand.dealCard();
					anotherCard = anotherHand.dealCard();
					disCard.addCard(myCard);
					disCard.addCard(anotherCard);
					numCardInMyHand--;
					numCardInAnotherHand--;
					System.out.println("myCard secound deal is: " + myCard);
					System.out.println("anotherCard secound deal is: " + anotherCard);
				}
				else if (numCardInMyHand == 0 || numCardInAnotherHand == 0 )
				{	// when no more card inHand deal card only player who have more card
					if (numCardInMyHand == 0) 
					{ 
						anotherCard = anotherHand.dealCard();
						disCard.addCard(anotherCard);
						numCardInAnotherHand--;
					}
					else if (numCardInAnotherHand == 0)
					{
						myCard = myHand.dealCard();
						disCard.addCard(myCard);
						numCardInMyHand--;
					}
					System.out.println("myCard secound deal is: " + myCard);
					System.out.println("anotherCard secound deal is: " + anotherCard);
				}
			}
			
			if (myHand.moreValue(myCard, anotherCard)) // if myHand has more value
			{
				while(!disCard.isEmpty())
				{
					myHand.addCard(disCard.removeCard());
					numCardInMyHand++;
				}
				System.out.println("Take all cards in myHand!\n");
			}
			else if (!myHand.moreValue(myCard, anotherCard)) // if myHand has less value
			{
				while(!disCard.isEmpty())
				{
					anotherHand.addCard(disCard.removeCard());
					numCardInAnotherHand++;
				}
				System.out.println("Take all cards in anotherHand!\n");
			}

			round++;
			System.out.println("myHand now contains:\n" + myHand);
			System.out.println("anotherHand now contains:\n" + anotherHand);
			
		}

		System.out.println("myHand is empty: " + myHand.isEmpty() + "\nanotherHand is empty: " + anotherHand.isEmpty() + "\n");

		if (anotherHand.isEmpty())
			System.out.println("You win the game!");
		else
			System.out.println("You lose!");
		
	}

}

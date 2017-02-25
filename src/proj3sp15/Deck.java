package proj3sp15;

/**
 * <p>Title: The Deck class</p>
 *
 * <p>Description: This class represents a Deck of 52 playing cards. It
 * gets created in order and then must be shuffled to randomize the order of
 * the cards.  Cards are dealt from the top of the deck.</p>
 * 
 * @author Instructor and <Thita Charoentham>
 */
public class Deck
{
	//instance variables
	private Card[] cards;
	private int numCards;

	/**
	 * default constructor which creates the deck of 52 cards (without Jokers)
	 */
	public Deck()
	{
		numCards = 52;
		cards = new Card[numCards];
		for (int i=0; i<cards.length;i++)
		{
			cards[i] = new Card(i);
		}
	}

	/**
	 * parameterized constructor --
	 * creates the deck and Joker base upon number of deck and joker get input
	 * @param nDeck number of deck
	 * @param nJoker number of Joker
	 */
	public Deck (int nDeck, int nJoker)
	{
		numCards = (52*nDeck) + nJoker;		//total card want to store
		cards = new Card[numCards];			// instantiate new card object

		for (int i=0; i<cards.length-nJoker; i++)	// create card in total minus joker
			cards[i] = new Card(i % 52);

		for (int j=cards.length-nJoker; j < numCards; j++)
			cards[j] = Card.createJoker();
	}

	/**
	 * isEmpty method--
	 * check is the deck contains card object 
	 * @return true if it is empty, false if it has cards  
	 */
	public boolean isEmpty()
	{
		return (numCards < 1);
	}

	/**
	 * shuffleDeck method -- places the cards in the deck in a random order
	 * if has card object stores in the deck 
	 */
	public void shuffleDeck()
	{
		Card temp;
		int ran1, ran2;
		if (numCards>0)
		{
			for (int i=0; i<numCards; i++)
			{
				ran1 = (int)(Math.random()*numCards);
				ran2 = (int)(Math.random()*numCards);
				temp = cards[ran1];
				cards[ran1] = cards[ran2];
				cards[ran2] = temp;
			}
		}
	}

	/**
	 * dealCard -- deals the top card from the deck and decrement the number
	 * of cards in the deck by 1
	 * @return cards which get deal or throw exception if the deck is empty
	 */
	public Card dealCard() throws DeckException
	{
		if (isEmpty())
			throw new DeckException("The deck is empty can not DEAL the card!");
		else
			numCards--;
		return cards[numCards];
	}

	/**
	 * cut method --  random in appropriate number of position get cut
	 * from first card to card which get cut go in the bottom 
	 * card after the card which get cut to the bottom go on top of the first card
	 * @throws DeckException if the deck is empty
	 */
	public void cut() throws DeckException
	{
		int cutCard;
		int j=0;
		Card aCutCard;
		if (isEmpty())
			throw new DeckException("The deck is empty can not CUT the deck!");
		else
		{
			cutCard = (int)(Math.random()*(numCards-1)+1);
			aCutCard = cards[cutCard];
			int pos = (numCards-cutCard);
			Card [] temp = new Card[cutCard];

			for(int i=0;i<cutCard; i++)
				temp[i] = cards[i];

			for(int i=cutCard; i<numCards; i++)
			{
				cards[j] = cards[i];
				j++;
			}
			for(int i=0;i<temp.length; i++)
			{
				cards[pos] = temp[i];
				pos++;
			}
		}
		System.out.println("Cut at card: " + aCutCard.toString());
	}
	
	
	/**
	 * putCardInDeck method -- add one or more than one cards in the deck 
	 * @param temp array cards which want to put in the deck
	 * @throws DeckException if number of card which want to add plus
	 * number grater than cards.length
	 */
	public void putCardsInDeck (Card [] temp) throws DeckException
	{
		int numTemp = 0;
		for (int i=0; i<temp.length; i++) // count how many card 
		{
			if (temp[i] != null)
				numTemp++;
		}
		int total = numCards+numTemp;
		if(total>cards.length) 
			throw new DeckException("The deck is full. Can't add more card.");
		else 
		{
			int j=0;
			while(numTemp!=0)
			{
				for (int i=numCards; i<total; i++)
				{
					cards[i] = temp[j];
					temp[j] = null;
					j++;
					numTemp--;
				}
			}
			numCards = total;
		}
	}
	/**
	 * toString --
	 * returns the state of the deck as a string
	 * @return a string containing the cards currently in the deck
	 */
	public String toString()
	{
		String temp = new String();
		int j=1;
		for (int i=numCards-1; i>=0; i--)
		{
			temp += "Card " + j + ": " + cards[i] + "\n";
			j++;
		}
		return temp;
	}
}

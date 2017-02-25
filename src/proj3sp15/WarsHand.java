package proj3sp15;

/**
 * <p>Title: WarsHand class class</p>
 *
 * <p>Description: This class is written for implement method form the Deck class
 * for playing Wars card game. This class contains method for the player 
 * to be able to addCard & dealCard in hand, size to count how many cards contains in hand, 
 * isEmpty, and toString. Also, it has method to compare values of two cards sameValue, moreValue.</p>
 * 
 * @author <Thita Charoentham>
 */

public class WarsHand {

	Card [] inHand;
	int numCard = 0;

	/**
	 * default constructor--
	 * creates an array size 52, initial numCard equal 0
	 */
	public WarsHand (){
		inHand = new Card[52];
		numCard = 0;		
	}

	/**
	 * parameterized constructor--
	 * creates an array size by user, initial numCard equal 0
	 * @param size of array 
	 */
	public WarsHand (int size){
		inHand = new Card[size];
		numCard = 0;
	}

	/**
	 * addCard method-- 
	 * add card to the array and the end, increment numCard
	 * @param addCard a card want to add
	 * @return newCard the Card added inHand
	 */
	public Card addCard(Card addCard)
	{
		inHand[numCard] = addCard;
		Card newCard = inHand[numCard];
		numCard++;
		return newCard;
	}
	
	/**
	 * dealCard method--
	 * throw exception if isEmty, else return the top card 
	 * @return dealACard the card which get deal
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public Card dealCard() throws ArrayIndexOutOfBoundsException
	{
		Card dealACard;
		if (numCard == 0)
			throw new ArrayIndexOutOfBoundsException("Don't have enough card to deal!");
		else
		{
			dealACard = inHand[0];
			for(int i=0; i<numCard; i++)
				inHand[i] = inHand[i+1];
			numCard--;
		}
		return dealACard;
	}

	/**
	 * isEmpty method--
	 * check card inHand
	 * @return true if not thing inHand, false if have some card
	 */
	public boolean isEmpty()
	{
		return numCard == 0;
	}

	/**
	 * size method--
	 * how many items in hand
	 * @return total of item
	 */
	public int size()
	{
		return numCard;
	}
	
	/**
	 * areTied method --
	 * compare the target card with another card 
	 * @param target first card to be compare
	 * @param another second card to be compare
	 * @return true if they are equal, false if not
	 */
	public boolean areTied (Card target, Card another)
	{
		return (target.getValue() == another.getValue()); 
	}

	/**
	 * moreValue method --
	 * five the grater value of the target and another card 
	 * @param target first card to be compare
	 * @param another second card to be compare
	 * @return true if target > another , false if target < another
	 */
	public boolean moreValue (Card target, Card another)
	{
		return (target.getValue() > another.getValue());
	}

	/**
	 * toString method -- 
	 * returns the state of the card object as a string
	 * @return a reference to a String object that contains the values stored
	 * in the instance variables
	 */
	public String toString()
	{
		String str = new String();
		for(int i=0; i<numCard; i++)
			str += ("Card " + (i+1) + ": " + inHand[i].toString() + "\n");
		return str;
	}
}

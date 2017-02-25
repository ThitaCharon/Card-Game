package proj3sp15;

import java.util.LinkedList;

/**
* <p>Title: DiscardPile Class</p>
*
* <p>Description: This class represents a node connect to another node like a linkListed
* default constructor top node equals to null, parameterized constructor top Node 
* point to card object. It has several method addCard, removeCard, removeCards, size, 
* isEmpty, and toString. The methods implement this class to be able to create another
* node, add more node, remover one node, or more than one node at a time, 
* check number of cards in the linkListed. Also, state of the item of this class.</p>
* 
* * @author <Thita Charoentham>
*/

public class DiscardPile
{
	private Node top;
	
	/**
	 * default constructor-- 
	 * instantiate DiscardPile object Node top is null
	 */
	public DiscardPile()
	{
		top = null;
	}
	
	/**
	 * parameterized constructor--
	 * instantiate DiscardPile object Node top to addCard  
	 * @param addCard Card object to be the top node
	 */
	public void addCard(Card addCard)
	{
		top = new Node(addCard,top);
	}
	
	/**
	 * removeCard method-- remove one card from top node
	 * if top node is null throw exception to DiscardPileException
	 * @return item top node which get removed
	 * @throws DiscardPileException when top is null
	 */
	public Card removeCard () throws DiscardPileException
	{
		Card item;
		// if set return item to Node "Node item;"
		// return itme.getItem();
		if(top == null)
			throw new DiscardPileException("is empty no card to be removed.");
		else
		{
			item = top.getItem();
			top = top.getNext();
		}
		return item;
	}			
	
	/**
	 * removeCards method-- remove one or more card by sending number of card want to remove
	 * @param nRemove how many cards what to remove
	 * @return reference to the array which contains cards which get removes from top
	 * @throws DiscardPileException throw exception if what to remove cards more 
	 * than number of cards now contain 
	 */
	public Card [] removeCards(int nRemove) throws DiscardPileException
	{
		int i=0;
		Node current = top;
		Card [] removeCard = new Card[nRemove];
		if(size() < nRemove)
			throw new DiscardPileException("Don't have enough cards to be removed.");
		else
		{
			while(nRemove!=0)
			{
				removeCard[i] = current.getItem();
				current = current.getNext();
				top = current;
				nRemove--;
				i++;
			}
		}
		return removeCard;
	}
	
	/**
	 * isEmpty method-- check top stores data or null
	 * @return true if top is null, false if it stores something
	 */
	public boolean isEmpty()
	{
		return top==null;
	}
	
	/**
	 * size method-- counting how many cards contain in the linkListed 
	 * @return size ,total number of card stores in all node 
	 */
	public int size()
	{
		int size = 0;
		Node current = top;
		while(current != null)
		{
			size++;
			current = current.getNext();
		}
		return size;
	}
			
	/**
	 * toString --
	 * returns the state of the DiscardPile as a string
	 * @return a string containing the cards currently in the DiscardPile
	 */
	public String toString()
	{
		String str = new String();
		int j = 1;
		Node current = top;
		Card item;
		for(int i=size(); i>0; i--)
		{
			item = current.getItem();
			str += ("Card " + j + ": " + item.toString() + "\n");
			current = current.getNext();
			j++;
		}
		return str;
	}
}

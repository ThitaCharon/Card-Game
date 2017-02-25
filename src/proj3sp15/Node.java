package proj3sp15;
/**
 * <p>Title: The Node class</p>
 *
 * <p>Description: This class represents a single node. This class contains 
 * methods to implement the node which has data and next. 
 * (ie. default constructor, parameterized constructor,
 * and methods to change and return data and next in the node) </p>
 * 
 * @author <Thita Charoentham>
 */
public class Node {
	
	private Node next; //the address of the next node in the list
	private Card data;
	  /**
	   * default constructor - initializes data and next to null 
	   */
	  public Node()
	  {
		  data = null;
		  next = null;
	  }
	  
	  /**
	   * parameterized constructor - initializes data to the user 
	   * specified value; next is set to null
	   * @param newItem the value to be stored in the node
	   */
	  public Node(Card newItem)
	  {
	    data = newItem;
	    next = null;
	  }

	  /**
	   * parameterized constructor - initializes data and next to user 
	   * specified values
	   * @param newItem the object reference to be stored in the node
	   * @param nextItem the reference to the next node in the list
	   */
	  public Node(Card newItem, Node nextItem)
	  {
	    data = newItem;
	    next = nextItem;
	  }

	  /**
	   * setItem - stores a new value in data
	   * @param newItem the object reference to be stored in the node
	   */
	  public void setItem(Card newItem)
	  {
	    data = newItem;
	  }

	  /**
	   * setNext - stores a new value in next
	   * @param nextItem the reference to be stored in next
	   */
	  public void setNext(Node nextItem)
	  {
	    next = nextItem;
	  }

	  /**
	   * getItem - returns the reference stored in data
	   * @return a reference to the data stored in the node
	   */
	  public Card getItem()
	  {
	    return data;
	  }

	  /**
	   * getNext - returns the reference stored in next
	   * @return the reference stored in next
	   */
	  public Node getNext()
	  {
	    return next;
	  }
}

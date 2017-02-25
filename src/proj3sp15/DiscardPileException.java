package proj3sp15;

import java.io.IOException;

/**
 * <p>Title: DiscardPileException Class</p>
 *
 * <p>Description: Exception Class for use by all Container Classes</p>
 * 
 * * @author <Thita Charoentham>
 */

public class DiscardPileException extends RuntimeException{

	/**
     * Initializes an DiscardPileException storing the type of the
     * collection (as specified by the user) along with an appropriate message.
	 */
	public DiscardPileException(String collection)
	{
		super("DiscardPileException: " + collection);
	}

}


package proj3sp15;

import java.io.IOException;

/**
* <p>Title: DeckException Class</p>
*
* <p>Description: Exception Class for use by all Container Classes</p>
* 
* * @author Instructor and <Thita Charoentham>
*/

public class DeckException extends IOException
{
	/**
	 * Initializes an DeckException storing an appropriate 
	 * message along with the type of the collection (as specified by the user).
	 */
	public DeckException(String collection)
	{
		super("DeckException: " + collection);
	}
}

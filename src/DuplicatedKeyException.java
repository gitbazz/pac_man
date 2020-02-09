/**
 * This exception is thrown by the put method when a data item with the given
 * key is already stored in the tree.
 * 
 * @author Bazillah Zargar
 */
public class DuplicatedKeyException extends Exception {

	/**
	 * Sets up this exception with an appropriate message.
	 * 
	 * @param message explains what caused the exception
	 */
	public DuplicatedKeyException(String message) {
		super(message);
	}
}

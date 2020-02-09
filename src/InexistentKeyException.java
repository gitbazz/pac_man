/**
 * This exception is thrown by the remove method when the data item with the
 * given key is not stored in the tree.
 * 
 * @author Bazillah Zargar
 */
public class InexistentKeyException extends Exception {

	/**
	 * Sets up this exception with an appropriate message.
	 * 
	 * @param message explains what caused the exception
	 */
	public InexistentKeyException(String message) {
		super(message);
	}
}

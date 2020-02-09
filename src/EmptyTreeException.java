/**
 * This exception is thrown by the smallest method and the largest method when
 * the tree does not contain any data.
 * 
 * @author Bazillah Zargar
 */
public class EmptyTreeException extends Exception {

	/**
	 * Sets up this exception with an appropriate message.
	 * 
	 * @param message explains what caused the exception
	 */
	public EmptyTreeException(String message) {
		super(message);
	}
}

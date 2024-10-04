package io.musicdiscovery.moodplaylist.domain.exception;

/**
 * Custom exception thrown when a user is not found in the system.
 * 
 * <p>
 * This exception extends {@link RuntimeException} and is used to indicate that
 * a specific user could not be located within the system's data store or
 * service.
 * </p>
 * 
 * <p>
 * This exception can be used in services or repositories that need to handle
 * cases where an operation expects a user to exist, but no corresponding user
 * is found.
 * </p>
 * 
 * <p>
 * The {@code serialVersionUID} is defined to ensure serialization compatibility
 * across different JVM versions when instances of this exception are
 * serialized.
 * </p>
 * 
 * @see RuntimeException
 */
public class MoodNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new {@code UserNotFoundException} with the specified detail
	 * message.
	 * 
	 * @param message the detail message explaining why the exception was thrown
	 */
	public MoodNotFoundException(String message) {
		super(message);
	}
}

package io.musicdiscovery.moodplaylist.infrastructure.adapters.input.rest.model.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for representing error responses in the API.
 * 
 * <p>
 * This class is used to provide detailed information about errors that occur
 * during the processing of API requests. It encapsulates an error code,
 * message, additional details, and a timestamp indicating when the error
 * occurred.
 * </p>
 * 
 * <p>
 * The class is annotated with Lombok annotations to generate boilerplate code
 * such as getters, setters, constructors, and the builder pattern, simplifying
 * its usage throughout the application.
 * </p>
 * 
 * <p>
 * The {@code ErrorResponse} object is typically returned in the body of the
 * HTTP response when an error occurs, providing the client with information
 * about the failure.
 * </p>
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

	/**
	 * The error code representing the type of error.
	 * 
	 * <p>
	 * This field contains a string that identifies the specific error type, which
	 * can help the client understand the nature of the problem.
	 * </p>
	 */
	private String code;

	/**
	 * A message providing more details about the error.
	 * 
	 * <p>
	 * This message is intended to give a human-readable explanation of what went
	 * wrong, which can be useful for debugging or informing the user.
	 * </p>
	 */
	private String message;

	/**
	 * Additional details related to the error, such as validation failures.
	 * 
	 * <p>
	 * This list contains more granular details about the error. For example, in
	 * case of validation errors, it could contain a list of fields that failed
	 * validation and corresponding error messages.
	 * </p>
	 */
	private List<String> details;

	/**
	 * The timestamp indicating when the error occurred.
	 * 
	 * <p>
	 * This field records the exact time the error was encountered, which can be
	 * useful for logging and debugging purposes.
	 * </p>
	 */
	private LocalDateTime timestamp;
}

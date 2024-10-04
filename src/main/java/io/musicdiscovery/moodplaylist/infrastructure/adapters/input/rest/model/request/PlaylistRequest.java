package io.musicdiscovery.moodplaylist.infrastructure.adapters.input.rest.model.request;

import io.musicdiscovery.moodplaylist.domain.model.enums.Mood;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for incoming playlist generation requests.
 * 
 * <p>
 * This class is used to capture the input from the client when generating a
 * playlist based on the user's mood. It contains the {@link Mood} parameter
 * representing the user's current emotional state.
 * </p>
 * 
 * <p>
 * The class is annotated with Lombok annotations for generating boilerplate
 * code such as constructors, getters, setters, and the builder pattern.
 * </p>
 * 
 * <p>
 * Validation is applied through Jakarta Bean Validation annotations, ensuring
 * that the {@code mood} field is not empty or null.
 * </p>
 * 
 * <p>
 * OpenAPI annotations are used to describe the API schema for documentation
 * purposes using Swagger/OpenAPI.
 * </p>
 * 
 * @see Mood
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistRequest {

	/**
	 * The user's mood that will be used to generate the playlist.
	 * 
	 * <p>
	 * This field represents the emotional state of the user and is used as the key
	 * input for playlist generation.
	 * </p>
	 * 
	 * <p>
	 * The {@code @NotEmpty} annotation ensures that this field is not empty or
	 * null. The {@code @ArraySchema} and {@code @Schema} annotations are used for
	 * documenting this field in the OpenAPI/Swagger specification.
	 * </p>
	 */
	@ArraySchema(schema = @Schema(implementation = Mood.class, description = "User mood"))
	@NotEmpty(message = "Field User moods cannot be empty or null.")
	private Mood mood;

}

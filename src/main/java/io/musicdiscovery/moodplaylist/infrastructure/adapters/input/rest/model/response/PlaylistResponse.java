package io.musicdiscovery.moodplaylist.infrastructure.adapters.input.rest.model.response;

import java.util.List;

import io.musicdiscovery.moodplaylist.domain.model.enums.Mood;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) representing a playlist generated based on the
 * user's mood.
 * 
 * <p>
 * This class is used to send the playlist details back to the client in the
 * REST API response. It includes the playlist's unique identifier, the mood
 * that influenced the playlist generation, and a list of track URIs
 * representing the songs in the playlist.
 * </p>
 * 
 * <p>
 * The class is annotated with Lombok annotations for generating boilerplate
 * code such as getters, setters, constructors, and the builder pattern. It also
 * uses OpenAPI/Swagger annotations to document the API schema for the playlist
 * response.
 * </p>
 * 
 * @see Mood
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Represents a playlist generated based on the user's mood.")
public class PlaylistResponse {

	/**
	 * Unique identifier for the playlist, could be null if not persisted.
	 * 
	 * <p>
	 * This field represents the unique ID of the playlist, which might not be set
	 * if the playlist has not been persisted to a database yet.
	 * </p>
	 */
	@Schema(description = "Unique identifier for the playlist, could be null if not persisted.", example = "null")
	private String id;

	/**
	 * The mood based on which the playlist was generated.
	 * 
	 * <p>
	 * This field represents the user's mood that influenced the creation of the
	 * playlist. The {@link Mood} enum determines the type of music or tracks that
	 * will be included in the playlist.
	 * </p>
	 */
	@ArraySchema(schema = @Schema(implementation = Mood.class, description = "The mood based on which the playlist was generated."))
	private Mood mood;

	/**
	 * List of Spotify track URIs included in the playlist.
	 * 
	 * <p>
	 * This field contains the URIs for the tracks that are part of the playlist.
	 * These URIs represent unique identifiers for each song, typically referencing
	 * tracks on Spotify.
	 * </p>
	 */
	@Schema(description = "List of Spotify track URIs included in the playlist.", example = "[\"spotify:track:6rqhFgbbKwnb9MLmUQDhG6\", \"spotify:track:1hKdDCpiI9mqz1jVHRKG0E\"]")
	private List<String> trackUris;

}

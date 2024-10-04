package io.musicdiscovery.moodplaylist.infrastructure.adapters.output.client.spotify.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) representing the response from the Spotify API for
 * track recommendations.
 * 
 * <p>
 * This class is used to capture the recommended tracks returned by the Spotify
 * API based on the user's mood or other parameters.
 * </p>
 * 
 * <p>
 * The class includes a field for the recommended tracks, encapsulated in a
 * {@link SpotifyTrack} object.
 * </p>
 * 
 * <p>
 * The class is annotated with Lombok annotations to generate boilerplate code
 * such as getters, setters, constructors, and the builder pattern.
 * Additionally, it uses OpenAPI annotations to document the API schema for the
 * response object.
 * </p>
 * 
 * @see SpotifyTrack
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpotifyRecommendationsResponse {

	/**
	 * A collection of tracks returned by the Spotify API based on the
	 * recommendation criteria.
	 * 
	 * <p>
	 * This field contains the recommended tracks retrieved from Spotify,
	 * encapsulated within a {@link SpotifyTrack} object. These tracks are usually
	 * the result of a recommendation query based on parameters such as mood, genre,
	 * or user preferences.
	 * </p>
	 */
	@Schema(description = "Response rack")
	private SpotifyTrack tracks;
}

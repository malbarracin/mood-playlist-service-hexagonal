package io.musicdiscovery.moodplaylist.infrastructure.adapters.output.client.spotify.model.response;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) representing the details of a track in the Spotify
 * API response.
 * 
 * <p>
 * This class captures information about a track, including a list of track
 * items, when interacting with the Spotify API. The track items are
 * encapsulated in the {@link SpotifyTrackItems} class, which represents
 * individual tracks.
 * </p>
 * 
 * <p>
 * The class is annotated with Lombok annotations to generate boilerplate code
 * such as getters, setters, constructors, and the builder pattern.
 * Additionally, it uses OpenAPI annotations to document the API schema for the
 * Spotify tracks.
 * </p>
 * 
 * @see SpotifyTrackItems
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpotifyTrack {

	/**
	 * A list of individual track items.
	 * 
	 * <p>
	 * This field contains the list of individual tracks retrieved from the Spotify
	 * API. Each track item is represented by an instance of
	 * {@link SpotifyTrackItems}, which contains detailed information about the
	 * track, such as its name, artist, and album.
	 * </p>
	 */
	@Schema(description = "List items link track")
	private List<SpotifyTrackItems> items;

}

package io.musicdiscovery.moodplaylist.infrastructure.adapters.output.client.spotify.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) representing individual track items in the Spotify
 * API response.
 * 
 * <p>
 * This class captures the details of a specific track, including the album on
 * which the track appears. It interacts with the Spotify API to retrieve
 * information about the track and its associated album.
 * </p>
 * 
 * <p>
 * The class is annotated with Lombok annotations to generate boilerplate code
 * such as getters, setters, constructors, and the builder pattern.
 * Additionally, it uses OpenAPI annotations to document the schema for the
 * Spotify track items.
 * </p>
 * 
 * @see SpotifyAlbum
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpotifyTrackItems {

	/**
	 * The album on which the track appears.
	 * 
	 * <p>
	 * This field contains a reference to the {@link SpotifyAlbum} object, which
	 * includes details about the album that contains the track. The {@code href}
	 * property in the album provides a link to retrieve full information about the
	 * album.
	 * </p>
	 */
	@Schema(description = "The album on which the track appears. The album object includes a link in href to full information about the album.")
	private SpotifyAlbum album;
}

package io.musicdiscovery.moodplaylist.infrastructure.adapters.output.client.spotify.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) representing external URLs in the Spotify API
 * response.
 * 
 * <p>
 * This class is used to capture external URLs associated with a Spotify object,
 * such as an album, artist, or track, when interacting with the Spotify API.
 * </p>
 * 
 * <p>
 * The class includes the Spotify-specific URL and is typically used as part of
 * other DTOs that represent albums, tracks, or artists.
 * </p>
 * 
 * <p>
 * The class is annotated with Lombok annotations to generate boilerplate code
 * such as getters, setters, constructors, and the builder pattern.
 * Additionally, it uses OpenAPI annotations to document the API schema for the
 * Spotify URL.
 * </p>
 * 
 * @see SpotifyAlbum
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpotifyExternalUrls {

	/**
	 * The Spotify URL for the object (album, track, artist, etc.).
	 * 
	 * <p>
	 * This field contains the direct link to the object on Spotify's platform. The
	 * URL can be used to access the object (such as an album, track, or artist) on
	 * the Spotify application or website.
	 * </p>
	 */
	@Schema(description = "The Spotify URL for the object.")
	private String spotify;

}

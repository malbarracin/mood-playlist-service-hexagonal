package io.musicdiscovery.moodplaylist.infrastructure.adapters.output.client.spotify.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) representing an album in the Spotify API response.
 * 
 * <p>
 * This class is used to capture the details of an album, specifically its
 * external URLs, when interacting with the Spotify API.
 * </p>
 * 
 * <p>
 * The class is annotated with Jackson annotations to map the JSON properties to
 * Java fields and with Lombok annotations to generate boilerplate code such as
 * getters, setters, constructors, and the builder pattern. Additionally, it
 * uses OpenAPI annotations to document the schema for API purposes.
 * </p>
 * 
 * @see SpotifyExternalUrls
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpotifyAlbum {

	/**
	 * External URLs associated with this album, such as a Spotify link.
	 * 
	 * <p>
	 * This field is mapped to the {@code external_urls} property in the Spotify API
	 * response. It contains known URLs where this album can be accessed, such as a
	 * Spotify link.
	 * </p>
	 */
	@JsonProperty("external_urls")
	@Schema(description = "Known external URLs for this album")
	private SpotifyExternalUrls externalUrls;

}

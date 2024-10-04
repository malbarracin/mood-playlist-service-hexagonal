package io.musicdiscovery.moodplaylist.infrastructure.adapters.output.client.spotify.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) representing the response from Spotify's access
 * token endpoint.
 * 
 * <p>
 * This class is used to capture the response data when requesting an access
 * token from the Spotify API during the client credentials flow.
 * </p>
 * 
 * <p>
 * The class includes fields for the access token, token type, and expiration
 * time of the token. It uses Jackson annotations to map JSON properties to Java
 * fields and Lombok annotations to generate boilerplate code such as getters,
 * setters, constructors, and the builder pattern.
 * </p>
 * 
 * <p>
 * This object is typically populated by deserializing the JSON response from
 * Spotify's token endpoint.
 * </p>
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpotifyAccessTokenResponse {

	/**
	 * The access token used to authenticate API requests to Spotify.
	 * 
	 * <p>
	 * This field is mapped to the {@code access_token} property in the JSON
	 * response from Spotify's token endpoint.
	 * </p>
	 */
	@JsonProperty("access_token")
	private String accessToken;

	/**
	 * The type of token issued by Spotify, typically "Bearer".
	 * 
	 * <p>
	 * This field is mapped to the {@code token_type} property in the JSON response
	 * from Spotify's token endpoint and indicates the type of token issued.
	 * </p>
	 */
	@JsonProperty("token_type")
	private String tokenType;

	/**
	 * The number of seconds until the access token expires.
	 * 
	 * <p>
	 * This field is mapped to the {@code expires_in} property in the JSON response
	 * from Spotify's token endpoint and indicates how long the access token is
	 * valid before it needs to be refreshed.
	 * </p>
	 */
	@JsonProperty("expires_in")
	private int expiresIn;
}

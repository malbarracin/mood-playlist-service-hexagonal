package io.musicdiscovery.moodplaylist.infrastructure.adapters.output.client.spotify;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import io.musicdiscovery.moodplaylist.application.port.output.SpotifyPlaylistServicePort;
import io.musicdiscovery.moodplaylist.domain.model.Playlist;
import io.musicdiscovery.moodplaylist.domain.model.enums.Mood;
import io.musicdiscovery.moodplaylist.infrastructure.adapters.output.client.spotify.model.response.SpotifyAccessTokenResponse;
import io.musicdiscovery.moodplaylist.infrastructure.adapters.output.client.spotify.model.response.SpotifyRecommendationsResponse;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * Adapter that implements the {@link SpotifyPlaylistServicePort} to interact
 * with the Spotify API. This service generates playlists based on the user's
 * mood and authenticates using Spotify's client credentials flow.
 * 
 * <p>
 * This class uses {@link WebClient} to make HTTP requests to the Spotify API to
 * search for tracks based on the user's mood and retrieve Spotify access
 * tokens.
 * </p>
 * 
 * <p>
 * The class is annotated with {@code @Service}, indicating that it is a
 * Spring-managed service, and {@code @RequiredArgsConstructor}, which generates
 * a constructor for the required dependencies.
 * </p>
 * 
 * @see SpotifyPlaylistServicePort
 */
@Service
@RequiredArgsConstructor
public class SpotifyPlaylistServiceAdapter implements SpotifyPlaylistServicePort {

	private final WebClient.Builder webClientBuilder;

	@Value("${spotify.client-id}")
	private String clientId;

	@Value("${spotify.client-secret}")
	private String clientSecret;

	/**
	 * Creates a {@link WebClient} instance configured with the base URL of the
	 * Spotify API.
	 *
	 * @return a configured WebClient instance.
	 */
	public WebClient webClient() {
		return webClientBuilder.baseUrl("https://api.spotify.com").build();
	}

	/**
	 * Generates a playlist of tracks from Spotify based on the given mood.
	 * 
	 * <p>
	 * This method retrieves an access token using the Spotify client credentials
	 * flow, performs a search query to the Spotify API for tracks related to the
	 * given mood, and then collects the Spotify URIs of the retrieved tracks.
	 * </p>
	 * 
	 * @param mood the user's mood used as a search term for generating a playlist.
	 * @return a {@link Mono} containing the generated {@link Playlist} object.
	 */
	@Override
	public Mono<Playlist> generatePlaylist(Mood mood) {
		return getAccessToken().flatMap(accessToken -> webClient().get()
				.uri(uriBuilder -> uriBuilder.path("/v1/search").queryParam("q", mood.toString())
						.queryParam("type", "track").queryParam("limit", 10).build())
				.headers(headers -> headers.setBearerAuth(accessToken)).retrieve()
				.bodyToMono(SpotifyRecommendationsResponse.class).map(response -> {
					Playlist playlist = new Playlist();
					playlist.setMood(mood);
					playlist.setTrackUris(response.getTracks().getItems().stream()
							.map(track -> track.getAlbum().getExternalUrls().getSpotify())
							.collect(Collectors.toList()));
					return playlist;
				}));
	}

	/**
	 * Obtains an access token from Spotify by performing the client credentials
	 * flow.
	 *
	 * <p>
	 * This method sends a POST request to the Spotify authentication service to
	 * obtain an access token using the client credentials (client ID and client
	 * secret).
	 * </p>
	 * 
	 * @return a {@link Mono} containing the access token as a String.
	 */
	public Mono<String> getAccessToken() {
		String encodedCredentials = getEncodedCredentials();

		return WebClient.create().post().uri("https://accounts.spotify.com/api/token")
				.header("Authorization", "Basic " + encodedCredentials)
				.header("Content-Type", "application/x-www-form-urlencoded").bodyValue("grant_type=client_credentials")
				.retrieve().bodyToMono(SpotifyAccessTokenResponse.class)
				.map(SpotifyAccessTokenResponse::getAccessToken);
	}

	/**
	 * Encodes the Spotify client credentials (client ID and client secret) using
	 * Base64 encoding.
	 * 
	 * <p>
	 * This method combines the client ID and client secret into a single string,
	 * and then encodes the result using Base64, which is required for
	 * authentication with the Spotify API.
	 * </p>
	 *
	 * @return the Base64 encoded string of the client credentials.
	 */
	public String getEncodedCredentials() {
		String credentials = clientId + ":" + clientSecret;
		return java.util.Base64.getEncoder().encodeToString(credentials.getBytes());
	}

}

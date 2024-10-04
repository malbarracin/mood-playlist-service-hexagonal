package io.musicdiscovery.moodplaylist.application.port.output;

import io.musicdiscovery.moodplaylist.domain.model.Playlist;
import io.musicdiscovery.moodplaylist.domain.model.enums.Mood;
import reactor.core.publisher.Mono;

/**
 * Port interface for interacting with the Spotify API in the application's
 * hexagonal architecture. This interface defines the contract for generating
 * playlists by interacting with an external music service, such as Spotify.
 * 
 * <p>
 * This is part of the output port in the hexagonal (ports and adapters)
 * architecture, allowing the application to communicate with an external API
 * (Spotify) without being tightly coupled to its implementation.
 * </p>
 * 
 * <p>
 * It follows the principles of reactive programming using {@link Mono},
 * ensuring asynchronous, non-blocking operations while interacting with the
 * external API.
 * </p>
 * 
 * @see Playlist
 * @see Mood
 */
public interface SpotifyPlaylistServicePort {

	/**
	 * Generates a playlist based on the specified user mood by interacting with the
	 * Spotify API.
	 * 
	 * <p>
	 * This method takes a {@link Mood} as input and returns a {@link Mono}
	 * containing the generated {@link Playlist} object. The implementation should
	 * query the Spotify API to create a playlist that aligns with the user's mood.
	 * </p>
	 * 
	 * @param mood the mood of the user, used to generate an appropriate playlist
	 * @return a {@link Mono} emitting the generated {@link Playlist} based on the
	 *         mood
	 */
	Mono<Playlist> generatePlaylist(Mood mood);
}

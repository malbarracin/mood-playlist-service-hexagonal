package io.musicdiscovery.moodplaylist.application.port.input;

import io.musicdiscovery.moodplaylist.domain.model.Playlist;
import io.musicdiscovery.moodplaylist.domain.model.enums.Mood;
import reactor.core.publisher.Mono;

/**
 * Port interface for the Playlist Service in the application's hexagonal
 * architecture. This interface defines the contract for generating playlists
 * based on the user's mood.
 * 
 * <p>
 * This is part of the input port in the hexagonal (ports and adapters)
 * architecture, allowing interaction with the playlist generation logic without
 * depending on the underlying implementation.
 * </p>
 * 
 * <p>
 * It follows the principles of reactive programming using {@link Mono},
 * providing asynchronous, non-blocking operations.
 * </p>
 * 
 * @see Playlist
 * @see Mood
 */
public interface PlaylistServicePort {

	/**
	 * Generates a playlist based on the specified user mood.
	 * 
	 * <p>
	 * This method takes a {@link Mood} as input and returns a {@link Mono}
	 * containing the generated {@link Playlist}. The implementation should interact
	 * with an external music API (such as Spotify) to create the playlist according
	 * to the user's mood.
	 * </p>
	 * 
	 * @param mood the mood of the user to generate the playlist for
	 * @return a {@link Mono} emitting the generated {@link Playlist} based on the
	 *         mood
	 */
	Mono<Playlist> generatePlaylist(Mood mood);

}

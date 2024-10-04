package io.musicdiscovery.moodplaylist.application.service;

import org.springframework.stereotype.Service;

import io.musicdiscovery.moodplaylist.application.port.input.PlaylistServicePort;
import io.musicdiscovery.moodplaylist.application.port.output.PlaylistPersistencePort;
import io.musicdiscovery.moodplaylist.application.port.output.SpotifyPlaylistServicePort;
import io.musicdiscovery.moodplaylist.domain.model.Playlist;
import io.musicdiscovery.moodplaylist.domain.model.enums.Mood;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * Application service that handles the generation and persistence of playlists
 * based on the user's mood. This service implements the
 * {@link PlaylistServicePort} and serves as the core business logic layer in
 * the application.
 * 
 * <p>
 * This class coordinates between the input port {@link PlaylistServicePort} and
 * the output ports {@link SpotifyPlaylistServicePort} and
 * {@link PlaylistPersistencePort}, implementing the hexagonal architecture
 * (ports and adapters).
 * </p>
 * 
 * <p>
 * It follows the principles of reactive programming using {@link Mono},
 * ensuring that playlist generation and persistence are asynchronous and
 * non-blocking.
 * </p>
 * 
 * <p>
 * The {@code @Service} annotation indicates that this class is a Spring-managed
 * service, and the {@code @RequiredArgsConstructor} annotation generates a
 * constructor for the required final fields.
 * </p>
 * 
 * @see Playlist
 * @see Mood
 * @see PlaylistServicePort
 * @see SpotifyPlaylistServicePort
 * @see PlaylistPersistencePort
 */
@Service
@RequiredArgsConstructor
public class PlaylistApplicationService implements PlaylistServicePort {

	private final SpotifyPlaylistServicePort spotifyPlaylistServicePort;
	private final PlaylistPersistencePort playlistRepositoryPort;

	/**
	 * Generates a playlist based on the user's mood by interacting with the Spotify
	 * API and then saves the playlist to the persistence layer.
	 * 
	 * <p>
	 * This method calls the {@link SpotifyPlaylistServicePort} to generate a
	 * playlist based on the provided {@link Mood}, and then persists it using
	 * {@link PlaylistPersistencePort}.
	 * </p>
	 * 
	 * @param mood the mood of the user for which the playlist will be generated
	 * @return a {@link Mono} emitting the generated and saved {@link Playlist}
	 */
	@Override
	public Mono<Playlist> generatePlaylist(Mood mood) {
		return spotifyPlaylistServicePort.generatePlaylist(mood).flatMap(playlistRepositoryPort::save);
	}

}
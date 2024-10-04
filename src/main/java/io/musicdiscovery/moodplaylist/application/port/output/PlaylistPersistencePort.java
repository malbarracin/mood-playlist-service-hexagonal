package io.musicdiscovery.moodplaylist.application.port.output;

import io.musicdiscovery.moodplaylist.domain.model.Playlist;
import reactor.core.publisher.Mono;

/**
 * Port interface for persisting playlists in the application's hexagonal
 * architecture. This interface defines the contract for saving {@link Playlist}
 * objects to a persistence layer.
 * 
 * <p>
 * This interface is part of the output port in the hexagonal (ports and
 * adapters) architecture, allowing the application to interact with the
 * persistence layer (e.g., database) without being coupled to its specific
 * implementation.
 * </p>
 * 
 * <p>
 * It follows the principles of reactive programming using {@link Mono},
 * enabling asynchronous and non-blocking operations.
 * </p>
 * 
 * @see Playlist
 */
public interface PlaylistPersistencePort {

	/**
	 * Persists the given playlist in the storage system.
	 * 
	 * <p>
	 * This method saves a {@link Playlist} to the persistence layer and returns a
	 * {@link Mono} emitting the saved {@link Playlist} object. The specific
	 * implementation of this method could interact with a database, file system, or
	 * any other persistence mechanism.
	 * </p>
	 * 
	 * @param playlist the {@link Playlist} to be saved
	 * @return a {@link Mono} emitting the saved {@link Playlist}
	 */
	Mono<Playlist> save(Playlist playlist);

}

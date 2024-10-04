package io.musicdiscovery.moodplaylist.infrastructure.adapters.output.persistence;

import org.springframework.stereotype.Component;

import io.musicdiscovery.moodplaylist.application.port.output.PlaylistPersistencePort;
import io.musicdiscovery.moodplaylist.domain.model.Playlist;
import io.musicdiscovery.moodplaylist.infrastructure.adapters.output.persistence.entity.PlaylistEntity;
import io.musicdiscovery.moodplaylist.infrastructure.adapters.output.persistence.mapper.PlaylistPersistenceMapper;
import io.musicdiscovery.moodplaylist.infrastructure.adapters.output.persistence.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * Adapter that implements the {@link PlaylistPersistencePort} to handle the
 * persistence of playlists.
 * 
 * <p>
 * This class provides the implementation for saving playlists in the database.
 * It uses a repository to persist {@link PlaylistEntity} objects and a mapper
 * to convert between the domain model {@link Playlist} and the persistence
 * model {@link PlaylistEntity}.
 * </p>
 * 
 * <p>
 * The class is annotated with {@code @Component}, making it a Spring-managed
 * component, and with {@code @RequiredArgsConstructor} to automatically
 * generate a constructor for the required dependencies.
 * </p>
 * 
 * @see PlaylistPersistencePort
 * @see PlaylistPersistenceMapper
 * @see PlaylistRepository
 */
@Component
@RequiredArgsConstructor
public class PlaylistPersistenceAdapter implements PlaylistPersistencePort {

	private final PlaylistRepository repository;
	private final PlaylistPersistenceMapper mapper;

	/**
	 * Saves a playlist in the database by converting it to an entity and persisting
	 * it via the repository.
	 * 
	 * <p>
	 * This method maps the domain {@link Playlist} to a {@link PlaylistEntity},
	 * saves it to the database, and then converts it back to a domain object upon
	 * successful persistence.
	 * </p>
	 * 
	 * @param playList the playlist to be saved
	 * @return a {@link Mono} emitting the saved {@link Playlist} object
	 */
	@Override
	public Mono<Playlist> save(Playlist playList) {
		PlaylistEntity entity = mapper.toPlaylistEntity(playList);
		return repository.save(entity).map(mapper::toPlaylist);
	}
}
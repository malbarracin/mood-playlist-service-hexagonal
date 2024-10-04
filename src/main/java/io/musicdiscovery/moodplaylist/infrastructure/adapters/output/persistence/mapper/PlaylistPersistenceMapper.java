package io.musicdiscovery.moodplaylist.infrastructure.adapters.output.persistence.mapper;

import org.mapstruct.Mapper;

import io.musicdiscovery.moodplaylist.domain.model.Playlist;
import io.musicdiscovery.moodplaylist.infrastructure.adapters.output.persistence.entity.PlaylistEntity;

/**
 * Mapper interface for converting between {@link Playlist} domain objects and
 * {@link PlaylistEntity} objects.
 * 
 * <p>
 * This interface provides the mapping logic between the domain model and the
 * persistence model using MapStruct, which generates the implementation at
 * compile time. It is responsible for converting playlists between the
 * application's domain layer and the persistence layer.
 * </p>
 * 
 * <p>
 * The class is annotated with {@code @Mapper}, making it a MapStruct mapper,
 * and it is managed as a Spring component.
 * </p>
 * 
 * @see Playlist
 * @see PlaylistEntity
 */
@Mapper(componentModel = "spring")
public interface PlaylistPersistenceMapper {

	/**
	 * Converts a {@link Playlist} domain object to a {@link PlaylistEntity} object.
	 * 
	 * <p>
	 * This method maps the fields from a playlist in the domain model to its
	 * corresponding persistence entity, allowing the playlist to be persisted in
	 * the database.
	 * </p>
	 *
	 * @param playlist the {@link Playlist} domain object to convert
	 * @return the corresponding {@link PlaylistEntity} object
	 */
	PlaylistEntity toPlaylistEntity(Playlist user);

	/**
	 * Converts a {@link PlaylistEntity} object to a {@link Playlist} domain object.
	 * 
	 * <p>
	 * This method maps the fields from the persistence entity back to the domain
	 * model, allowing the playlist to be used in the business logic layer of the
	 * application.
	 * </p>
	 *
	 * @param entity the {@link PlaylistEntity} object to convert
	 * @return the corresponding {@link Playlist} domain object
	 */
	Playlist toPlaylist(PlaylistEntity entity);

}
package io.musicdiscovery.moodplaylist.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import io.musicdiscovery.moodplaylist.infrastructure.adapters.output.persistence.entity.PlaylistEntity;

/**
 * Repository interface for managing {@link PlaylistEntity} objects in MongoDB.
 * 
 * <p>
 * This interface extends {@link ReactiveMongoRepository} to provide reactive
 * CRUD operations for {@link PlaylistEntity} objects. It acts as the data
 * access layer for playlists in the MongoDB database, allowing for
 * non-blocking, reactive interactions with the database.
 * </p>
 * 
 * <p>
 * The interface is annotated with {@code @Repository}, making it a
 * Spring-managed component, and serves as the output adapter in the hexagonal
 * architecture, interacting with the persistence layer.
 * </p>
 * 
 * @see ReactiveMongoRepository
 * @see PlaylistEntity
 */
@Repository
public interface PlaylistRepository extends ReactiveMongoRepository<PlaylistEntity, String> {

}

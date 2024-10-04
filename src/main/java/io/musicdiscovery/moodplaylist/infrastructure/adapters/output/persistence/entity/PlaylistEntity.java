package io.musicdiscovery.moodplaylist.infrastructure.adapters.output.persistence.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import io.musicdiscovery.moodplaylist.domain.model.enums.Mood;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;

/**
 * Playlist entity representing a Playlist in the system.
 * 
 * <p>
 * This class maps to a MongoDB document and represents a playlist entity in the
 * persistence layer of the application. It is used to store and retrieve
 * playlists from the database.
 * </p>
 * 
 * <p>
 * The class contains fields for the playlist's unique identifier, the mood
 * associated with the playlist, and a list of Spotify track URIs included in
 * the playlist.
 * </p>
 * 
 * <p>
 * The class is annotated with Lombok annotations to generate boilerplate code
 * such as getters, setters, constructors, and it uses Spring Data MongoDB
 * annotations to define how the entity is mapped to a MongoDB collection.
 * </p>
 * 
 * @see Mood
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class PlaylistEntity {

	/**
	 * Unique identifier for the playlist in the MongoDB database.
	 * 
	 * <p>
	 * This field serves as the primary key for the playlist document in the MongoDB
	 * collection.
	 * </p>
	 */
	@Id
	private String id;

	/**
	 * The mood associated with the playlist.
	 * 
	 * <p>
	 * This field represents the emotional state or mood that was used to generate
	 * the playlist, and it is stored in the database as part of the playlist
	 * document.
	 * </p>
	 */
	private Mood mood;

	/**
	 * A list of URIs representing the tracks included in the playlist.
	 * 
	 * <p>
	 * This field contains the URIs of the tracks in the playlist. Each URI points
	 * to a track on Spotify, and they are stored as part of the playlist document
	 * in MongoDB.
	 * </p>
	 */
	private List<String> trackUris;
}

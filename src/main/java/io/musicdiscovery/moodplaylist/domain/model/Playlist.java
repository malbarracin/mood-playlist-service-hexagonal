package io.musicdiscovery.moodplaylist.domain.model;

import java.util.List;

import io.musicdiscovery.moodplaylist.domain.model.enums.Mood;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a playlist generated based on a user's mood.
 * 
 * <p>
 * This class contains the playlist's unique identifier, the mood that
 * influenced the creation of the playlist, and a list of track URIs
 * representing the songs in the playlist.
 * </p>
 * 
 * <p>
 * The class uses Lombok annotations for generating boilerplate code such as
 * getters, setters, constructors, and no-argument constructors.
 * </p>
 * 
 * @see Mood
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Playlist {
	/**
	 * Unique identifier for the playlist.
	 */
	private String id;

	/**
	 * The mood used to generate the playlist.
	 * 
	 * <p>
	 * The playlist is created based on the user's current mood, which determines
	 * the type of songs or tracks included.
	 * </p>
	 */
	private Mood mood;

	/**
	 * List of URIs for the tracks in the playlist.
	 * 
	 * <p>
	 * The URIs represent unique identifiers for each track, typically referencing
	 * songs from an external service like Spotify.
	 * </p>
	 */
	private List<String> trackUris;

}
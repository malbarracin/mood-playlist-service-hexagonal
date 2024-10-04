package io.musicdiscovery.moodplaylist.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import io.musicdiscovery.moodplaylist.domain.model.Playlist;
import io.musicdiscovery.moodplaylist.infrastructure.adapters.input.rest.model.request.PlaylistRequest;
import io.musicdiscovery.moodplaylist.infrastructure.adapters.input.rest.model.response.PlaylistResponse;


/**
 * Mapper interface for converting between {@link Playlist} domain objects and
 * their corresponding REST API request/response DTOs (Data Transfer Objects).
 * 
 * <p>
 * This interface uses MapStruct to automatically generate the implementations
 * for converting between {@link PlaylistRequest}, {@link PlaylistResponse}, and
 * {@link Playlist} objects.
 * </p>
 * 
 * <p>
 * The {@code @Mapper} annotation marks this as a MapStruct mapper and
 * configures it to be a Spring component. The
 * {@code unmappedTargetPolicy = ReportingPolicy.IGNORE} ensures that unmapped
 * properties are ignored and do not cause build warnings.
 * </p>
 * 
 * @see Playlist
 * @see PlaylistRequest
 * @see PlaylistResponse
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlaylistRestMapper {

	/**
	 * Converts a {@link PlaylistRequest} object to a {@link Playlist} domain
	 * object.
	 * 
	 * <p>
	 * This method transforms the data received from a REST API request into the
	 * domain model used by the application.
	 * </p>
	 * 
	 * @param request the {@link PlaylistRequest} object to convert
	 * @return the converted {@link Playlist} domain object
	 */
	Playlist toPlaylist(PlaylistRequest request);

	/**
	 * Converts a {@link Playlist} domain object to a {@link PlaylistResponse}
	 * object.
	 * 
	 * <p>
	 * This method is used to transform the domain object into a response DTO that
	 * can be sent back to the client through the REST API.
	 * </p>
	 * 
	 * @param playlist the {@link Playlist} domain object to convert
	 * @return the converted {@link PlaylistResponse} object
	 */
	PlaylistResponse toPlaylistResponse(Playlist user);

}
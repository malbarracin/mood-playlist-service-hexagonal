package io.musicdiscovery.moodplaylist.infrastructure.adapters.input.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.musicdiscovery.moodplaylist.application.port.input.PlaylistServicePort;
import io.musicdiscovery.moodplaylist.domain.model.enums.Mood;
import io.musicdiscovery.moodplaylist.infrastructure.adapters.input.rest.mapper.PlaylistRestMapper;
import io.musicdiscovery.moodplaylist.infrastructure.adapters.input.rest.model.response.PlaylistResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * Controller class that handles HTTP requests related to playlist operations.
 * 
 * <p>
 * This class acts as the entry point (input adapter) in the hexagonal
 * architecture, exposing REST API endpoints for interacting with playlists. It
 * handles requests for generating playlists based on the user's mood and
 * interacts with the {@link PlaylistServicePort} to perform the required
 * business logic.
 * </p>
 * 
 * <p>
 * The controller uses the {@link PlaylistRestMapper} to map between domain
 * objects and REST response DTOs. It is annotated with Swagger annotations to
 * document the API and provide examples for the expected responses.
 * </p>
 * 
 * @see PlaylistServicePort
 * @see PlaylistRestMapper
 * @see PlaylistResponse
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/playlists")
@Tag(name = "Playlists API", description = "Operations related to managing music playlists")
public class PlaylistController {

	private final PlaylistServicePort playlistServicePort;
	private final PlaylistRestMapper playlistRestMapper;

	/**
	 * Generates a playlist based on the user's mood.
	 * 
	 * <p>
	 * This endpoint interacts with the Spotify API to generate a playlist of
	 * recommended tracks based on the specified mood. The generated playlist is
	 * returned as a {@link PlaylistResponse}.
	 * </p>
	 * 
	 * <p>
	 * Swagger annotations are used to describe the API, including response codes
	 * and examples of successful and error responses.
	 * </p>
	 * 
	 * @param mood the user's mood used to generate the playlist
	 * @return a {@link Mono} emitting the generated {@link PlaylistResponse}
	 */
	@Operation(summary = "Generate a playlist based on the user's mood", description = "Generates a playlist using Spotify's recommendations based on the specified mood.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Playlist successfully generated", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PlaylistResponse.class), examples = @ExampleObject(value = "{\r\n"
					+ "    \"id\": \"66f6c16114bc0440df633f97\",\r\n" + "    \"mood\": \"relaxed\",\r\n"
					+ "    \"trackUris\": [\r\n" + "        \"spotify:track:6rqhFgbbKwnb9MLmUQDhG6\",\r\n"
					+ "        \"spotify:track:1hKdDCpiI9mqz1jVHRKG0E\",\r\n"
					+ "        \"spotify:track:2Xr1dTzJee307rmrkt8c0g\"\r\n" + "    ]\r\n" + "}"))),
			@ApiResponse(responseCode = "404", description = "Mood not found", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = "{\r\n"
					+ "    \"message\": \"Mood not found\",\r\n" + "    \"status\": 404\r\n" + "}"))),
			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = "{\r\n"
					+ "    \"message\": \"Invalid request input: Failed to read HTTP message\",\r\n"
					+ "    \"status\": 400\r\n" + "}"))) })
	@GetMapping(path = "${playlist.generate-playlist-by-mood}")
	public Mono<PlaylistResponse> generatePlaylistByMood(@PathVariable("mood") Mood mood) {
		return playlistServicePort.generatePlaylist(mood).map(playlistRestMapper::toPlaylistResponse);
	}

}
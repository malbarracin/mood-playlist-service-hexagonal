package io.musicdiscovery.moodplaylist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Configuration class for setting up the {@link WebClient} used to interact
 * with external APIs, such as the Spotify API.
 * 
 * <p>
 * This class provides a configuration for creating and injecting a
 * {@link WebClient.Builder} instance, which can be used throughout the
 * application for making non-blocking, reactive HTTP requests.
 * </p>
 * 
 * <p>
 * The {@code @Configuration} annotation indicates that this class defines beans
 * that are part of the application's Spring configuration.
 * </p>
 * 
 * @see WebClient
 */
@Configuration
public class SpotifyConfig {

	/**
	 * Creates and configures a {@link WebClient.Builder} bean.
	 * 
	 * <p>
	 * This method returns a {@link WebClient.Builder}, which can be used to
	 * configure and build {@link WebClient} instances for making HTTP requests to
	 * external services. The builder is customizable and reusable across different
	 * components in the application.
	 * </p>
	 * 
	 * @return a {@link WebClient.Builder} instance
	 */
	@Bean
	WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}

}

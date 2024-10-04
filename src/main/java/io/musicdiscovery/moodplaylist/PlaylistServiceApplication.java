package io.musicdiscovery.moodplaylist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Playlist Service Application. This class serves as
 * the bootstrapping class for the Spring Boot application, responsible for
 * launching the application context and initializing the service's components.
 * 
 * The {@code @SpringBootApplication} annotation enables auto-configuration,
 * component scanning, and configuration of Spring Boot. The
 * {@code scanBasePackages} attribute is set to "io.musicdiscovery.moodplaylist"
 * to ensure that Spring scans the correct package for beans and components.
 * 
 * <p>
 * Example usage:
 * </p>
 * 
 * <pre>{@code
 * public static void main(String[] args) {
 * 	SpringApplication.run(PlaylistServiceApplication.class, args);
 * }
 * }</pre>
 * 
 * <p>
 * This class is typically used as the entry point in a Spring Boot microservice
 * architecture.
 * </p>
 * 
 * @see SpringApplication
 * @see SpringBootApplication
 */
@SpringBootApplication(scanBasePackages = "io.musicdiscovery.moodplaylist")
public class PlaylistServiceApplication {

	/**
	 * Main method used to start the Spring Boot application. This method invokes
	 * {@link SpringApplication#run(Class, String...)} to bootstrap the application
	 * using the specified configuration.
	 * 
	 * @param args command-line arguments passed to the application at startup
	 */
	public static void main(String[] args) {
		SpringApplication.run(PlaylistServiceApplication.class, args);
	}
}
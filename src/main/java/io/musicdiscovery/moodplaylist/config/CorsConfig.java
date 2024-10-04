package io.musicdiscovery.moodplaylist.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * Configuration class for enabling Cross-Origin Resource Sharing (CORS) in the
 * application using Spring WebFlux.
 * 
 * <p>
 * This class implements {@link WebFluxConfigurer} and customizes CORS settings
 * to allow requests from any origin, using any HTTP method, and exposing the
 * {@code Content-Disposition} header.
 * </p>
 * 
 * <p>
 * The {@code @Configuration} annotation indicates that this class is a Spring
 * configuration class, and the {@code @EnableWebFlux} annotation enables Spring
 * WebFlux support in the application.
 * </p>
 * 
 * <p>
 * By adding mappings in the {@link #addCorsMappings(CorsRegistry)}, this
 * configuration ensures that the application can handle cross-origin requests
 * securely and flexibly.
 * </p>
 */
@Configuration
@EnableWebFlux
public class CorsConfig implements WebFluxConfigurer {

	/**
	 * Configure CORS settings to allow requests from any origin and with any HTTP
	 * method.
	 * 
	 * <p>
	 * This method customizes the CORS mappings to allow all origins, methods, and
	 * headers. Additionally, it exposes the {@code Content-Disposition} header in
	 * the response, which is commonly used when handling file downloads.
	 * </p>
	 * 
	 * @param registry the {@link CorsRegistry} to register the CORS configuration
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*")
				.exposedHeaders("Content-Disposition");
	}
}
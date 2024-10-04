package io.musicdiscovery.moodplaylist.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

/**
 * Configuration class for setting up MongoDB reactive connections in the
 * application.
 * 
 * <p>
 * This class extends {@link AbstractReactiveMongoConfiguration} and defines the
 * necessary configuration for connecting to a MongoDB database in a reactive
 * environment using non-blocking streams.
 * </p>
 * 
 * <p>
 * The {@code @Configuration} annotation marks this class as a Spring
 * configuration class, and the {@code @EnableMongoRepositories} annotation
 * enables MongoDB repository support.
 * </p>
 * 
 * <p>
 * Database connection details such as username, password, host, and database
 * name are injected via Spring's {@code @Value} annotation using properties
 * defined in the application's configuration files.
 * </p>
 * 
 * @see AbstractReactiveMongoConfiguration
 * @see ReactiveMongoTemplate
 */
@Configuration
@EnableMongoRepositories
public class MongoDBConfig extends AbstractReactiveMongoConfiguration {

	@Value("${mongo.data-base-user-name}")
	private String DATA_BASE_USER_NAME;

	@Value("${mongo.data-base-user-password}")
	private String DATA_BASE_USER_PASSWORD;

	@Value("${mongo.data-base-host}")
	private String DATA_BASE_HOST;

	@Value("${mongo.data-base-name}")
	private String DATA_BASE_NAME;

	/**
	 * Returns the name of the database to be used.
	 * 
	 * <p>
	 * This method overrides the
	 * {@link AbstractReactiveMongoConfiguration#getDatabaseName()} method to
	 * provide the name of the database from the configuration property.
	 * </p>
	 * 
	 * @return the name of the MongoDB database
	 */
	@Override
	protected String getDatabaseName() {
		return DATA_BASE_NAME;
	}

	/**
	 * Configures and creates a reactive MongoDB client for connecting to the
	 * database.
	 * 
	 * <p>
	 * This method builds a {@link MongoClient} using the database credentials
	 * (username, password), host, and other settings such as connection timeout and
	 * socket timeout.
	 * </p>
	 * 
	 * @return a reactive {@link MongoClient} instance configured for the MongoDB
	 *         connection
	 */
	@Override
	@Bean
	public MongoClient reactiveMongoClient() {

		ConnectionString connectionString = new ConnectionString(
				"mongodb://" + DATA_BASE_USER_NAME + ":" + DATA_BASE_USER_PASSWORD + "@" + DATA_BASE_HOST);

		MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connectionString)
				.applyToConnectionPoolSettings(builder -> builder.maxWaitTime(5000, TimeUnit.MILLISECONDS))
				.applyToSocketSettings(builder -> builder.connectTimeout(5000, TimeUnit.MILLISECONDS)).build();

		return MongoClients.create(settings);
	}

	/**
	 * Configures a {@link ReactiveMongoTemplate} for performing MongoDB operations
	 * in a reactive manner.
	 * 
	 * <p>
	 * This method creates a {@link ReactiveMongoTemplate} by using the
	 * {@link SimpleReactiveMongoDatabaseFactory} and the reactive MongoDB client.
	 * </p>
	 * 
	 * @param mongoClient the reactive MongoDB client used to interact with the
	 *                    database
	 * @return a {@link ReactiveMongoTemplate} for reactive MongoDB operations
	 */
	@Bean
	ReactiveMongoTemplate reactiveMongoTemplate(MongoClient mongoClient) {
		return new ReactiveMongoTemplate(new SimpleReactiveMongoDatabaseFactory(mongoClient, "database"));
	}
}

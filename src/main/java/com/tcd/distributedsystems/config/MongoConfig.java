package com.tcd.distributedsystems.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "com.tcd.distributedsystems.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {

	@Value("${distributed-systems.mongodb.replicaset.database}")
	private String database;

	@Value("${distributed-systems.mongodb.replicaset.authMechanism}")
	private String authMechanism;

	@Value("${distributed-systems.mongodb.replicaset.username}")
	private String username;

	@Value("${distributed-systems.mongodb.replicaset.password}")
	private String password;

	@Value("${distributed-systems.mongodb.replicaset.primary}")
	private String primary;

	@Value("${distributed-systems.mongodb.replicaset.replicaSetName}")
	private String replicaSetName;

	@Value("${distributed-systems.mongodb.replicaset.port}")
	private String port;

	@Value("${distributed-systems.mongodb.replicaset.authenticationDb}")
	private String authenticationDb;

	@Value("${distributed-systems.mongodb.replicaset.maxPoolSize}")
	private String maxPoolSize;

	@Override
	public MongoClient mongoClient() {
		return MongoClients.create("mongodb://" + username + ":" + password + "@" + primary + ":" + port + "/"
				+ database + "?replicaSet=" + replicaSetName + "&authSource=" + authenticationDb + "&maxPoolSize="
				+ maxPoolSize + "&authMechanism=" + authMechanism + "&ssl=false");
	}

	@Override
	protected String getDatabaseName() {
		return database;
	}

}

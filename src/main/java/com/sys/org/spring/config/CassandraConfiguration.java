package com.sys.org.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories("com.sys.org.spring.repositories")
public class CassandraConfiguration {
}

package com.shailesh.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {

	@Value("${application.database.driverClassName}")
	private String driverClassName;

	@Value("${application.database.url}")
	private String url;

	@Value("${application.database.username}")
	private String databaseUserName;

	@Value("${application.database.password}")
	private String databasePassword;

	@Primary
	@Bean(name = "dataSource")
	public DataSource getDataSource() {

		return DataSourceBuilder.create().driverClassName(driverClassName).url(url).username(databaseUserName)
				.password(databasePassword).build();
		//.password(databasePassword).type(com.zaxxer.hikari.HikariDataSource.class).build();
	}
}

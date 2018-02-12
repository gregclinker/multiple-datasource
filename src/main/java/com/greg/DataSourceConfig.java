package com.greg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DataSourceConfig {

	@Autowired
	private Environment env;

	public DataSource makeDataSource(String name) {
		return DataSourceBuilder.create()
				.driverClassName(env.getProperty("spring.datasource." + name + ".driver-class-name"))
				.url(env.getProperty("spring.datasource." + name + ".url")).build();
	}

	@Bean
	public DataSource dataSource() {
		DataSourceManager dataSourceManager = new DataSourceManager();
		dataSourceManager.add("test1", makeDataSource("test1"));
		dataSourceManager.add("test2", makeDataSource("test2"));
		dataSourceManager.switchDataSource("test1");
		return dataSourceManager;
	}

}
package com.drogatel.api.repository.drogatel.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DrogatelConfig {

	@Autowired
	private Environment env;
	
	
	
	@Bean(name="drogatelDataSource")
    public DataSource drogatelDataSource() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setUrl(env.getProperty("ds.drogatel.url"));
        dataSource.setDriverClassName(env.getProperty("sql.driverClassName"));
	    dataSource.setUsername(env.getProperty("sql.drogatel.username"));
	    dataSource.setPassword(env.getProperty("sql.drogatel.password"));
	    return dataSource;
    }
}

package com.omniwyse.springdatajpa.all;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

public class TenanatDataSource {
	public static DataSource getDataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setUsername("lambda");
		dataSource.setPassword("lambda123");
		dataSource.setAutoCommit(false);
		dataSource.setJdbcUrl("jdbc:mysql://rds-lambda.c1nqtylunte8.us-east-1.rds.amazonaws.com:3306/test?createDatabaseIfNotExist=true");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setMaximumPoolSize(10);
		return dataSource;
	}
}

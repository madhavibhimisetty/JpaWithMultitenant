package com.omniwyse.springdatajpa.all;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@EnableJpaRepositories(basePackages = "com.omniwyse.springdatajpa.all")
public class DBConfig {
	
	
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPersistenceUnitName("EmployeeJPA");
        
        return em;
    }

   
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager
                .setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
    
    
	/*
	 * @Bean public Connection multiTenantConnectionProvider(String tenant) throws
	 * NamingException, SQLException {
	 * 
	 * MultiTenantSchemaConnectionProvider connectionProvider = new
	 * MultiTenantSchemaConnectionProvider(); Connection connection =
	 * connectionProvider.getConnection(tenant);
	 * 
	 * return connection;
	 * 
	 * }
	 */

//    Properties additionalProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "validate");
//        properties.setProperty("hibernate.show_sql", "true");
//        properties.setProperty("hibernate.dialect",
//                "org.hibernate.dialect.MySQL5Dialect");
//        return properties;
//    }
}
package com.omniwyse.springdatajpa.all;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


@Service("multiTenantConnectionProvider")
public class MultiTenantSchemaConnectionProvider implements MultiTenantConnectionProvider {

	private DataSource datasource = TenanatDataSource.getDataSource();
	public MultiTenantSchemaConnectionProvider(){
		
	}


	public boolean isUnwrappableAs(@SuppressWarnings("rawtypes") Class unwrapType) {
		return false;
	}

	public <T> T unwrap(Class<T> unwrapType) {
		return null;
	}

	public Connection getAnyConnection() throws SQLException {
		try {
			return datasource.getConnection();
		} catch (Exception e) {
			throw new SQLException("Datasource can not be found", e);
		}
	}

	public void releaseAnyConnection(Connection connection) throws SQLException {
		connection.close();
		// LOGGER.debug("Connection Released");
	}

	public Connection getConnection(String tenantIdentifier) throws SQLException {
		// LOGGER.debug("Setting connection to " + tenantIdentifier);
		final Connection conn = getAnyConnection();
		conn.createStatement().execute("USE " + tenantIdentifier);
		return conn;
	}

	public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
		// LOGGER.debug("Releasing Connection for {}", tenantIdentifier);
		releaseAnyConnection(connection);
	}

	public boolean supportsAggressiveRelease() {
		return true;
	}

}

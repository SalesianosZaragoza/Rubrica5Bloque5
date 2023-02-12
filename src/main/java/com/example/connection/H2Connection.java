package com.example.connection;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Profile;

@Component
@Profile("h2")
public class H2Connection extends AbstractConnection {

	@Override
	public String getDriver() {
		return "org.h2.Driver";
	}

	@Override
	public String getDatabaseUser() {
		return "sa";
	}

	@Override
	public String getDatabasePassword() {
		return "";
	}

	@Override
	public String getUrl() {
		return "jdbc:h2:file:./src/main/resources/h2/test;INIT=RUNSCRIPT from './src/main/resources/sql/init.sql'";
	}

}

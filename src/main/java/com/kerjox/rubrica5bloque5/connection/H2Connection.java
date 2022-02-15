package com.kerjox.rubrica5bloque5.connection;

import org.springframework.stereotype.Component;

@Component
public class H2Connection extends AbstractConnection {

	@Override
	public String getDriver() {
		return "org.h2.Driver";
	}

	@Override
	public String getUser() {
		return "sa";
	}

	@Override
	public String getPass() {
		return "";
	}
}

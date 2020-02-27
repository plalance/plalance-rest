package com.plalance.configuration;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class RestConfig extends ResourceConfig {

	/**
	 * Scan endpoints ( @Path )
	 */
	public RestConfig()
	{
		packages("com.plalance");
	}
	
}

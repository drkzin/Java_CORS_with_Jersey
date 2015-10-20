package br.com.gunscontrol.controller;

import java.io.IOException;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;

public class Publicador {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws Exception {
		
		ResourceConfig rc = new PackagesResourceConfig("br.com.gunscontrol");
		rc.getProperties().put("com.sun.jersey.spi.container.ContainerResponseFilters",
			    "com.sun.jersey.api.container.filter.LoggingFilter;br.com.gunscontrol.util.CrossDomainFilter");
		HttpServer server = HttpServerFactory.create("http://localhost:8081/", rc);
		server.start();

	}

}

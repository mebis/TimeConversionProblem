package com.masa.tcp.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.masa.tcp.controller.Endpoint;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@Component
public class JerseyConfig extends ResourceConfig {

	@Value("${spring.jersey.application-path:/}")
	private String apiPath;
	
	public JerseyConfig() {
		configureSwagger();
		register(Endpoint.class);
		register(WadlResource.class);
	}
	
	private void configureSwagger() {
        // Available at localhost:port/swagger.json
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);

        BeanConfig config = new BeanConfig();
        config.setConfigId("tcp-service");
        config.setTitle("Time Conversion Problem Service");
        config.setVersion("v1");
        config.setContact("Masa Ebisawa");
        config.setSchemes(new String[] { "http", "https" });
        config.setBasePath("/api");
        config.setResourcePackage("com.masa.tcp.controller");
        config.setPrettyPrint(true);
        config.setScan(true);
    }

}

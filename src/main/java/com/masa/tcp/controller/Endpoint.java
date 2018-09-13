package com.masa.tcp.controller;

import java.text.ParseException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.masa.tcp.service.Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Component
@Path("/tcp")
@Api(value = "Time Conversion Problem Resource")
public class Endpoint {

	Logger logger = LoggerFactory.getLogger(Endpoint.class);
	
	private final Service service;

	public Endpoint(Service service) {
		this.service = service;
	}
	
	@GET
	@Path("{time}")
	@Produces("text/plain")
	@ApiOperation(value="Convert input time of format hh:mm:ss(AM|PM) to HH:mm:ss so it is in 24 hour clock.")
	public String convertTime(@ApiParam(value = "A string time representation in this format: hh:mm:ss(AM|PM)", required = false)@PathParam("time") String time) throws ParseException {
		return service.convertTime(time);
	}

}

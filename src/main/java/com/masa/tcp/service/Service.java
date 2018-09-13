package com.masa.tcp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;;

@Component
public class Service {

	private SimpleDateFormat input = new SimpleDateFormat("hh:mm:ssaa");
	private SimpleDateFormat output = new SimpleDateFormat("HH:mm:ss");
	
	static final Logger logger = LoggerFactory.getLogger(Service.class);
	
	public Service() {
		
	}
	
	public String convertTime(String time) throws ParseException {
		
		Date date = input.parse(time);
		
		return output.format(date);
	}

}

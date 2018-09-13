package com.masa.tcp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;;

@Component
public class Service {

	private static final String[] inputFormat = {"hh:mm:ssaa", "hh:mm:ss:aa"};
	private SimpleDateFormat output = new SimpleDateFormat("HH:mm:ss");
	
	static final Logger logger = LoggerFactory.getLogger(Service.class);
	
	public Service() {
		
	}
	
	public String convertTime(String time) throws ParseException {
		
		if(!checkValidTimeFormat(time)) {
			throw new ParseException("", 0);
		} 
		
		Date date = DateUtils.parseDate(time,inputFormat);
		
		return output.format(date);
	}
	
	private boolean checkValidTimeFormat(String time) {
		final String regexFormat = "(0[0-9]|1?[0-2]):[0-5][0-9]:[0-5][0-9]:?[A|P]M";
		
		return Pattern.matches(regexFormat, time);
	}

}
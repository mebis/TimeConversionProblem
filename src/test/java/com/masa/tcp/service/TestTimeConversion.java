package com.masa.tcp.service;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TestTimeConversion {
	
	Logger logger = LoggerFactory.getLogger(TestTimeConversion.class);

	@TestConfiguration
    static class TimeConversionProblemImplTestContextConfiguration {
  
        @Bean
        public Service service() {
            return new Service();
        }
    }
	
	@Autowired
    private Service service;
	
	@Test
	public void testValid() throws ParseException {
		String date = null;
		
		date = service.convertTime("12:00:00AM");
		Assert.assertTrue("00:00:00".equals(date));
		
		logger.info("12:00:00AM is: "+date);
		
		date = service.convertTime("12:00:00PM");
		Assert.assertTrue("12:00:00".equals(date));
		
		logger.info("12:00:00PM is: "+date);
		
		date = service.convertTime("07:05:45PM");
		Assert.assertTrue("19:05:45".equals(date));
		
		logger.info("07:05:45PM is: "+date);
	}
	
	@Test(expected = ParseException.class)
	public void testInvalidHour() throws ParseException {
		service.convertTime("13:00:00AM");
	}
	
	@Test(expected = ParseException.class)
	public void testInvalidMinute() throws ParseException {
		service.convertTime("11:66:00AM");
	}
	
	@Test(expected = ParseException.class)
	public void testInvalidSeconds() throws ParseException {
		service.convertTime("11:33:77AM");
	}
	
	@Test(expected = ParseException.class)
	public void testInvalidAMPM() throws ParseException {
		service.convertTime("11:33:77SS");
	}

}

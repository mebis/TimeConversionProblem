package com.masa.tcp.service;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TestTimeConversion {

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
	public void test() throws ParseException {
		
		String date = null;
		
		if(service != null) {
			date = service.convertTime("10:43:57PM");
		}
		
		System.out.println("DATE is: "+date);
		
		Assert.assertTrue("22:43:57".equals(date));
	}

}

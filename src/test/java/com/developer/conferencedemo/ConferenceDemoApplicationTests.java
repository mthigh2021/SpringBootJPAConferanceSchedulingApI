package com.developer.conferencedemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.developer.conferencedemo.ConferenceDemoApplication;
@SpringBootTest
class ConferenceDemoApplicationTests {

	@Test
	void contextLoads() {
		try
		{
			String name ="dipak";
			ConferenceDemoApplication con = new ConferenceDemoApplication();
			con.main(new String[] {"asds",""});
		}
		catch(Exception e)
		{
			String s = e.toString();
		}

	}
	@Test
	void contextLoads2() {
		try
		{
			String name ="dipak";
			ConferenceDemoApplication con = new ConferenceDemoApplication();
			con.main(new String[] {"asds",""});
		}
		catch(Exception e)
		{
			String s = e.toString();
		}

	}
}

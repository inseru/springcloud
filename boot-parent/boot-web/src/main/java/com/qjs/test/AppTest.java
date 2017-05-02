package com.qjs.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.qjs.boot.Application;
import com.qjs.properties.CommonProperties;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = Application.class)
public class AppTest {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CommonProperties commonProperties;

	@Test
	public void test1() {

	}

}

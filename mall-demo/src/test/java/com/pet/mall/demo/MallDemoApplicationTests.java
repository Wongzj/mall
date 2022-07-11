package com.pet.mall.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pet.mall.model.PmsProduct;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MallDemoApplicationTests {
	private Logger logger = LoggerFactory.getLogger(MallDemoApplicationTests.class);
	@Test
	public void contextLoads() {
	}

	@Test
	public void testLogStash() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		PmsProduct product = new PmsProduct();
		product.setId(1L);
		product.setName("Xiaomi phone");
		product.setBrandName("Xiaomi");
		logger.info(mapper.writeValueAsString(product));
		logger.error(mapper.writeValueAsString(product));
	}

}

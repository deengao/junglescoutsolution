package com.deengao.apr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.deengao.apr.service.AmazonProductService;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final Logger logger = LoggerFactory.getLogger(DataLoader.class);
	
	@Autowired
	private AmazonProductService amazonProductService;
	
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("app init product cache data...");
		amazonProductService.initAmazonProductCache();
		logger.info("app init product cache data done...");
	}

}

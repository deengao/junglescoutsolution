package com.deengao.apr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deengao.apr.model.AmazonProduct;
import com.deengao.apr.repository.AmazonProductRepository;


@Service
public class AmazonProductService {
	
	private final Logger logger = LoggerFactory.getLogger(AmazonProductService.class);

	@Autowired
	private AmazonProductRepository amazonProductRepository;
	
	@Autowired 
	private AmazonProductExtractByWebScraperService amazonProductExtractByWebScraperService;
	
	private Map<String, AmazonProduct> amazonProductsCache = new HashMap<>(); 
	
	public void initAmazonProductCache () {
		List<AmazonProduct> products = this.amazonProductRepository.findAll();
		for(AmazonProduct p: products) {
			amazonProductsCache.put(p.getAsin(), p);
		}
	}
	
	private AmazonProduct extractStoreAmazonProductByASIN(String asin) {
		AmazonProduct product = amazonProductExtractByWebScraperService.extractAmazonProductByASIN(asin);
		this.amazonProductRepository.save(product);
		amazonProductsCache.put(asin, product);
		return product;
	}
	
	
	public AmazonProduct getAmazonProductByASIN(String asin) {
		if(amazonProductsCache.containsKey(asin)) {
			logger.debug("get product from caches");
			return amazonProductsCache.get(asin);
		}else {
			AmazonProduct product  = this.amazonProductRepository.findByAsin(asin);
			if(product != null) {
				logger.debug("get product from db");	
				return product;
			}
			logger.debug("get product from amazon");
			product = extractStoreAmazonProductByASIN(asin);
			return product;
			
		}
	}
	
	public List<AmazonProduct> getAllAmazonProducts() {
		return this.amazonProductRepository.findAll();
	}
}

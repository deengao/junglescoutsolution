package com.deengao.apr.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.deengao.apr.model.AmazonProduct;
import com.deengao.apr.service.AmazonProductService;


@RestController
@RequestMapping("/amazonProduct")
public class AmazonProductController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private AmazonProductService amazonProductService;
	
	@GetMapping("/getAmazonProduct")
	@ResponseStatus(value = HttpStatus.OK)
	public AmazonProduct getAmazonProduct(@RequestParam String asin) {
		return amazonProductService.getAmazonProductByASIN(asin);
	}
	
	@GetMapping("/getAmazonProducts")
	@ResponseStatus(value = HttpStatus.OK)
	public List<AmazonProduct> getAmazonProducts() {
		return amazonProductService.getAllAmazonProducts();
	}

}

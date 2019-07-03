package com.deengao.apr.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import com.deengao.apr.config.AmazonProductEndpoints;
import com.deengao.apr.config.AmazonProductFieldKeyWords;
import com.deengao.apr.model.AmazonProduct;

// stub service for using amazon ad api 
@Service
public class AmazonProductExtractByApiService implements AmazonProductExtract{
	
	protected final Log logger = LogFactory.getLog(getClass());

	public AmazonProduct extractAmazonProductByASIN(String _asin) {
		return null;
	}


}

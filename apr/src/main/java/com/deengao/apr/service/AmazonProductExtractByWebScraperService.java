package com.deengao.apr.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

@Service
public class AmazonProductExtractByWebScraperService implements AmazonProductExtract {

	protected final Log logger = LogFactory.getLog(getClass());

	public AmazonProduct extractAmazonProductByASIN(String _asin) {

		System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(AmazonProductEndpoints.AMAZONPRODUCTENPOINT + _asin);
		Document doc = Jsoup.parse(driver.getPageSource());

		AmazonProduct product = new AmazonProduct();
		product.setAsin(_asin);

		Element productName = doc.getElementById(
				AmazonProductFieldKeyWords.AmazonProductFieldKeyWordsMap.get(AmazonProductFieldKeyWords.TITLE));
		if (productName != null) {
			logger.debug(productName.text());
			product.setProductTitle(productName.text());
		}

		Elements ranks = doc.getElementsContainingOwnText(
				AmazonProductFieldKeyWords.AmazonProductFieldKeyWordsMap.get(AmazonProductFieldKeyWords.RANK));
		if (ranks.size() > 0) {
			Element rank = ranks.first();
			logger.debug(rank.text());
			String rankText = rank.nextElementSibling().text();
			logger.debug(rankText);
			product.setRank(extractRankFromRankText(rankText));
			product.setCategory(extractCategoryFromRankText(rankText));
		}

		Elements dimensions = doc.getElementsContainingOwnText(
				AmazonProductFieldKeyWords.AmazonProductFieldKeyWordsMap.get(AmazonProductFieldKeyWords.DIMENSIONS));
		for(Element dimension: dimensions) {
			if(dimension.text().contains(AmazonProductFieldKeyWords.DIMENSIONS_SKIP)) {
				continue;
			}else {
				logger.debug(dimension.text());
				logger.debug(dimension.nextElementSibling().text());
				product.setDimensions(dimension.nextElementSibling().text());
				break;
			}
		}
		

		driver.close();

		return product;

	}

	private String extractCategoryFromRankText(String rankText) {
		String category = rankText.split("(#\\d+(,\\d+)*\\sin\\s)")[1].split("\\(")[0].trim();
		return category;
	}

	private String extractRankFromRankText(String rankText) {
		Pattern p = Pattern.compile("(#\\d+(,\\d+)*)");
		Matcher m = p.matcher(rankText);
		if (m.find()) {
			return m.group();
		}
		return null;
	}

}

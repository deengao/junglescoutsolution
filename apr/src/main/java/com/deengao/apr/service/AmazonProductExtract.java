package com.deengao.apr.service;

import com.deengao.apr.model.AmazonProduct;

public interface AmazonProductExtract {

	public AmazonProduct extractAmazonProductByASIN(String _asin);
}

package com.deengao.apr.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AmazonProductFieldKeyWords {

	public static String ASIN = "ASIN";
	public static String DIMENSIONS = "DIMENSIONS";
	public static String DIMENSIONS_SKIP = "Item Dimensions";
	public static String TITLE = "TITLE";
	public static String RANK = "RANK";
	
	
	public static Map<String,String> AmazonProductFieldKeyWordsMap;
	
	static {
        Map<String, String> keywordsMap = new HashMap<>();
        keywordsMap.put(ASIN, "ASIN");
        keywordsMap.put(DIMENSIONS, "Dimensions");
        keywordsMap.put(TITLE, "productTitle");
        keywordsMap.put(RANK, "Best Sellers Rank");
        AmazonProductFieldKeyWordsMap = Collections.unmodifiableMap(keywordsMap);
    }
	
	
}

package com.deengao.apr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AmazonProduct")
public class AmazonProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;
	
	@Column(name = "TITLE", nullable = false)
	private String productTitle;
	
	@Column(name = "ASIN", nullable = false)
	private String asin;
	
	@Column(name = "CATEGORY", nullable = false)
	private String category;
	
	@Column(name = "RANK", nullable = false)
	private String rank;
	
	@Column(name = "DIMENSIONS", nullable = false)
	private String dimensions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAsin() {
		return asin;
	}
	
	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}


	public void setAsin(String asin) {
		this.asin = asin;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	
}

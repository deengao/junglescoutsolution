package com.deengao.apr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deengao.apr.model.AmazonProduct;


@Repository
public interface AmazonProductRepository extends JpaRepository<AmazonProduct, Long>  {
	
	public AmazonProduct findByAsin(String asin);

}

package com.capgemini.productapp.repository;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.capgemini.productapp.entity.Product;

public interface ProductRepository extends MongoRepository<Product, Integer>{

	

	@Query("{'productName': ?0}")
	public List<Product> findByProductName(String productName);
	
	@Query("{'productPrice': {'$lt' : 50000}}")
	public List<Product> findByProductPrice();
	
	@Query("{'productPrice' : { '$lt' : 20000}, '$and' :[{'productCategory' : ?0 }]}")
	public List<Product> findByCategoryAndPrice(String productCategory);
	
	@Query("{'productPrice' : { '$lt' : 50000}, '$and' :[{'productPrice' : { '$gte' : 10000}}]}")
	public List<Product> findByPriceInterval();
	
	@Query("{'productPrice' : { '$lt' : ?0}, '$and' :[{'productPrice' : { '$gt' : ?1}}]}")
	public List<Product> findProductByPriceInterval(double upperbound,double lowerbound);
	
	
	
	
}

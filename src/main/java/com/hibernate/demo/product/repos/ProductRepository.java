package com.hibernate.demo.product.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

//import org.springframework.data.repository.CrudRepository;


import com.hibernate.demo.product.entities.Product;

//**************** CRUD Repository ********************************

//public interface ProductRepository extends CrudRepository<Product, Integer> {
//	
//	//// to choose the third one which takes a string product name and it returns a list of product and at runtime
//	
//	List<Product> findByName(String name);
//	
//	//multiple columns by the Finder method
//	
//	List<Product> findByNameAndDesc(String name, String desc);
//	
//	List<Product> findByPriceGreaterThan(Double price);
//	
//	//find all the products that contain a word a particular word in its description.
//	
//	List<Product> findByDescContains(String desc);
//	
//	//find range of product : Between
//	
//	List<Product> findByPriceBetween(Double price1, Double price2);
//
//	//Like
//	List<Product> findByDescLike(String desc);
//	
//	//In
//	List<Product> findByIdIn(List<Integer> id);
//
// List<Product> findByIdIn(List<Integer> id, Pageable pageable);
//	
//}


// Paging and Sorting

//public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
	
	

}
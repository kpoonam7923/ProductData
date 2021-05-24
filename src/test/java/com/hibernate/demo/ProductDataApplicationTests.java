package com.hibernate.demo;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.querydsl.QPageRequest;

import com.hibernate.demo.product.entities.Product;
import com.hibernate.demo.product.repos.ProductRepository;


@SpringBootTest
class ProductDataApplicationTests {
	
	// Now from this EntityManager we can get access to the hibernate session so that we can work with level 1 cache and remove objects from the cache
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	ProductRepository repos;


//	@Test
//	void contextLoads() {
//	}
//	
//	//create
//	@Test
//	public void testCreate() {
//		Product p = new Product();
//		p.setId(1);
//		p.setName("DEF");
//		p.setDesc("Working");
//		p.setPrice(1000d);
//		repos.save(p);
//		
//		Product p1 = new Product();
//		p1.setId(2);
//		p1.setName("ABC");
//		p1.setDesc("Processed");
//		p1.setPrice(4000d);
//		repos.save(p1); //Insert SQL
//	}
//	
//	//read CRUD operation
//	@Test
//	public void testRead() {
//		//fetch or read data from DB
//		Product p1 = repos.findById(2).get();
//		//assertNotNull(p);
//		//assertEquals("ABC", p.grtname());
//		
//		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>" + p1.getDesc());
//		
//	}
//	
//	//update CRUD operation
//	
//	@Test
//	public void testUpdate() {
//		
//		Product p = repos.findById(1).get();
//		p.setPrice(15000d);
//		repos.save(p); // update SQL
//		
//	}
//	
//	//Delete CRUD operation
//	
//	@Test
//	public void testDelete() {
//		Product p = repos.findById(1).get();
//		if(repos.existsById(1)) {
//			System.out.println("Deleting ID");
//			repos.deleteById(1);
//		}
//		
//	}
//	
//	@Test
//	public void testCount() {
//		System.out.println("Total records ========== >>>>>>>>>>>>>>>>" + repos.count());
//	}
//	
//	@Test
//	public void testFindBynameAnddesc() {
//		// to choose the third one which takes a string product name and it returns a list of product and at runtime
//		List<Product> products = repos.findByNameAndDesc("ABC","Processed");
//		//iterate through products and use lambda expression
//		products.forEach(p -> System.out.println(">>>>>>>>>>>>>>>>" + p.getPrice()));
//	}
//	
//	@Test
//	public void testFindByPriceGreaterThan() {
//		List<Product> products = repos.findByPriceGreaterThan(1000d);
//		//iterate through products and use lambda expression
//		products.forEach(p -> System.out.println(">>>>>>>>>>>>>>>>" + p.getPrice() + "   " + p.getName()));
//	}
//	
//	@Test
//	public void testFindByContain() {
//		List<Product> products = repos.findByDescContains("g");
//		products.forEach(p -> System.out.println(">>>>>>>>>>>>>>>>" + p.getPrice() + "   " + p.getName()));
//	}
//	
//	@Test
//	public void testFindByPriceBetween() {
//		List<Product> products = repos.findByPriceBetween(1000d, 7000d);
//		//iterate through products and use lambda expression
//		products.forEach(p -> System.out.println(">>>>>>>>>>>>>>>>" + p.getPrice() + "   " + p.getName()));
//	}
//	
//	@Test
//	public void testFindByDescLike() {
//		List<Product> products = repos.findByDescLike("%%g");
//		products.forEach(p -> System.out.println(">>>>>>>>>>>>>>>>" + p.getPrice() + "   " + p.getName()));
//	}
//	
//	@Test
//	public void testFindByIDsIN() {
//		List<Product> products = repos.findByIdIn(Arrays.asList(1,2,3,8));
//		products.forEach(p -> System.out.println(">>>>>>>>>>>>>>>>" + p.getId() + "   " + p.getName()));
//	}
	
	// PAGING AND SORTING within CRUD repository
	
//	@Test
//	public void testFindByIDsIN() {
//		Pageable pageable = new RequestPageable(0, 1);
//		List<Product> products = repos.findByIdIn(Arrays.asList(1,2,3,8), pageable);
//		products.forEach(p -> System.out.println(">>>>>>>>>>>>>>>>" + p.getId() + "   " + p.getName()));
//	}
	
	// ******************* PAGING AND SOrtING ***************************** 
	
//	@Test
//	public void testFindAllPaging() {
//		
////		Pageable pageable = new RequestPageable(0, 1);
////		Page<Product> results = repos.findAll(pageable);
////		results.forEach(p -> System.out.println(">>>>>>>>>>>>>>>>" + p.getId() + "   " + p.getName()));
//		
//		Pageable pageable = new QPageRequest(0, 1);
//		Page<Product> findAll = repos.findAll(pageable);
//		findAll.forEach(p -> System.out.println(">>>>>>>>>>>>>>>>>" + p.getName() ));
//		
//	}
	
//	@Test
//	public void testSorting() {
//		repos.findAll(new Sort(Direction.DESC, "name")).forEach(p -> System.out.println(">>>>>>>>>>>>>>>>" + p.getName()));
//	}
	
//	@Test
//	public void testSortingOrder() {
//		Iterable<Product> findAll = repos.findAll(new Sort(new Order(Direction.DESC, "name"), new Sort.Order("price")));
//	}
	
//	@Test
//	public void testPagingAndSorting() {
//		
//		//Pageable pageable = new PageRequest(page, size, direction, properties);
//		Pageable pageable = new PageRequest(0, 2, Direction.DESC, "name");
//		repos.findAll(pageable).forEach(p -> System.out.println(">>>>>>>>>>>" +p.getName()));
//	}
	
	// ******************** LEVEL 1 CACHIING ********************
	@Test
	//When we use Trasaction anotation, select query will run only once.
	@Transactional
	public void testCaching() {
		repos.findById(1);
		// once fetched from db, now it will store it into cache
		repos.findById(1);
	}
	
	// ************************* EVICT METHOD IN LEVEL 1 ******************************
	
//	@Test
//	@Transactional
//	public void testCaching() {
//		
//		//To access the hibernate session, We need to use entity manager that we have injected dot unwrap ,
//		//there is a method called unwrap which takes session 
//		//takes "Session.class" as the type, this is the object which we want to unwrap
//		Session session = entityManager.unwrap(Session.class);
//		
//		Product p = repos.findByOne(1);
//		
//		//below won't be fetches from db since it is already in Cache, Hence only once "select" query will run
//		repos.findById(1);
//		
//		//it will remove that product(p) from the level 1 cache.
//		session.evict(p);
//		
//		//Since we have used evict it will delete Session 1, level 1 object from cache and again "select" query will be executed
//		repos.findById(1);
//	}
	
	
}

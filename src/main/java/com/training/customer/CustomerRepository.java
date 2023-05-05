package com.training.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	@Query(value="select * from customer where purchase_value>=?",nativeQuery=true)
	public List<Customer> getByPurchaseValue(int value1);
	
	@Query(value="select gender from customer where purchase_value>=? and purchase_value<=?",nativeQuery=true)
	public List<String> getByPurchaseGender(int value1,int value2);
	
	@Query(value="select contact_number from customer where mail_id like % ? %",nativeQuery=true)
	public List<Long> getByConNum(String mailId);

	@Query(value = "select * from customer where name=?", nativeQuery = true)
	public List<Customer> getByName(String name);

	@Query(value = "select * from customer where gender=?", nativeQuery = true)
	public List<Customer> getByGender(String gender);

	@Query(value = "select * from customer where mail_id=?", nativeQuery = true)
	public Customer getByMailId(String mail);

	@Query(value = "select * from customer where contact_number=?", nativeQuery = true)
	public Customer getByContactNumber(long num);

	@Query(value = "select * from customer where purchase_value>=50000", nativeQuery = true)
	public List<Customer> maximumCustomer();

	@Query(value = "select * from customer where mail_id like '%gmail.com'", nativeQuery = true)
	public List<Customer> getGmailId();

	@Query(value = "select contact_number from customer where mail_id=?", nativeQuery = true)
	public long getByMaill(String name);

	@Query(value = "select * from customer where purchase_value>=? and purchase_value<=?", nativeQuery = true)
	public List<Customer> purchasingDetails(int num1, int num2);

	@Query(value = "select name from test_db.customer where mail_id like %?%", nativeQuery = true)
	public List<String> namesByNumbers(String mail);

}


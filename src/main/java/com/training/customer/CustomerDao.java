package com.training.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDao {
	@Autowired
	CustomerRepository cusRepo;
	public String addCustomer(Customer cus) {
		cusRepo.save(cus);
		return "successfully saved";
	}

	public Customer getcusById(int id) {
		return cusRepo.findById(id).get();
	}
	public String updateCustomer(Customer id) {
		cusRepo.save(id);
		return "updated";
	}
	public String deleteCusById(int Id) {
		cusRepo.deleteById(Id);
		return "Successfully deleted";
	}
	
    public List <Customer> getAllCus() {
		return cusRepo.findAll();
	} 
    public List<Customer> getByPurchaseValue(int value) {
		return cusRepo.getByPurchaseValue(value);
	}

	public List<String> getByPurchaseGender(int value1, int value2) {
		return cusRepo.getByPurchaseGender(value1, value2);
	}

	public List<Long> getByConNum(String mailId) {
	return cusRepo.getByConNum(mailId);
	}
	
	//exceptions
	
	
	public List<Customer> getByName(String name) {
      return cusRepo.getByName(name);
	}

	public List<Customer> getByGender(String gender) {
      return cusRepo.getByGender(gender);
	}

	public Customer getByMailId(String mail) {
		return cusRepo.getByMailId(mail);
	}

	public Customer getByContactNumber(long num) {
     return cusRepo.getByContactNumber(num);
	}

	public List<Customer> maximumPurchaser() {
      return cusRepo.maximumCustomer();
	}

	public List<Customer> gmailId() {
      return cusRepo.getGmailId();
	}

	public long gmailByPhone(String mail) {
      return cusRepo.getByMaill(mail);
	}

	public List<Customer> purchasingDetails(int num1, int num2) {
       return cusRepo.purchasingDetails(num1, num2);
	}

	public List<String> getNamesByMail(String mail) {
      return cusRepo.namesByNumbers(mail);
	}

}


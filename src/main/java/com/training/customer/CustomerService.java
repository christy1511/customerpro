package com.training.customer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.customer.Exception.ContactNumberException;
import com.training.customer.Exception.CustomerMailIdException;
import com.training.customer.Exception.CustomerNameNotFoundByException;
import com.training.customer.Exception.CustomerNoGenderException;
import com.training.customer.Exception.GmailIdException;
import com.training.customer.Exception.MaximumPurchaseException;
import com.training.customer.Exception.PurchaseDetailException;



@Service
public class CustomerService {
	@Autowired
	CustomerDao cusDao;
	public String addCustomer(Customer cus) {
		return cusDao.addCustomer(cus);
	}

	public Customer getcusById(int id) {
		return cusDao.getcusById(id);
	}
	public String updateCustomer(Customer id) {
		return cusDao.updateCustomer(id);
	}
	public String deleteCusById(int id) {
		return cusDao.deleteCusById(id);
	}

	
	  public List<Customer> getByName(String name) {
			List<Customer> all=cusDao.getAllCus();
			List<Customer> results=all.stream().filter(x-> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
			return results;
		}
		 public List<Customer> getById(int id) {
				List<Customer> all=cusDao.getAllCus();
				List<Customer> results=all.stream().filter(x-> x.getId()==id).collect(Collectors.toList());
				return results;
			}


		public List<Customer> getByPurchase(int value) {
			List<Customer> all=cusDao.getAllCus();
			List<Customer> results=all.stream().filter(x-> x.getPurchaseValue()==value).collect(Collectors.toList());
			return results;
		}


		public List<Customer> getByGender(String gender) {
			List<Customer> all=cusDao.getAllCus();
			List<Customer> results=all.stream().filter(x-> x.getGender().equalsIgnoreCase(gender)).collect(Collectors.toList());
			return results;
		}


		public List<Customer> getByMailId(String mailId) {
			List<Customer> all=cusDao.getAllCus();
			List<Customer> results=all.stream().filter(x-> x.getMailId().equalsIgnoreCase(mailId)).collect(Collectors.toList());
			return results;
		}


		public List<Customer> getByContactNumber(long number) {
			List<Customer> all=cusDao.getAllCus();
			List<Customer> results=all.stream().filter(x-> x.getContactNum()==number).collect(Collectors.toList());
			return results;
		}


		
		public List<Customer> getByPurchaseValue(int value) {
			return cusDao.getByPurchaseValue(value);
		}
		
		public List<String> getByPurchaseGender(int value1,int value2) {
			return cusDao.getByPurchaseGender(value1,value2);
		}


		public List<Long> getByConNum(String mailId) {
			return cusDao.getByConNum(mailId);
		}
		
		
		//exceptions
		
		public List<Customer> getByName1(String name) throws CustomerNameNotFoundByException {
			List<Customer> allEmp = cusDao.getByName(name);
			if (allEmp.isEmpty()) {
				throw new CustomerNameNotFoundByException();
			}

			else {
				return cusDao.getByName(name);
			}
		}

		public List<Customer> getByGender1(String gender) throws CustomerNoGenderException {
			List<Customer> allEmp = cusDao.getByGender(gender);
			if (allEmp.isEmpty()) {
				throw new CustomerNoGenderException();
			} else {
				return cusDao.getByGender(gender);
			}
		}

		public Customer getByMailId1(String mail) throws CustomerMailIdException {
			List<Customer> val = cusDao.getMailId();
			boolean email = true;
			for (Customer x : val) {
				if (x.getMailId().equals(mail)) {
					email = false;
				}
			}
			if (email == true) {
				throw new CustomerMailIdException();
			} else {

				return cusDao.getByMailId(mail);
			}
		}

		public Customer getByContactNumber1(long num) throws ContactNumberException {
			List<Customer> val = cusDao.getContactNumber();
			Customer temp = null;
			for (Customer x : val) {
				if (x.getContactNumber() != num) {
					temp = cusDao.getByContactNumber(num);
				} else {
					throw new ContactNumberException();
				}
			}
			return temp;

		}

		public List<Customer> maximumPurchase() throws MaximumPurchaseException {
			if (cusDao.maximumPurchaser().isEmpty()) {
				throw new MaximumPurchaseException();
			} else {
				return cusDao.maximumPurchaser();
			}
		}

		public List<Customer> gmailId() throws GmailIdException {
			List<Customer> aa = cusDao.gmailId();
			if (aa.isEmpty()) {
				throw new GmailIdException();
			} else {

				return cusDao.gmailId();
			}
		}

		public long gmailByPhone(String mail) {

			return cusDao.gmailByPhone(mail);
		}

		public List<Customer> purchasingDetails(int num1, int num2) throws PurchaseDetailException {
			if (cusDao.purchasingDetails(num1, num2).isEmpty()) {
				throw new PurchaseDetailException();
			} else {

				return cusDao.purchasingDetails(num1, num2);
			}
		}

		public List<String> getNamesByMail(String mail) {

			return cusDao.getNamesByMail(mail);
		}


		 

}

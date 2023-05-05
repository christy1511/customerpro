package com.training.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.customer.Exception.ContactNumberException;
import com.training.customer.Exception.CustomerMailIdException;
import com.training.customer.Exception.CustomerNameNotFoundByException;
import com.training.customer.Exception.CustomerNoGenderException;
import com.training.customer.Exception.CustomerNotFoundById;
import com.training.customer.Exception.GmailIdException;
import com.training.customer.Exception.MaximumPurchaseException;
import com.training.customer.Exception.PurchaseDetailException;



@RestController
public class CustomerController {
	@Autowired
	CustomerService cusSer;
	
	@PostMapping(value = "/addCusto")
	public String addCustomer(@RequestBody Customer cus) {
		return cusSer.addCustomer(cus);

	}

	@GetMapping(value = "/getCusto/{id}")
	public Customer getCusById(@PathVariable int id) {
		return cusSer.getcusById(id);
	}
	
	 @PutMapping(value = "/updateCus/{id}")
	   public String updateCustomer(@RequestBody Customer id) {
		  return cusSer.updateCustomer(id);
	   }
	
	@DeleteMapping(value = "/delete/{id}")
    public String deleteCusById(@PathVariable int id) {
	  return cusSer.deleteCusById(id);
   }
	
	
	@GetMapping(value="/getByName/{name}") 
	public List<Customer>getByName(@PathVariable String name) {
		return cusSer.getByName(name);
		}
    @GetMapping(value = "/getById/{id}")
    public List<Customer>getById(@PathVariable int id) {
    	return cusSer.getById(id);
    }
    @GetMapping(value = "/getByPurchase/{value}") 
    public List<Customer>getByPurchase(@PathVariable int purchaseValue) {
    	return cusSer.getByPurchase(purchaseValue);
    		}
    @GetMapping(value = "/getByGender/{gender}")
    public List<Customer>getByGender(@PathVariable String gender) {
    	return cusSer.getByGender(gender);
    }
    @GetMapping(value = "/getByMailId/{name}")
    public List<Customer>getByMailId(@PathVariable String mailId) {
    	return cusSer.getByMailId(mailId);
    }
    @GetMapping(value = "/getByContactNumber/{number}")
    		public List<Customer>getByContactNumber(@PathVariable long number) {
    	return cusSer.getByContactNumber(number);
    }
    @GetMapping(value = "/getByPurchaseValue{value}")
    public List<Customer>getByPurchaseValue(@PathVariable int value) {
    	return cusSer.getByPurchaseValue(value); 
    }
    @GetMapping(value = "/getByPurchaseGender/{value1}/{value2}") 
    	public List<String>getByPurchaseGender(@PathVariable int value1,@PathVariable int value2) {
    		return cusSer.getByPurchaseGender(value1,value2);
    	}
    	@GetMapping(value = "/getByConNum/{mailId}")
    	public List<Long>getByConNum(@PathVariable String mailId) {
        return cusSer.getByConNum(mailId);
    }
    	
    	//exceptions
    	
    	@GetMapping(value = ("/getByName1/{name}"))
    	public List<Customer> getByName1(@PathVariable String name) throws CustomerNameNotFoundByException {
    		return cusSer.getByName1(name);
    	}

    	@GetMapping(value = ("/getByGender/{gender}"))
    	public List<Customer> getByGender1(@PathVariable String gender) throws CustomerNoGenderException {
    		return cusSer.getByGender1(gender);
    	}

    	@GetMapping(value = ("/getByMailId1/{mail}"))
    	public Customer getByMailId1(@PathVariable String mail) throws CustomerMailIdException {
    		return cusSer.getByMailId1(mail);
    	}

    	@GetMapping(value = ("/getByContactNumber/{num}"))
    	public Customer getByContactNumber1(@PathVariable long num) throws ContactNumberException {
    		return cusSer.getByContactNumber1(num);
    	}

    	@GetMapping(value = ("/maximumPurchaser"))
    	public List<Customer> maximumPurchase() throws MaximumPurchaseException {
    		return cusSer.maximumPurchase();
    	}

    	@GetMapping(value = ("/gmailId"))
    	public List<Customer> gmailId() throws GmailIdException {
    		return cusSer.gmailId();
    	}

    	@GetMapping(value = ("/gmailByPhone/{mail}"))

    	public long gmailByPhone(@PathVariable String mail) {
    		return cusSer.gmailByPhone(mail);
    	}

    	@GetMapping(value = ("/purchase/{num1}/{num2}"))
    	public List<Customer> purchasingDetails(@PathVariable int num1, @PathVariable int num2) throws PurchaseDetailException {
    		return cusSer.purchasingDetails(num1, num2);
    	}

    	@GetMapping(value = ("/getnamesByMail/{mail}"))
    	public List<String> getNamesByMail(@PathVariable String mail) {
    		return cusSer.getNamesByMail(mail);
    	}

    }
    

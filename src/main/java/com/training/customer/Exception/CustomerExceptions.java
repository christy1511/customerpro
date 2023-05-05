package com.training.customer.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class CustomerExceptions {

	@ExceptionHandler(CustomerNotFoundById.class)
	public ResponseEntity<Object> idNotFound() {
		return new ResponseEntity<>("No Data in this Id", HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(CustomerNameNotFoundByException.class)
	public ResponseEntity<Object> nameNotFound() {
		return new ResponseEntity<>("No Date In this Name", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomerNoGenderException.class)
	public ResponseEntity<Object> genderNotFound() {
		return new ResponseEntity<>("No Data in this Id", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomerMailIdException.class)
	public ResponseEntity<Object> mailIdNotFound() {
		return new ResponseEntity<>("The Mail Id Is Is Not Present In the List", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MaximumPurchaseException.class)
	public ResponseEntity<Object> maximumException() {
		return new ResponseEntity<>("No Datas occured", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(GmailIdException.class)
	public ResponseEntity<Object> gmailIDRxception() {
		return new ResponseEntity<>("ERROR", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PurchaseDetailException.class)
	public ResponseEntity<Object> PurchaseException() {
		return new ResponseEntity<>("MUST ENTER TWO NUMBERS", HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(ContactNumberException.class)
	public ResponseEntity<Object> contactNumber() {
		return new ResponseEntity<>("TYPE CORRECT", HttpStatus.NOT_FOUND);
	}

}
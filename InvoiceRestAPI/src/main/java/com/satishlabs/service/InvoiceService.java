package com.satishlabs.service;

import java.util.List;
import java.util.Optional;

import com.satishlabs.entity.Invoice;

public interface InvoiceService {
	/**
	 * Takes Invoice Object as input and returns PK generated
	 */
	Long saveInvoice(Invoice inv);
	
	/**
	 * Takes existing Invoice data as input and updates values
	 */
	public void updateInvoice(Invoice e);
	
	/**
	 * Takes PK(ID) as input and deletes Invoice Object data
	 */
	public void deleteInvoice(Long id);
	
	/**
	 * Takes id as input and returns one row as one object
	 */
	Invoice getOneInvoice(Long id);
	/**
	 * select all rows and provides result as a List<Invoice>
	 */
	Optional<Invoice> getSingleInvoice(Long Id);
	/**
	 * Takes id as input and returns one row as one object
	 */
	List<Invoice> getAllInvoices();
	/**
	 * Takes Id as input,checks if record exists returns true, else false
	 * 
	 */
	boolean isInvoiceExist(Long id);
	
	/**
	 * Takes 2 fields as input, updates Invoice data as provided where clause
	 * like 'UPDATE Invoice SET number=:number WHERE id=:id'
	 */
	Integer updateInvoiceNumberById(String number,Long id);
}

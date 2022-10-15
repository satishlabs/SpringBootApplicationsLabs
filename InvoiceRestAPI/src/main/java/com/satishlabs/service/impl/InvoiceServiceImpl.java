package com.satishlabs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satishlabs.entity.Invoice;
import com.satishlabs.exception.InvoiceNotFoundException;
import com.satishlabs.repository.InvoiceRepository;
import com.satishlabs.service.InvoiceService;
import com.satishlabs.util.InvoiceUtil;

@Service
public class InvoiceServiceImpl implements InvoiceService{
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private InvoiceUtil util;

	@Override
	public Long saveInvoice(Invoice inv) {
		util.CalculateFinalAmountIncludingGST(inv);
		Long id = invoiceRepository.save(inv).getId();
		return id;
	}

	@Override
	public void updateInvoice(Invoice inv) {
		util.CalculateFinalAmountIncludingGST(inv);
		invoiceRepository.save(inv);
		
	}

	@Override
	public void deleteInvoice(Long id) {
		Invoice inv= getOneInvoice(id);
		invoiceRepository.delete(inv);
	}
	
	public Optional<Invoice> getSingleInvoice(Long Id) {
		return invoiceRepository.findById(Id);
	}


	@Override
	public Invoice getOneInvoice(Long id) {
		Invoice inv = invoiceRepository.findById(id).orElseThrow(()->new InvoiceNotFoundException(
				new StringBuffer().append("Product '")
				.append(id)
				.append("' not exits")
				.toString())
				);
		
		return inv;
	}

	@Override
	public List<Invoice> getAllInvoices() {
		List<Invoice> list = invoiceRepository.findAll();
		//JDK 1.8 List Sort (using Comparator)
		list.sort((obj1,obj2)->obj1.getId().intValue()-obj2.getId().intValue());
		//list.sort((obj1,obj2)->obj1.getAmount().compareTo(obj2.getAmount())); //ASC
		//list.sort((obj1,obj2)->obj2.getAmount().compareTo(obj1.getAmount()));//DESC
		return list;
	}

	@Override
	public boolean isInvoiceExist(Long id) {
		return invoiceRepository.existsById(id);
	}

	@Override
	public Integer updateInvoiceNumberById(String number, Long id) {
		if(!invoiceRepository.existsById(id)) {
			throw new InvoiceNotFoundException(
					new StringBuffer()
					.append("Invoice '")
					.append(id)
					.append("' not exist")
					.toString()
					);
		}
		return invoiceRepository.updateInvoiceNumberById(number,id);
	}

}

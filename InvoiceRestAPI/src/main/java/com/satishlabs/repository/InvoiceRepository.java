package com.satishlabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.satishlabs.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
	
	// Update is Non-Select Operation, so @Modifying is used
	@Modifying
	@Query("UPDATE Invoice SET number=:number WHERE id=:id")
	Integer updateInvoiceNumberById(String number, Long id);

}

package com.satishlabs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.satishlabs.repository.InvoiceRepository;
import com.satishlabs.service.ExcelPoijiService;

@Component
public class ExcelDataUploadRunner implements CommandLineRunner{
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private ExcelPoijiService excelPoijiService;
	
	@Override
	public void run(String... args) throws Exception {
		invoiceRepository.saveAll(excelPoijiService.getListFromExcelData());
		
	}

}

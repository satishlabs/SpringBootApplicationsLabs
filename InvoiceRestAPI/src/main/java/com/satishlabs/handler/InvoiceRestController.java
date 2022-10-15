package com.satishlabs.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satishlabs.entity.Invoice;
import com.satishlabs.service.InvoiceService;
import com.satishlabs.util.InvoiceUtil;

@RestController
@RequestMapping("/api")
// @CrossOrigin(origins = "http://localhost:4200") //Required in case of Angular Client
public class InvoiceRestController {
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private InvoiceUtil util;
	
	@PostMapping("/invoices")
	public ResponseEntity<String> saveInvoice(@RequestBody Invoice invoice){
		ResponseEntity<String> resp = null;
		try {
			Long id = invoiceService.saveInvoice(invoice);
			resp = new ResponseEntity<String>(
					"Invoice '"+id+"' created",HttpStatus.CREATED);//201-created
		}catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(
					"Unable to save Invoice",HttpStatus.INTERNAL_SERVER_ERROR); //500-Internal Server Error
		}
		return resp;
	}

}

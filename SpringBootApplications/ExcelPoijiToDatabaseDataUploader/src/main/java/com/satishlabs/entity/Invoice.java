package com.satishlabs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;

@Entity
public class Invoice {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ExcelCellName("Name") //("Name") is the column name in excel
	private String name;
	
	@ExcelCell(1) //(1) indicates excel column #1
	private Double amount;
	
	@ExcelCell(2) //(2) indicates excel column #2
	private String number;
	
	@ExcelCellName("ReceivedDate") //("ReceiveDate") is the column name in excel
	private String receivedDate;
}

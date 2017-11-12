package com.crest.assignment.cafebilling.menu;

public enum ItemCode {
	
	// This can externalised for configuration
	TEM ("TEA MASALA", 10.00), 
	TEI ("ICE TEA  ", 15.00), 
	TEL ("LEMON TEA", 15.00),
	COC ("COFFEE-COLD", 15.00), 
	COL ("COFFEE-LATTE", 30.00), 
	COM ("COFFEE-MOCHA", 40.00),
	CDC ("COLDDRINK-COKE", 20.00),
	CDP ("COLDDRINK-PEPSI", 20.00),
	CDS ("COLDDRINK-SPRITE", 15.00);
	
	private final String description;
	
	private final double price;
     
	ItemCode(String description, double price){
		this.description = description;
		this.price  = price;
	}

	public double getPrice() {
		return price;
	}

	public String getDescription() {
		return this.description;
	}
	

}

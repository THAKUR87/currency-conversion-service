package com.pawan.spring.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversion {
	
	private long id;
	
	private String from;
	
	private String to;
	
	private BigDecimal conversionMultiple;
	
	private BigDecimal quantity;
	
	private BigDecimal calculatedAmount;
	
	private int port;

	public CurrencyConversion() {}
	
	public CurrencyConversion(long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal calculatedAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.calculatedAmount = calculatedAmount;
		this.port = port;
	}

	public long getId() {
		return id;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public BigDecimal getCalculatedAmount() {
		return calculatedAmount;
	}

	public int getPort() {
		return port;
	}
	
	

}

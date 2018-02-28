package com.microservices.demo.dbservice.domain;

import java.util.List;

public class Quotes {
	List<String> quotes;
	String userName;
	public Quotes(){
		
	}
	
	public Quotes(List<String> quotes, String userName) {
		super();
		this.quotes = quotes;
		this.userName = userName;
	}
	public List<String> getQuotes() {
		return quotes;
	}
	public void setQuotes(List<String> quotes) {
		this.quotes = quotes;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}

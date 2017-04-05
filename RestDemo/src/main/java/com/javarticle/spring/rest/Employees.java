package com.javarticle.spring.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Employees {
	private List<LMSData> results = new ArrayList<LMSData>();
	private boolean success = true;
	private String message = "this is message";
	private int took = 10;
	private int total_count = 1;
	
	public Employees() {
		LMSData lms = new LMSData();
		LMSData lms1 = new LMSData();
		lms1.setIndex_day("to day");
		
		results.add(lms);
		results.add(lms1);
	}
	
	public List<LMSData> getResults() {
		return results;
	}
	public void setResults(List<LMSData> results) {
		this.results = results;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getTook() {
		return took;
	}
	public void setTook(int took) {
		this.took = took;
	}
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	
}

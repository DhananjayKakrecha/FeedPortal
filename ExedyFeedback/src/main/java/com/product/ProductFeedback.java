package com.product;

public class ProductFeedback {
	private int id;
	private String category;
	private String username;
	private String functionality;
	private String performance;
	private String usability;
	private String cost;
	private String value;
	private String customerFeedback;
	private String environmentalFeedback;

	public ProductFeedback() {

	}

	public ProductFeedback(String category, String username, String functionality, String performance,
			String usability, String cost, String value, String customerFeedback, String environmentalFeedback) {
		super();
		this.category = category;
		this.username = username;
		this.functionality = functionality;
		this.performance = performance;
		this.usability = usability;
		this.cost = cost;
		this.value = value;
		this.customerFeedback = customerFeedback;
		this.environmentalFeedback = environmentalFeedback;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFunctionality() {
		return functionality;
	}

	public void setFunctionality(String functionality) {
		this.functionality = functionality;
	}

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

	public String getUsability() {
		return usability;
	}

	public void setUsability(String usability) {
		this.usability = usability;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCustomerFeedback() {
		return customerFeedback;
	}

	public void setCustomerFeedback(String customerFeedback) {
		this.customerFeedback = customerFeedback;
	}

	public String getEnvironmentalFeedback() {
		return environmentalFeedback;
	}

	public void setEnvironmentalFeedback(String environmentalFeedback) {
		this.environmentalFeedback = environmentalFeedback;
	}
}

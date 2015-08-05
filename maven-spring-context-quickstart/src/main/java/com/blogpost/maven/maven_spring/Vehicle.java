package com.blogpost.maven.maven_spring;

public class Vehicle {
	private String make;
	private String model;
	private Integer year;
	private String color;
	private String type;
	private Boolean washed = false;
	private Boolean serviced = false;

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getWashed() {
		return washed;
	}

	public void setWashed(Boolean washed) {
		this.washed = washed;
	}

	public Boolean getServiced() {
		return serviced;
	}

	public void setServiced(Boolean serviced) {
		this.serviced = serviced;
	}

	public String getShortDescription() {
		return String.format("%s %s", getMake(), getModel());
	}

	public String getLongDescription() {
		return String.format("%s %d %s %s %s", getColor(), getYear(), 
				getMake(), getModel(), getType());
	}
}

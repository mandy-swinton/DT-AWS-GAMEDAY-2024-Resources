package com.dynatrace.demo.model;

import java.util.UUID;


public class Car {
	
	private UUID id;
	private String make;
	private String model;
	
	public Car(UUID id, String make, String model) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + model + "]";
	}
	
	
	

}

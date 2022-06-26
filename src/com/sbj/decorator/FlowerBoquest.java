package com.sbj.decorator;

public abstract class FlowerBoquest {
	protected String description;
	public String getDescription() {
		return description;
	}
	
	public abstract double cost(); 
}

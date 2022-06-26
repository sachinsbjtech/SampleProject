package com.sbj.decorator;

public abstract class FlowerBouquestDecorator extends FlowerBoquest {

	private FlowerBoquest flowerBouquest;
	public FlowerBouquestDecorator(FlowerBoquest flowerBouquest) {
		this.flowerBouquest = flowerBouquest; 
	}
	
	public abstract String getDescription(); 
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 0;
	}

}

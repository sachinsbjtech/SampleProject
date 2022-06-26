package com.sbj.decorator;

public class RoseBouquest extends FlowerBoquest {

	public RoseBouquest() {
		description = "RoseBouquest";
	}
	@Override
	public double cost() {
		return 1.2;
	}

}

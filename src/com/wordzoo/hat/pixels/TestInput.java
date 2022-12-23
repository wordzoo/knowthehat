package com.wordzoo.hat.pixels;

import java.util.List;

public class TestInput {
	public String pathToNumber;
	public Integer number;

	public TestInput(String pathToNumber, Integer number) {
		this.pathToNumber = pathToNumber;
		this.number = number;
	}
	
	public double [] getTargetArray() {
		double [] target = new double[1];
		target[1] = number;
		return target;
	}

}

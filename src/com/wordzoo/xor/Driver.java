package com.wordzoo.xor;

import java.util.List;

public class Driver {
	
	
	//Training Data: For this expected input
	static double [][] X= {
			{0,0},
			{1,0},
			{0,1},
			{1,1}
	};
	//Training Data: We want to see this expected output
	static double [][] Y= {
			{0},{1},{1},{0}
	};

	public static void main(String[] args) {
		
		//init model
		NeuralNetwork nn = new NeuralNetwork(2,10,1);
		
		
		List<Double>output;
		
		//train model
		nn.fit(X, Y, 1000000);
		
		//use model 4 times
		double [][] input = {
				{0,0},{0,1},{1,0},{1,1}	
		};
		for(double d[]:input)
		{
			output = nn.predict(d);
			System.out.println(output.toString());
		}		

	}

}
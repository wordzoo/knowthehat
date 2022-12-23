package com.wordzoo.hat.pixels;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {
	
	
	
	
	//Training Data: We want to see this expected output
	static double [][] Y= {
			{0},{1},{1},{0}
	};

	public static void main(String[] args) {
		

		//28 x 28 images, so 784 input pixels		
		//i input neurons 784
		//h hidden neurons 10
		//o output neurons
		NeuralNetwork nn = new NeuralNetwork(784,10,10);
		
		//Training Data: For this test input (X) with expected results (Y)		
		List<TestInput> input = new ArrayList<TestInput>();
		input.add(new TestInput(
				"C:\\git\\knowthehat\\images\\testSample\\img_1.jpg", Integer.valueOf(2)));
		input.add(new TestInput(
				"C:\\git\\knowthehat\\images\\testSample\\img_2.jpg", Integer.valueOf(0)));
		input.add(new TestInput(
				"C:\\git\\knowthehat\\images\\testSample\\img_3.jpg", Integer.valueOf(9)));
		input.add(new TestInput(
				"C:\\git\\knowthehat\\images\\testSample\\img_4.jpg", Integer.valueOf(0)));

		
		//train model
		nn.train(input, 1000);
		
		
		
		
		for(TestInput t:input)
		{
			List<Double> output = nn.predict(t);
			
			System.out.println(new TestOutput(output).toString());
		}		

	}

}
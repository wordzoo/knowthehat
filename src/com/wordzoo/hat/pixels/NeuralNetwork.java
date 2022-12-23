package com.wordzoo.hat.pixels;

import java.util.List;


public class NeuralNetwork {
	
	Matrix weights_ih,weights_ho , bias_h,bias_o;	
	double l_rate=0.01;
	/*1. weights_ih 👉 The weights matrix for the input and hidden layer.
	2. weights_ho 👉 The weights matrix for the hidden and output layer.
	3. bias_h 👉 The bias matrix for the hidden layer.
	4. bias_o 👉 The bias matrix for the output layer.
	5. l_rate 👉 The learning rate, a hyper-parameter used to 
	control the learning steps during optimization of weights.*/
	
	//i input neurons
	//h hidden neurons
	//o output neurons
	                  //(  784,   10,   10);
	public NeuralNetwork(int i,int h,int o) {
		weights_ih = new Matrix(h,i);
		weights_ho = new Matrix(o,h);
		
		bias_h= new Matrix(h,1);
		bias_o= new Matrix(o,1);
		
	}
	
	//use model on single element, 2D double array
	public List<Double> predict(TestInput ti)
	{
		Matrix input = Matrix.fromTestInput(ti);
		Matrix hidden = Matrix.multiply(weights_ih, input);
		hidden.add(bias_h);
		hidden.sigmoid();
		
		Matrix output = Matrix.multiply(weights_ho,hidden);
		output.add(bias_o);
		output.sigmoid();
		
		return output.toArray();
	}
	
	//ti - test input with expected results
	//this is when you train teh ANN
	public void train(List<TestInput> ti,int epochs)
	{
		for(int i=0;i<epochs;i++)
		{	
			int sampleN =  (int)(Math.random() * ti.size() );
			this.train(ti.get(sampleN));
		}
	}
	
	public void train(TestInput ti)
	{
		//X was input, Y was expected result
		Matrix input = Matrix.fromTestInput(ti);
		Matrix hidden = Matrix.multiply(weights_ih, input);
		hidden.add(bias_h);
		hidden.sigmoid();
		
		Matrix output = Matrix.multiply(weights_ho,hidden);
		output.add(bias_o);
		output.sigmoid();
		
		
		Matrix target = Matrix.fromArray(ti.getTargetArray());
		
		Matrix error = Matrix.subtract(target, output);
		Matrix gradient = output.dsigmoid();
		gradient.multiply(error);
		gradient.multiply(l_rate);
		
		Matrix hidden_T = Matrix.transpose(hidden);
		Matrix who_delta =  Matrix.multiply(gradient, hidden_T);
		
		weights_ho.add(who_delta);
		bias_o.add(gradient);
		
		Matrix who_T = Matrix.transpose(weights_ho);
		Matrix hidden_errors = Matrix.multiply(who_T, error);
		
		Matrix h_gradient = hidden.dsigmoid();
		h_gradient.multiply(hidden_errors);
		h_gradient.multiply(l_rate);
		
		Matrix i_T = Matrix.transpose(input);
		Matrix wih_delta = Matrix.multiply(h_gradient, i_T);
		
		weights_ih.add(wih_delta);
		bias_h.add(h_gradient);
		
	}


}

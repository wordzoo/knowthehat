package com.wordzoo.hat.pixels;

import java.nio.file.Path;
import java.util.List;

public class TestOutput {
	public Integer expected;
	public Integer got;

	public TestOutput(Integer expected, Integer got) {
		this.got = got;
		this.expected = expected;
	}

	public TestOutput(List<Double> output) {
		this.got = 2;
		this.expected = 2;
	}
	
	public String toString() {
		return "Expected a " + expected
				+ ", and we got a " + got;
	}
}

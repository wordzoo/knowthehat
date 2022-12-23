package com.wordzoo.hat.pixels;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.*;

import javax.imageio.ImageIO;

public class PixelCreator {
	BufferedImage image;
	int width;
	int height;

	public static void main(String[] args) {
		PixelCreator obj = new PixelCreator();
	}

	public PixelCreator() {
//		try {
//			File input = new File("C:\\git\\knowthehat\\images\\trainingSet\\trainingSet\\0\\img_1.jpg");
//			image = ImageIO.read(input);
//			width = image.getWidth();
//			height = image.getHeight();
//			BufferedImage bwImage = new BufferedImage(width,
//		            height, BufferedImage.TYPE_BYTE_GRAY);
//			int count = 0;
//
//			 int[][] imgArr = new int[width][height];
//		    Raster raster = image.getData();
//		    for (int i = 0; i < width; i++) {
//		        for (int j = 0; j < height; j++) {
//		        	System.out.println(
//		        			"col: " +i
//		        			+ "row: " +j
//		        			+ ". this pixcel is: "
//		        			+raster.getSample(i, j, 0));
//		            imgArr[i][j] = raster.getSample(i, j, 0);
//		        }
//		    }
//
//		} catch (Exception e) {
//		}
		GrayScaleImage g = new GrayScaleImage("C:\\git\\knowthehat\\images\\trainingSet\\trainingSet\\0\\img_1.jpg");
		System.out.println(g.toString());
	}

}
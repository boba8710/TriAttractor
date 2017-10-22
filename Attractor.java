import java.lang.Math;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
/**
 * @author Zaine Wilson
 * @version 1.0.1
 */
/* 
 * This is a pretty standard sierpinski gasket generator. It looks
 * like it's working by I have no way to verify until I get some
 * visualization on it.
 * 
 * Update 1: added rudimentary visualization. It's generating something, but it's
 * not a sierpinski gasket?
 */
public class Attractor {
	public static void main(String[] args) {
		int width = 1650, height = 1460;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		int maxIterations = Integer.parseInt(args[0]); //Current runconfig: 1000
		double p1x = 0;
		double p1y = 0;
		double p2x = 1;
		double p2y = 0;
		double p3x = 0.5;
		double p3y = 1;
		double cx;
		double cy;
		cx = Math.random();
		cy = Math.random(); //initialize our random starting point
		image.setRGB((int)(p1x*width), (int)(p1y*height), 100);
		image.setRGB((int)(p2x*width)-1, (int)(p2y*height), 100);
		image.setRGB((int)(p3x*width), (int)(p3y*height)-1, 100);
		image.setRGB((int)(cx*width), (int)(cy*height), 255);
		for(int iterations = 0; iterations <= maxIterations; iterations++){
			int randNum = rollDice(6);
			if(randNum == 1 || randNum == 2){
				cx = 0.5*Math.abs(p1x-cx);
				cy = 0.5*Math.abs(p1y-cy);
			}
			else if(randNum == 3 || randNum == 4){
				cx = 0.5*Math.abs(p2x-cx);
				cy = 0.5*Math.abs(p2y-cy);
			}else{
				cx = 0.5*Math.abs(p3x-cx);
				cy = 0.5*Math.abs(p3y-cy);
			}
			image.setRGB((int)(cx*width), (int)(cy*height), 255);
			System.out.println("("+Double.toString(cx)+ ", "+Double.toString(cy)+")");
		}
		try {
			ImageIO.write(image, "png", new File("C:\\users\\zaine\\desktop\\attractor.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * @param sides
	 * @return a random number from 1,sides
	 */
	static int rollDice(int sides){
		return (int)(Math.random() * sides)+1;
	}
	/**
	 * 
	 * @param p1x
	 * @param p1y
	 * @param p2x
	 * @param p2y
	 * @return distance between 2 points in R2
	 */
	static double distance(int p1x, int p1y, int p2x, int p2y){
		return Math.sqrt(Math.pow(p2x - p1x,2) + Math.pow(p2y - p1y,2));
	}
}

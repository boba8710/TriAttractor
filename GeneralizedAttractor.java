import java.lang.Math;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
/**
 * @author Zaine
 * @version 1.0.0
 */
/*
 * A more general version of the Sierpinski gasket fractal generator. Currently seems
 * to be working but have yet to throw visualization on it. Needs the Point data type
 * to function properly.
 */
public class GeneralizedAttractor {
	public static void main(String[] args) {
		int width = 10000, height = 10000;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		int sides = Integer.parseInt(args[0]); // Currently set to 100. Sides dictates BOTH the number of points and the size of the operating plane
		int iterations = Integer.parseInt(args[1]); //Currently set to 100.
		double[] xPointsArray = new double[sides];
		double[] yPointsArray = new double[sides];
		Point[] pointArray = new Point[sides];
		for(int i = 0; i < sides; i++){
			xPointsArray[i] = i;
			yPointsArray[i] = i;
		}
		Point currPoint = new Point(Math.random()*sides,Math.random()*sides);
		System.out.println(currPoint.toString());
		//Populate the point array with  points
		for(int i = 0; i < sides; i++){
			boolean flag = false;
			while(!flag){
				flag = false;
				int randX = (int)(Math.random() * sides);
				int randY = (int)(Math.random() * sides);
				Point candidate = new Point(xPointsArray[randX], yPointsArray[randY]);
				for(Point p : pointArray){
					if(p == candidate){
						break;
					}
					pointArray[i] = new Point(xPointsArray[randX], yPointsArray[randY]);
					flag = true;
					break;
				}
			}
		}
		//choose a random value between 0 and sides
		for(int i = 0; i <= iterations; i++){
			int randVal = (int)(Math.random() * sides);
			Point randPoint = pointArray[randVal];
			currPoint.update(Math.abs(randPoint.getX()-currPoint.getX())/2, Math.abs(randPoint.getY()-currPoint.getY())/2);
			System.out.println(currPoint.toString());
			//Seems to be working.
			//TODO: Set up a way to visualize
		}
		
	}
}

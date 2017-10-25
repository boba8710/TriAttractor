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
		int width = 1000, height = 1000;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		int sides = Integer.parseInt(args[0]); // Currently set to 100. Sides dictates BOTH the number of points and the size of the operating plane
		int iterations = Integer.parseInt(args[1]); //Currently set to 100.
		double[] xPointsArray = new double[width];
		double[] yPointsArray = new double[height];
		Point[] pointArray = new Point[width*height];
		for(int i = 0; i < sides; i++){
			xPointsArray[i] = i;
			yPointsArray[i] = i;
		}
		
		Point currPoint = new Point(0.5*sides,0.5*sides);
		//Populate the point array with  points
		for(int i = 0; i < width*height; i++){
			boolean flag = false;
			while(!flag){
				flag = false;
				int randX = (int)(Math.random() * width);
				int randY = (int)(Math.random() * height);
				Point candidate = new Point(randX, randY);
				for(Point p : pointArray){
					if(p == candidate){
						break;
					}
					pointArray[i] = new Point(randX, randY);
					flag = true;
					break;
				}
			}
		}
		//choose a random value between 0 and sides
		for(int i = 0; i <= iterations; i++){
			int randVal = (int)(Math.random() * sides);
			Point randPoint = pointArray[randVal];
			currPoint.update(currPoint.getX()+(randPoint.getX()-currPoint.getX())/2,currPoint.getY()+(randPoint.getY()-currPoint.getY())/2);
			System.out.println(currPoint.toString());
			image.setRGB((int)currPoint.getX(), (int)currPoint.getY(), 0x3EC242);
			//Seems to be working.
			//TODO: Set up a way to visualize
		}
		try {
			ImageIO.write(image, "png", new File("C:\\users\\zaine\\desktop\\generalAttractor.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

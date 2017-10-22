import java.lang.Math;
/**
 * 
 * @author Zaine Wilson
 * @version 1.0.0
 */
/* 
 * This is a pretty standard sierpinski gasket generator. It looks
 * like it's working by I have no way to verify until I get some
 * visualization on it.
 */
public class Attractor {
	public static void main(String[] args) {
		int maxIterations = Integer.parseInt(args[0]); //Current runconfig: 1000
		double p1x = 0;
		double p1y = 0;
		double p2x = 3;
		double p2y = 0;
		double p3x = 1.5;
		double p3y = 1.5;
		double cx;
		double cy;
		cx = Math.random() * 3;
		cy = Math.random() * 1.5; //initialize our random starting point
		boolean[] pixelArray; //to be used for a rudimentary screen later maybe?
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
			System.out.println("("+Double.toString(cx)+ ", "+Double.toString(cy)+")");
			if(cx > 3 || cy > 1.5){
				System.out.println("Caught an iteration breaking confinement :(");
				break;
			}
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

/**
 * @author Zaine
 * @version 1.0.0
 */
/*
 * An easy, breezy, quick, ugly Point data type.
 */
public class Point {
	private double x,y;
	Point(double xValue, double yValue){
		this.x = xValue;
		this.y=yValue;
	}
	public String toString(){
		return "("+Double.toString(this.x)+", "+Double.toString(this.y)+")";
	}
	public double getX(){
		return this.x;
	}
	public double getY(){
		return this.y;
	}
	public void update(double x, double y){
		this.x = x;
		this.y = y;
	}
}

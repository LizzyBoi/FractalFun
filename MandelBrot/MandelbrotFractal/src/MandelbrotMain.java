import java.util.*;

public class MandelbrotMain {
	
	static final int MAX = 100;
	static final int RES = 512;
	static final double sideScale = 2;
	
	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Enter x coordinate of center point (double)");
		double xcor = reader.nextDouble();
		
		System.out.println("Enter y coordinate of center point (double)");
		double ycor = reader.nextDouble();
		
		System.out.println("Enter side length of the square you want to investigate (double)");
		double sideLength = reader.nextDouble();
		
		reader.close();
		
		System.out.println("xcor = " + xcor);
		System.out.println("ycor = " + ycor);
		System.out.println("sideLength = " + sideLength);
		
		StdDraw.setCanvasSize(RES-1, RES-1);
		StdDraw.setXscale(-sideLength/sideScale + xcor, sideLength/sideScale + xcor);
		StdDraw.setYscale(-sideLength/sideScale + ycor, sideLength/sideScale + ycor);
		StdDraw.show(0);
		StdDraw.setPenRadius((1/RES));
		
		for(double k = 0; k < RES; k++) {
			for(double j = 0; j < RES; j++) {
				Complex z = new Complex(xcor - sideLength/2 + (sideLength*j)/(RES-1),ycor- sideLength/2 + (sideLength*k)/(RES-1));
				if(iterate(z) == MAX) {
					StdDraw.setPenColor(StdDraw.BLACK);
				} else {
					StdDraw.setPenColor(StdDraw.WHITE);
				}
				StdDraw.point(z.getRe(),z.getIm());	
			}
		}
		StdDraw.show(0);
		System.out.println("Done drawing");
}

	public static int iterate(Complex z0) {
		Complex z = new Complex(z0);
		
		for (int i = 0; i < MAX; i++) {
			if (z.abs() > 2.0) {
				return i;
			}
			z = z.times(z).plus(z0);
		}
		return MAX;
	}
}
import java.util.Arrays;

public class Complex {

	private double re = 0;
	private double im = 0;
	private double[] z = {re,im};
	
	public Complex() {
		this.z[0]=0;
		this.z[1]=0;
	}
	
	public Complex(double re,double im) {
		this.z[0]=re;
		this.z[1]=im;
	}
	
	public Complex(Complex z) {
		this.z = z.z;
	}
	
	public Complex plus(Complex other) {
		Complex c = new Complex();
		c.z[0] = this.z[0] + other.z[0];
		c.z[1] = this.z[1] + other.z[1];
		return c;
	}
	
	public Complex times(Complex other) {
		Complex c = new Complex();
		c.z[0] = this.z[0] * other.z[0] - this.z[1] * other.z[1];
		c.z[1] = this.z[1] * other.z[0] + this.z[0] * other.z[1];
		return c;
	}
	
	public double getRe() {
		return z[0];
	}
	
	public double getIm() {
		return z[1];
	}
	
	public double abs() {
		return Math.sqrt(z[0]*z[0] + z[1]*z[1]);
	}
	
	public String toString() {
		return Arrays.toString(z);
	}
}

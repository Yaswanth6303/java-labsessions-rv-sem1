package shape;

public class Square {
	public double side;
	
	public Square(double side) {
		this.side = side;
	}
	
	public double area() {
		return side * side;
	}
}
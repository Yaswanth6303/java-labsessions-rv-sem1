package question02a;

public interface Vehicle {
	void drive();
}

class Car implements Vehicle {

	@Override
	public void drive() {
		System.out.println("Car is compact with 4 wheels");
	}
}

class Motorcycle implements Vehicle {

	@Override
	public void drive() {
		System.out.println("Motorcycle is compact with 2 wheels");	
	}
}
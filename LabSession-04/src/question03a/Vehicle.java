package question03a;

public abstract class Vehicle {
	abstract void drive();
}

class Car extends Vehicle {

	@Override
	void drive() {
		System.out.println("Car is compact with 4 wheels");
	}
}

class Motorcycle extends Vehicle {

	@Override
	void drive() {
		System.out.println("Motorcycle is compact with 2 wheels");
	}
	
}
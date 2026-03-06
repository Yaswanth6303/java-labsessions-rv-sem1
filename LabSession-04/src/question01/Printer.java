package question01;

public abstract class Printer {
	abstract void configuration();
	abstract void display();
}

class DotMatrix extends Printer {

	@Override
	void configuration() {
		System.out.println("Dot Matrix Configuration");
	}

	@Override
	void display() {
		System.out.println("Dot Matrix Display");
	}
	
}

class LaserJet extends Printer {

	@Override
	void configuration() {
		System.out.println("Laser Jet Configuration");
	}

	@Override
	void display() {
		System.out.println("Laser Jet Display");
	}
	
}
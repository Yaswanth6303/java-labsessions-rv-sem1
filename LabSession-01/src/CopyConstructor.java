public class CopyConstructor {
	int a;
	int b;
	static int count;

	public CopyConstructor(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public CopyConstructor(CopyConstructor c) {
		System.out.println(c.a);
		System.out.println(c.b);
		count++;
	}

	public static void main(String[] args) {
		CopyConstructor c = new CopyConstructor(5, 10);
		CopyConstructor cp = new CopyConstructor(c);
		System.out.println(CopyConstructor.count);
		System.out.println("Sum: " + cp.a + cp.b);
	}
}
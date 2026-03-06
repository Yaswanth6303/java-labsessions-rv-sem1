public class Employee implements Personal, Official {

	private String name;
	private int age;
	private String designation;
	private String department;

	public Employee(String name, int age, String designation, String department) {
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.department = department;
	}

	@Override
	public void displayPersonalDetails() {
		System.out.println("Personal Details");
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
	}

	@Override
	public void displayOfficialDetails() {
		System.out.println("Official Details");
		System.out.println("Designation: " + designation);
		System.out.println("Department: " + department);
	}

}

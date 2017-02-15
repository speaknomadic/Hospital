package hospital;

public class PatientFile {

	private String firstName = "";
	
	private String lastName = "";
	
	private int age = 0;
	
	private Plan plan = null;

	public PatientFile(String firstName, String lastName, int age) {
		if (firstName != null) {
			this.firstName = firstName;
		}
		
		if (lastName != null) {
			this.lastName = lastName;
		}
		
		if (age > 0) {
			this.age = age;
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "PatientFile [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", plan=" + plan
				+ "]";
	}
}

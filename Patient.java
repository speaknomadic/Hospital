package hospital;

public class Patient extends Person implements Comparable<Patient> {

	private Gender gender = null;

	private int age = 0;

	private PatientFile fileReference = null;

	public Patient(String firstName, String lastName, Gender gender, int age, PatientFile fileReference) {
		super(firstName, lastName);
		this.gender = gender;
		this.age = age;
		this.fileReference = fileReference;
	}

	public Gender getGender() {
		return gender;
	}

	public PatientFile getFileReference() {
		return fileReference;
	}

	public void setFileReference(PatientFile fileReference) {
		this.fileReference = fileReference;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void takeMedicines() {
		// TODO
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + age;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (age != other.age)
			return false;
		if (gender != other.gender)
			return false;
		return true;
	}

	@Override
	public int compareTo(Patient o) {
		if (this.getFirstName().compareTo(o.getFirstName()) == 0) {
			return this.getLastName().compareTo(o.getLastName());
		}
		return this.getFirstName().compareTo(o.getFirstName());
	}

	@Override
	public String toString() {
		return "Patient [gender=" + gender + ", age=" + age + ", fileReference=" + fileReference + "]"
				+ super.toString();
	}
}

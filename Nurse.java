package hospital;

import java.util.Arrays;

public class Nurse extends Person {

	private int experience = 0;

	private String phoneNumber = "";

	public Nurse(String firstName, String lastName, int experience, String workNumber) {
		super(firstName, lastName);
		
		if (experience > 0) {
			this.experience = experience;
		}
		
		if (workNumber != null) {
			this.phoneNumber = workNumber;
		}
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public void giveMedicines(Patient p, Room r, Department d) {
		p.takeMedicines();
		
		System.out.println(
				"Nurse :" + this.getFirstName() + " " + this.getLastName() + " is giving to " + p.getFirstName() + " "
						+ p.getLastName() + " " + " in a room " + r.getNumber() + " " + " in a department "
						+ d.getType() + " medicine " + Arrays.toString(p.getFileReference().getPlan().getMedicines()));
	}

	@Override
	public String toString() {
		return "Nurse [experience=" + experience + ", workNumber=" + phoneNumber + "] " + super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + experience;
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		Nurse other = (Nurse) obj;
		if (experience != other.experience)
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
}

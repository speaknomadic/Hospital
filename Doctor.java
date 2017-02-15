package hospital;

import java.util.HashMap;
import java.util.Map;

public class Doctor extends Person {

	private String specialization = "";
	
	private String workPhone = "";
	
	private Map <Patient, PatientFile> patientsReference = new HashMap<>();

	public Doctor(String firstName, String lastName, String specialization, String workNumber) {
		super(firstName, lastName);
		
		if (specialization != null) {
			this.specialization = specialization;
		}
		
		if (workNumber != null) {
			this.workPhone = workNumber;
		}
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Map<Patient, PatientFile> getReferencePatients() {
		return patientsReference;
	}

	public void setReferencePatients(Map<Patient, PatientFile> referencePatients) {
		this.patientsReference = referencePatients;
	}

	public void visit(Patient p, Room r, Department d) {
		System.out.println("Doctor: " + this.getFirstName() + " " + this.getLastName() + " visited a patient "
				+ p.getFirstName() + " " + p.getLastName() + " in a room number " + r.getNumber() + " in department "
				+ d.getType());
	}

	@Override
	public String toString() {
		return "Doctor [specialization=" + specialization + ", workNumber=" + workPhone + ", patientsReference="
				+ patientsReference + "] " + super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((patientsReference == null) ? 0 : patientsReference.hashCode());
		result = prime * result + ((specialization == null) ? 0 : specialization.hashCode());
		result = prime * result + ((workPhone == null) ? 0 : workPhone.hashCode());
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
		Doctor other = (Doctor) obj;
		if (patientsReference == null) {
			if (other.patientsReference != null)
				return false;
		} else if (!patientsReference.equals(other.patientsReference))
			return false;
		if (specialization == null) {
			if (other.specialization != null)
				return false;
		} else if (!specialization.equals(other.specialization))
			return false;
		if (workPhone == null) {
			if (other.workPhone != null)
				return false;
		} else if (!workPhone.equals(other.workPhone))
			return false;
		return true;
	}

}

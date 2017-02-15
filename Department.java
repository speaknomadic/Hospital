package hospital;

import java.util.ArrayList;
import java.util.List;

public class Department {

	public enum Type {
		ORTOPEDIC, INFECTIOUS, CARDIOLOGIC;
	}

	private Type type = null;

	private static final int NUMBER_OF_ROOMS = 10;

	private List<Room> rooms = new ArrayList<Room>(10);

	private Nurse nurse = null;

	private Doctor doctor = null;

	public Department(Type type) {
		if (type != null) {
			this.type = type;
		}

		for (int i = 0; i < NUMBER_OF_ROOMS; i++) {
			rooms.add(new Room());
		}
	}

	public Type getType() {
		return type;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public boolean accept(Patient patient) {
		for (Room r : rooms) {
			if (r.isEmpty() == true) {
				r.addPatient(patient);
				return true;
			} else if (r.isFull() == false && patient.getGender() == r.gender()) {
				r.addPatient(patient);
				return true;
			}
		}

		return false;
	}

	public void addStaff(Nurse n, Doctor d) {
		nurse = n;
		doctor = d;
	}

	public void nurseVisitation() {
		for (Room r : rooms) {
			for (Patient p : r.getBeds()) {
				nurse.giveMedicines(p, r, this);
			}
		}
	}

	public void doctorVisitation() {
		for (Room r : rooms) {
			for (Patient p : r.getBeds()) {
				doctor.visit(p, r, this);
			}
		}
	}

	@Override
	public String toString() {
		return "Department [type=" + type + ", rooms=" + rooms + "]";
	}
}

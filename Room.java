package hospital;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Room implements Comparable<Room> {

	private static int counter = 0;

	private static final int NUMBER_OF_PEOPLE_IN_A_ROOM = 3;

	private Set<Patient> beds = new HashSet<Patient>();

	private int number = 0;

	public Room() {
		number = ++counter;
	}

	public Set<Patient> getBeds() {
		return beds;
	}

	public int getNumber() {
		return number;
	}

	public int emptyBedsAmount() {
		return NUMBER_OF_PEOPLE_IN_A_ROOM - beds.size();
	}

	public void addPatient(Patient patient) {
		if (isEmpty() == true) {
			beds.add(patient);
		} else if (isFull() == false && patient.getGender() == gender()) {
			beds.add(patient);
		}
	}

	public void remove(Patient p) {
		beds.remove(p);
	}

	public boolean isFull() {
		return beds.size() >= NUMBER_OF_PEOPLE_IN_A_ROOM;
	}

	public Gender gender() {
		for (Patient p : beds) {
			return p.getGender();
		}

		return null;
	}

	public boolean isEmpty() {
		return beds.size() == 0;
	}

	@Override
	public String toString() {
		return "Room [beds=" + beds + "]";
	}

	@Override
	public int compareTo(Room room) {
		return number - room.number;
	}
}

package hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

public class Hospital {

	private int day = -1;

	private List<Department> departments = new ArrayList<Department>();

	/*
	 * Diagnosis --> Department
	 */
	private Map<String, Department> treatments = new HashMap<String, Department>();

	private List<Doctor> doctors = new ArrayList<Doctor>();

	private List<Nurse> nurses = new ArrayList<Nurse>();

	private List<Patient> patients = new ArrayList<Patient>();

	private Map<Patient, PatientFile> files = new TreeMap<Patient, PatientFile>();

	// Patient
	// -->
	// per
	// Doctor
	private Map<Patient, Doctor> healing = new HashMap<Patient, Doctor>();

	private String[] diagnosis = { "Broken Leg", "Flu", "Heart attack" };

	private String[][] medicines = { { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" },
			{ "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" },
			{ "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" },
			{ "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" } };

	public Hospital() {
		for (Department.Type type : Department.Type.values()) {
			departments.add(new Department(type));
		}

		for (int i = 0; i < diagnosis.length; i++) {
			treatments.put(diagnosis[i], departments.get(i));
		}
	}

	public Map<String, Department> getDepartments() {
		return treatments;
	}

	public void setDepartments(Map<String, Department> departments) {
		this.treatments = departments;
	}

	public String[] getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String[] diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String[][] getMedicines() {
		return medicines;
	}

	public void setMedicines(String[][] medicines) {
		this.medicines = medicines;
	}

	public void add(Nurse nurse) {
		nurses.add(nurse);
	}

	public void add(Doctor doctor) {
		doctors.add(doctor);
	}

	public boolean accept(Patient patient) {
		if (patient == null) {
			System.out.println("Nullpointer");
		}

		// TODO Think about it.
		// startWorkInDepartment();

		patients.add(patient);

		PatientFile file = new PatientFile(patient.getFirstName(), patient.getLastName(), patient.getAge());

		patient.setFileReference(file);

		files.put(patient, file);

		Random rand = new Random();
		int k = rand.nextInt(diagnosis.length);
		int i = rand.nextInt(medicines.length);
		int days = rand.nextInt(3) + 3;
		String diagnose = diagnosis[k];

		Plan plan = new Plan(diagnose, medicines[i], day + days);

		file.setPlan(plan);

		healing.put(patient, treatments.get(diagnose).getDoctor());

		if (treatments.get(diagnose).accept(patient) == false) {
			System.out.println("There is no place in hospital");
			return false;
		}

		return true;
	}

	public void discharge() {
		for (int i=patients.size()-1; i>=0; i--) {
			if (patients.get(i).getFileReference().getPlan().getDuration() != day) {
				continue;
			}

			System.out.println("Patient :" + patients.get(i).getFirstName() + " " + patients.get(i).getLastName() + " gender: " + patients.get(i).getGender()
					+ " with diagnosis " + patients.get(i).getFileReference().getPlan().getDiagnosis() + " was discharged);");

			for (Department d : departments) {
				for (Room r : d.getRooms()) {
					r.remove(patients.get(i));
				}
			}

			healing.remove(patients.get(i));
			patients.remove(patients.get(i));
		}
	}

	// TODO to check
	public void passDay(int t) {
		day = t;

		for (Map.Entry<String, Department> entry : treatments.entrySet()) {
			entry.getValue().nurseVisitation();
		}

		for (Map.Entry<String, Department> entry : treatments.entrySet()) {
			entry.getValue().doctorVisitation();
		}

		discharge();
	}

	public void startWorkInDepartment() {
		for (int i = 0; i < departments.size() && i < nurses.size() && i < doctors.size(); i++) {
			departments.get(i).addStaff(nurses.get(i), doctors.get(i));
		}
	}

	// TODO to check
	public void checkEmptyBeds() {
		for (Department d : departments) {
			int counterEmptyBeds = 0;

			for (Room r : d.getRooms()) {
				counterEmptyBeds += r.emptyBedsAmount();
			}

			System.out.println(
					"Number of empty beds in :" + d.getType().toString() + " department " + " is :" + counterEmptyBeds);
		}
	}

	// TODO to check
	public Map<Doctor, Integer> patientsPerDoctor() {
		Map<Doctor, Integer> numberOfPatients = new HashMap<Doctor, Integer>();
		for (Doctor d : doctors) {
			numberOfPatients.put(d, d.getReferencePatients().size());
		}
		return numberOfPatients;
	}

	// TODO to check
	public List<Patient> toBeDischarged() {
		List<Patient> toBeDischarged = new ArrayList<Patient>();
		for (Patient p : patients) {
			if (p.getFileReference().getPlan().getDuration() == day + 1) {
				toBeDischarged.add(p);
			}
		}
		return toBeDischarged;
	}
}

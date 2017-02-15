import hospital.Doctor;
import hospital.Gender;
import hospital.Hospital;
import hospital.Nurse;
import hospital.Patient;

public class Demo {

	public static void main(String[] args) throws InterruptedException {

		Hospital hospital = new Hospital();

		hospital.add(new Doctor("Name 111", "Last 111", "0001", "S1"));
		hospital.add(new Doctor("Name 222", "Last 222", "0002", "S2"));
		hospital.add(new Doctor("Name 333", "Last 333", "0003", "S2"));

		hospital.add(new Nurse("Name 01", "Last 01", 1, "00001"));
		hospital.add(new Nurse("Name 02", "Last 02", 2, "00002"));
		hospital.add(new Nurse("Name 03", "Last 03", 3, "00003"));

		hospital.startWorkInDepartment();

		Patient sick[] = { new Patient("Name 1", "Last 1", Gender.MALE, 30, null),
				new Patient("Name 2", "Last 2", Gender.FEMALE, 40, null),
				new Patient("Name 3", "Last 3", Gender.MALE, 50, null),
				new Patient("Name 4", "Last 4", Gender.FEMALE, 60, null),
				new Patient("Name 5", "Last 5", Gender.MALE, 70, null) };

		for (int t = 0; t < 10; t++) {
			if (t < sick.length) {
				if (hospital.accept(sick[t]) == false) {
					System.out.println(sick[t].toString() + t + " Rejected");
				}
			}

			System.out.println(" Day " + t);
			hospital.passDay(t);
			hospital.checkEmptyBeds();

			System.out.println(hospital.patientsPerDoctor().toString());

			System.out.println(hospital.toBeDischarged());
		}

	}
}

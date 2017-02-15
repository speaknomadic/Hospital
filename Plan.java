package hospital;

import java.util.Arrays;

public class Plan {

	private String diagnosis = null;
	
	private String[] medicines = null;
	
	private int dischargementDay = 0;

	public Plan(String diagnosis, String[] medicines, int duration) {
		if (diagnosis != null) {
			this.diagnosis = diagnosis;
		}
		
		if (medicines != null) {
			this.setMedicines(medicines);
		}
		
		if (duration > 0) {
			this.dischargementDay = duration;
		}
	}

	public int getDuration() {
		return dischargementDay;
	}

	public void setDuration(int duration) {
		this.dischargementDay = duration;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String[] getMedicines() {
		return medicines;
	}

	public void setMedicines(String[] medicines) {
		this.medicines = medicines;
	}

	@Override
	public String toString() {
		return "Plan [diagnosis=" + diagnosis + ", medicines=" + Arrays.toString(medicines) + ", duration="
				+ dischargementDay + "]";
	}
}

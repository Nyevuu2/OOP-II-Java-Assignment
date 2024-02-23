import java.util.*;

// Interface for Doctor
interface Doctor {
    void displayDetails();
}

// Doctor class implementing the Doctor interface
class DoctorImpl implements Doctor {
    private String name;
    private String specialization;

    public DoctorImpl(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    @Override
    public void displayDetails() {
        System.out.println("Doctor Name: " + name);
        System.out.println("Specialization: " + specialization);
    }
}

// Patient class
class Patient {
    private String name;
    private int age;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

// Hospital class containing Doctor and Patient details
class Hospital {
    private ArrayList<Doctor> doctors;
    private HashMap<Doctor, LinkedList<Patient>> appointments;

    public Hospital() {
        doctors = new ArrayList<>();
        appointments = new HashMap<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        appointments.put(doctor, new LinkedList<>());
    }

    public void bookAppointment(Doctor doctor, Patient patient) {
        LinkedList<Patient> patientList = appointments.get(doctor);
        if (patientList != null) {
            patientList.add(patient);
        } else {
            System.out.println("Doctor not found.");
        }
    }

    public void displayAppointments(Doctor doctor) {
        LinkedList<Patient> patientList = appointments.get(doctor);
        if (patientList != null) {
            System.out.println("Appointments for Doctor: ");
            for (Patient patient : patientList) {
                System.out.println("Patient: " + patient.getName() + ", Age: " + patient.getAge());
            }
        } else {
            System.out.println("No appointments for this doctor.");
        }
    }
}

public class HospitalManagementApp {
    public static void main(String[] args) {
        Doctor doctor1 = new DoctorImpl("Dr. Smith", "Cardiologist");
        Doctor doctor2 = new DoctorImpl("Dr. Johnson", "Dermatologist");

        Hospital hospital = new Hospital();
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);

        Patient patient1 = new Patient("John", 30);
        Patient patient2 = new Patient("Alice", 25);

        hospital.bookAppointment(doctor1, patient1);
        hospital.bookAppointment(doctor1, patient2);

        hospital.displayAppointments(doctor1);
        hospital.displayAppointments(doctor2);
    }
}

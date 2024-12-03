import java.util.Scanner;

public class Doctor extends User {
    private String[] availableDays;
    private double availableHours;
    private int ReservedAppointments = 0;


    public void createPrescription(String patientName, String details) {
        System.out.println("Prescription for " + patientName + ": " + details);
    }

    public void ShowAppointmentsOfTheDay(String DoctorName) {
        System.out.println("The number of reserved appointments with Dr\\ " + DoctorName + " is " + GetReservedAppointments());

    }


    public void SetReservedAppointments(int ReservedAppointments) {
        this.ReservedAppointments = ReservedAppointments;
    }

    public int GetReservedAppointments() {
        return ReservedAppointments;
    }

    public String[] getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(String[] availableDays) {
        this.availableDays = availableDays;
    }

    public double getAvailableHours() {
        return availableHours;
    }

    public void setAvailableHours(float availableHours) {
        this.availableHours = availableHours;
    }


    static public void menuDoctor() {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose an action :");
        int x = input.nextInt();
        if (x == 1) {

        }
    }
}


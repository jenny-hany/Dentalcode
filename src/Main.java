import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creating Doctors
        Doctor doctorKaren = new Doctor("karen123", "password123", "Karen", "Smith", "karen@clinic.com", "123456789", "Dentist", new String[]{"Sunday", "Monday", "Tuesday"});
        doctorKaren.setAvailableHours(3); // 1 PM to 4 PM
        Doctor doctorMario = new Doctor("mario456", "password456", "Mario", "Rossi", "mario@clinic.com", "987654321", "Orthodontist", new String[]{"Wednesday", "Thursday", "Saturday"});
        doctorMario.setAvailableHours(3); // 9 AM to 12 PM
        Doctor doctorFayrouz = new Doctor("fayrouz789", "password789", "Fayrouz", "Ali", "fayrouz@clinic.com", "123987654", "Surgeon", new String[]{"Friday", "Monday", "Tuesday"});
        doctorFayrouz.setAvailableHours(3); // 6 PM to 9 PM

        String[] services = {"Fixing Teeth", "Gum Care", "Children's Dentistry"};
        float[] servicePrices = {100.0f, 150.0f, 200.0f};

        // Create a simple clinic with these doctors
        Dentalclinic clinic = new Dentalclinic("Smile Clinic", "20 Korba Street", services, servicePrices);
        // Add doctors to the clinic
        clinic.addDoctor(doctorKaren);
        clinic.addDoctor(doctorMario);
        clinic.addDoctor(doctorFayrouz);
        // Display the clinic's services and prices
        clinic.displayServicesAndPrices();

        // Create patients and receptionists
        Patient patient1 = new Patient("john123", "johnpass", "John", "Doe", "john@example.com", "5551234", 30, "O+", 70, 175);
        Receptionist receptionist = new Receptionist("receptionist1", "recpass", "Sarah", "Connor", "sarah@clinic.com", "5555678", 25, "Female");

        // Show available options to the patient
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nChoose an action: ");
            System.out.println("1. View doctors");
            System.out.println("2. Book appointment with doctor");
            System.out.println("3. Cancel appointment");
            System.out.println("4. Exit");

            // Read the user's choice
            int choice = scanner.nextInt();

            // Consume the newline character that is left behind by nextInt()
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Show list of doctors
                    System.out.println("\nDoctors available:");
                    System.out.println(doctorKaren.getFirstName() + " - " + doctorKaren.getSpecialization());
                    System.out.println(doctorMario.getFirstName() + " - " + doctorMario.getSpecialization());
                    System.out.println(doctorFayrouz.getFirstName() + " - " + doctorFayrouz.getSpecialization());
                    break;

                case 2:
                    // Choose doctor and view available slots
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();
                    Doctor selectedDoctor = null;

                    // Find the selected doctor
                    if (doctorName.equalsIgnoreCase("Karen")) {
                        selectedDoctor = doctorKaren;
                    } else if (doctorName.equalsIgnoreCase("Mario")) {
                        selectedDoctor = doctorMario;
                    } else if (doctorName.equalsIgnoreCase("Fayrouz")) {
                        selectedDoctor = doctorFayrouz;
                    }

                    if (selectedDoctor != null) {
                        System.out.println("\nAvailable days for Dr. " + selectedDoctor.getFirstName() + ":");
                        for (String day : selectedDoctor.getAvailableDays()) {
                            System.out.println("- " + day);
                        }
                        System.out.print("\nSelect a day: ");
                        String selectedDay = scanner.nextLine();

                        // Display available slots
                        if (selectedDoctor != null) {
                            System.out.println("\nAvailable time slots for " + selectedDay + ":");
                            if (selectedDay.equals("Sunday") || selectedDay.equals("Monday") || selectedDay.equals("Tuesday")) {
                                System.out.println("1:00 PM - 4:00 PM");
                            } else if (selectedDay.equals("Wednesday") || selectedDay.equals("Thursday") || selectedDay.equals("Saturday")) {
                                System.out.println("9:00 AM - 12:00 PM");
                            } else if (selectedDay.equals("Friday")) {
                                System.out.println("6:00 PM - 9:00 PM");
                            }
                        }
                        System.out.print("\nChoose time slot: ");
                        String timeSlot = scanner.nextLine();

                        // Book appointment
                        AppointmentReservation appointment = new AppointmentReservation("2024-12-02", selectedDay, doctorName, patient1.getFirstName(), timeSlot);
                        System.out.println("\nAppointment booked: ");
                        appointment.displayAppointmentDetails();
                    }
                    break;

                case 3:
                    // Cancel appointment
                    System.out.print("\nEnter doctor name to cancel appointment: ");
                    String cancelDoctorName = scanner.nextLine();
                    // Assume the appointment was found, update system
                    System.out.println("\nAppointment with Dr. " + cancelDoctorName + " has been canceled.");
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}

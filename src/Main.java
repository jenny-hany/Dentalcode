import filehandlingexample.FileHandling;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

import static filehandlingexample.FileHandling.*;

public class Main {

    public static void main(String[] args) {

        Dentalclinic clinic = new Dentalclinic();

        Doctor doctors[] = new Doctor[3];
        doctors[0]= new Doctor();
        doctors[0].setFirstName("carine");
        doctors[0].setLastName("bahaa");
        doctors[0].setEmail("carinebahaa@gmail.com");
        doctors[0].setAvailableDays(new String[]{"Saturday" , "Sunday","Thursday"});
        doctors[0].setAvailableHours(5);

        doctors[1]= new Doctor();
        doctors[1].setFirstName("jennifer");
        doctors[1].setLastName("hany");
        doctors[1].setEmail("jenniferhany@gmail.com");
        doctors[1].setAvailableDays(new String[]{"Tuesday" , "Wednesday","Thursday","Friday"});
        doctors[1].setAvailableHours(4);


        doctors[2]= new Doctor();
        doctors[2].setFirstName("maria");
        doctors[2].setLastName("ramy");
        doctors[2].setEmail("mariaramy@gmail.com");
        doctors[2].setAvailableDays(new String[]{"Tuesday" , "Wednesday","Thursday","Friday"});
        doctors[2].setAvailableHours(6);

        clinic.setDoctors(doctors);
        clinic.addDoctor(doctors[0]);
        clinic.addDoctor(doctors[1]);
        clinic.addDoctor(doctors[2]);

        clinic.setServices(new String[]{"Cleaning", "Filling", "Extraction", "Braces", "Whitening"});
        clinic.setServicePrices(new float[]{50, 100, 150, 200, 250});

        menu1(clinic);
    }

    static public void menu1(Dentalclinic clinic) {
        int choice;
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to our Dental Clinic \n" +
                "Please choose what you are signing in as:\n" +
                "1) Doctor \n" +
                "2) Patient \n" +
                "3) Receptionist \n");

        int person = input.nextInt();

        // Prompt for login or signup choice

        System.out.println("1. login \n" +
                "2. signup ");
        choice = input.nextInt();

        if (person == 1) {
            Doctor doctor = new Doctor();
            doctor.is_loggedIn(choice,"doctors.txt");
            Doctor.menuDoctor();
        } else if (person == 2) {
            Patient patient = new Patient();
            patient.is_loggedIn(choice , "patient.txt");
            Patient.menuPatient(clinic);
        } else if (person == 3) {
            Receptionist receptionist = new Receptionist();
            receptionist.is_loggedIn(choice,"receptionist.txt");
            menuReceptionist();
        }
    }

    static public void menuReceptionist() {
        Scanner input = new Scanner(System.in);
        int x;
        String username, password, firstName, lastName, email, mobileNum, specialization, gender;
        double availableHours;
        int age;

        do {
            System.out.println("Please Choose an action: \n" +
                    "1) Enter your information \n" +
                    "2) Enter Doctor's information \n" +
                    "3) Update your information \n" +
                    "4) Update Doctor's information \n" +
                    "5) Update Patient's information \n" +
                    "6) Reserve an Appointment for a patient \n" +
                    "7) Cancel an Appointment for a patient \n" +
                    "8) Exit");

            x = input.nextInt();
            if (x == 1) {
                // Enter receptionist details
                System.out.println("Please enter your Username:");
                username = input.next();
                System.out.println("Please enter your email:");
                email = input.next();
                System.out.println("Please enter your password:");
                password = input.next();
                System.out.println("Please enter your First name:");
                firstName = input.next();
                System.out.println("Please enter your Last name:");
                lastName = input.next();
                System.out.println("Please enter your Age:");
                age = input.nextInt();
                System.out.println("Please enter your Gender:");
                gender = input.next();
                System.out.println("Please enter your mobile number:");
                mobileNum = input.next();

                Receptionist receptionist = new Receptionist();
                receptionist.setFirstName(firstName);
                receptionist.setLastName(lastName);
                receptionist.setEmail(email);
                receptionist.setAge(age);
                receptionist.setGender(gender);
                receptionist.save();  // Save to file

                System.out.println("Your details have been saved successfully.");
            } else if (x == 2) {
                // Enter doctor details
                System.out.println("Please enter the number of doctors in the clinic:");
                int num = input.nextInt();
                Doctor[] doctors = new Doctor[num];

                for (int i = 0; i < num; i++) {
                    System.out.println("Please enter the information for doctor " + (i + 1));
                    System.out.println("Please enter Username:");
                    username = input.next();
                    System.out.println("Please enter email:");
                    email = input.next();
                    System.out.println("Please enter password:");
                    password = input.next();
                    System.out.println("Please enter First name:");
                    firstName = input.next();
                    System.out.println("Please enter Last name:");
                    lastName = input.next();
                    System.out.println("Please enter mobile number:");
                    mobileNum = input.next();
                    System.out.println("Please enter Specialization:");
                    specialization = input.next();
                    System.out.println("Please enter Available hours:");
                    availableHours = input.nextDouble();

                    Doctor doctor = new Doctor();
                    doctor.save();  // Save to file
                    doctors[i] = doctor;
                }
                System.out.println("Doctor information saved.");
            } else if (x == 3) {
                // Update receptionist details (logic to be added)
            } else if (x == 4) {
                // Update doctor's information (logic to be added)
            } else if (x == 5) {
                // Update patient's information (logic to be added)
            } else if (x == 6) {
                // Reserve an appointment for a patient (logic to be added)
            } else if (x == 7) {
                // Cancel an appointment for a patient (logic to be added)
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        } while (x != 8); // Exit the loop
    }

    // Helper method to check if data is repeated
    public static boolean isDataRepeated(List<String> existingData, String newLine) {
        return existingData.contains(newLine);
    }

    // Helper method to append data to file
    public static void appendToFile(String fileName, String[] data) {
        List<String> dataList = Arrays.asList(data);
        writeToFile(fileName, dataList, true);
    }
}

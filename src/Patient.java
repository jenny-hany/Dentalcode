import filehandlingexample.FileHandling;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import static filehandlingexample.FileHandling.readFromFile;
import static filehandlingexample.FileHandling.writeToFile;

public class Patient extends User {
    private int age;
    private String bloodType;
    private int weight;
    private int height;
    private String mobileNum;

    // Getters and Setters
    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // Method to convert patient data into file format
    public String toFileFormat() {
        return getFirstName() + "," + getLastName() + "," + getEmail() + "," +
                age + "," + bloodType + "," + weight + "," + height + "," + mobileNum;
    }

    // Static method to load patients from file data
    public static Patient fromFileFormat(String data) {
        String[] fields = data.split(",");
        Patient patient = new Patient();
        patient.setFirstName(fields[0]);
        patient.setLastName(fields[1]);
        patient.setEmail(fields[2]);
        patient.setAge(Integer.parseInt(fields[3]));
        patient.setBloodType(fields[4]);
        patient.setWeight(Integer.parseInt(fields[5]));
        patient.setHeight(Integer.parseInt(fields[6]));
        patient.setMobileNum(fields[7]);
        return patient;
    }

    // Method to save patient data to file
    public void save() {
        List<String> data = new ArrayList<>();
        data.add(this.toFileFormat());
        writeToFile("patients.txt", data, true);  // Append to file
    }

    // Method to load all patients from file
    public static List<Patient> loadAll() {
        List<String> lines = readFromFile("patients.txt");
        List<Patient> patients = new ArrayList<>();
        for (String line : lines) {
            patients.add(Patient.fromFileFormat(line));
        }
        return patients;
    }

    // Patient Menu for interacting with the clinic
    static public void menuPatient(Dentalclinic clinic) {
        Scanner input = new Scanner(System.in);
        String serviceName;
        System.out.println("Please enter your information to save it: ");
//        input.nextLine();  // Consume the newline character
        System.out.println("Enter your Age:");
        String age = input.next();
        System.out.println("Enter your Blood Type:");
        String bloodType = input.next();
        System.out.println("Enter your Weight:");
        String weight = input.next();
        System.out.println("Enter your Height:");
        String height = input.next();

        System.out.println("what would you like to do: \n" +
                "1. update your information \n" +
                "2. reserve an appointment \n" +
                "3. cancel an appointment \n");

        int num = input.nextInt();
        if( num == 1)
        {


            boolean isUpdated = false;
            List<String> data = readFromFile("patient.txt");
            for (int i = 0; i < data.size(); i += 6) { // Assuming each patient has 6 lines of data

                System.out.println(" What would you like to change?");
                System.out.println("1) Email\n2) Mobile Number\n3) Weight\n4) Height");
                int choice = input.nextInt();

                switch (choice) {
                    case 1: // Update Email
                        System.out.println("Enter your new email:");
                        String newEmail = input.next();
                        data.set(i + 4, newEmail); // Update email (5th line)
                        isUpdated = true;
                        break;
                    case 2: // Update Mobile Number
                        System.out.println("Enter your new mobile number:");
                        String newMobile = input.next();
                        data.set(i + 5, newMobile); // Update mobile number (6th line)
                        isUpdated = true;
                        break;
                    case 3: // Update Weight
                        System.out.println("Enter your new weight:");
                        String newWeight = input.next();
                        if (data.size() > i + 6) { // Check if weight exists
                            data.set(i + 6, newWeight); // Update weight (7th line if present)
                        } else {
                            data.add(i + 6, newWeight); // Add weight if missing
                        }
                        isUpdated = true;
                        break;
                    case 4: // Update Height
                        System.out.println("Enter your new height:");
                        String newHeight = input.next();
                        if (data.size() > i + 7) { // Check if height exists
                            data.set(i + 7, newHeight); // Update height (8th line if present)
                        } else {
                            data.add(i + 7, newHeight); // Add height if missing
                        }
                        isUpdated = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

                break; // Exit loop after finding and updating the user
            }


            if (isUpdated) {
                writeToFile("patients.txt", data, false); // Save updated data back to file
                System.out.println("Your details have been updated successfully.");
            } else {
                System.out.println("Username not found.");
            }

            String[] newUserData = {bloodType, age, weight, height};
            Main.appendToFile("patient.txt", newUserData);

            System.out.println("Your details have been saved successfully.");

        }
        else if( num == 2)
        {
            System.out.println("Choose your doctor: \n" +
                    "1. Carine Bahaa \n" +
                    "2. Jennifer Hany  \n" +
                    "3. Maria Ramy  \n");

            int x = input.nextInt();
            if (x == 1 || x == 2 || x == 3) {
                clinic.displayServicesAndPrices();
                System.out.println("Choose your service : ");
                serviceName = input.next();

                // You can add logic here based on the selected doctor
                if (x == 1) {
                    // Carine Bahaa's specific service handling
                } else if (x == 2) {
                    // Jennifer Hany's specific service handling
                } else if (x == 3) {
                    // Maria Ramy's specific service handling
                }
        }
        else if (num == 3)
        {

        }

        // Display available doctors


            // Now add the patient details into file




            // Save the patient details to the file



        }
    }

    @Override
    public String toString() {
        return "Patient{" +
                "age=" + age +
                ", bloodType='" + bloodType + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", mobileNum='" + mobileNum + '\'' +
                ", User Info=" + super.toString() +
                '}';
    }
}
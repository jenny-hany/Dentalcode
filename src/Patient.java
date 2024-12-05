import filehandlingexample.FileHandling;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

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
        FileHandling.writeToFile("patients.txt", data, true);  // Append to file
    }

    // Method to load all patients from file
    public static List<Patient> loadAll() {
        List<String> lines = FileHandling.readFromFile("patients.txt");
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

        // Display available doctors
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

            // Now add the patient details into file
            System.out.println("Please enter your information to save it: ");
            input.nextLine();  // Consume the newline character
            System.out.println("Enter your Age:");
            int age = input.nextInt();
            System.out.println("Enter your Blood Type:");
            String bloodType = input.next();
            System.out.println("Enter your Weight:");
            int weight = input.nextInt();
            System.out.println("Enter your Height:");
            int height = input.nextInt();
            System.out.println("Enter your Mobile Number:");
            String mobileNum = input.next();

            Patient patient = new Patient();
            patient.setFirstName("John");  // Example first name
            patient.setLastName("Doe");    // Example last name
            patient.setEmail("john.doe@example.com"); // Example email
            patient.setAge(age);
            patient.setBloodType(bloodType);
            patient.setWeight(weight);
            patient.setHeight(height);
            patient.setMobileNum(mobileNum);

            // Save the patient details to the file
            patient.save();
            System.out.println("Your details have been saved successfully.");
        } else {
            System.out.println("Invalid choice! Please try again.");
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

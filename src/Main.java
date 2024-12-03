
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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


        doctors[1]= new Doctor();
        doctors[1].setFirstName("maria");
        doctors[1].setLastName("ramy");
        doctors[1].setEmail("mariaramy@gmail.com");
        doctors[1].setAvailableDays(new String[]{"Tuesday" , "Wednesday","Thursday","Friday"});
        doctors[1].setAvailableHours(6);

        clinic.addDoctor(doctors[0]);
        clinic.addDoctor(doctors[1]);
        clinic.addDoctor(doctors[2]);

        clinic.setServices(new String[]{"bla0","bla1","bla2","bla3","bla4"});
        clinic.setServicePrices(new float[]{1,2,3,4,5,});


        menu1(clinic);
    }


    static public void menu1(Dentalclinic clinic )
    {
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to our Dental Clinic \n" +
                "Please choose what are you signing in as :\n" +
                "1) Doctor \n" +
                "2) Patient \n" +
                "3) Receptionist \n");
        int person = input.nextInt();
        System.out.println("1. login \n" +
                "2. signup ");
        choice = input.nextInt();
        if(person == 1)
        {

            Doctor doctor = new Doctor();
            doctor.is_loggedIn(choice);
            Doctor.menuDoctor();
        }
        else if(person == 2 )
        {
            Patient patient = new Patient();
            patient.is_loggedIn(choice);
            Patient.menuPatient(clinic);
        }
        else if(person == 3)
        {
            Receptionist receptionist = new Receptionist();
            receptionist.is_loggedIn(choice);
            menuReceptionist();
        }
    }

    static public void menuReceptionist() {
        Scanner input = new Scanner(System.in);
        int x;
        String username;
        String password;
        String firstName;
        String lastName;
        String email;
        String mobileNum;
        String specialization;
        double availableHours;
        int age;
        String gender;

        do {
            System.out.println("Please Choose an action : \n " +
                    "1) Enter your information \n" +
                    "2) Enter Doctors information \n" +
                    "3) Update your information \n" +
                    "4) Update Doctors information \n" +
                    "5) Update Patient information \n" +
                    "6) Reserve an Appointment for a patient \n" +
                    "7) Cancel an Appointment for a patient \n" +
                    "8) Exit");
            x = input.nextInt();
            if (x == 1) {
                System.out.println("Please enter your Username :");
                username = input.next();
                System.out.println("Please enter your email :");
                email = input.next();
                System.out.println("Please enter your password :");
                password = input.next();
                System.out.println("Please enter your First name :");
                firstName = input.next();
                System.out.println("Please enter your Last name :");
                lastName = input.next();
                System.out.println("Please enter your Age :");
                age = input.nextInt();
                System.out.println("Please enter your Gender :");
                gender = input.next();
                System.out.println("Please enter your mobile number :");
                mobileNum = input.next();

                Receptionist receptionist = new Receptionist();
                continue;

            } else if (x == 2) {
                System.out.println("Please enter the number of doctors in the clinic :");
                int Num = input.nextInt();
                Doctor[] doctors = new Doctor[Num];



                System.out.println("Please enter the information of the doctors :");
                for (int i = 0; i < Num; i++) {
                    System.out.println("Please enter Username :");
                    username = input.next();
                    System.out.println("Please enter email :");
                    email = input.next();
                    System.out.println("Please enter password :");
                    password = input.next();
                    System.out.println("Please enter First name :");
                    firstName = input.next();
                    System.out.println("Please enter Last name :");
                    lastName = input.next();
                    System.out.println("Please enter mobile number :");

                    mobileNum = input.next();
                    System.out.println("Please enter Specialization :");
                    specialization = input.next();
                    System.out.println("Please enter Available hours :");
                    availableHours = input.nextDouble();

                    doctors[i] = new Doctor();

                    System.out.println("Please enter the next doctor's information :");
                    continue;
                }
            } else if (x == 3) {

            } else if (x == 4) {

            } else if (x == 5) {

            } else if (x == 6) {

            } else if (x == 7) {

            } else {
                System.out.println("Invalid choice please try again ...");
                continue;
            }

        } while (x != 8);


    }







    }




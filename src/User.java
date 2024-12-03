import java.util.Scanner;
public abstract class User
{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String patient_mobileNum;


    public void is_loggedIn  (int choice)
    {

        Scanner input = new Scanner(System.in);


        System.out.println("1. login \n" +
                "2. signup ");
        if (choice==1) // log in
        {
            System.out.println("Enter your username :");
            username= input.next();
            System.out.println("Enter your password :");
            password=input.next();
        }
        else if (choice == 2) // sign up
        {
            System.out.println("Enter username :");
            username = input.next();
            System.out.println("Enter password :");
            password = input.next();
            System.out.println("Enter first name :");
            firstName = input.next();
            System.out.println("Enter last name :");
            lastName =input.next();
            System.out.println("Enter email :");
           email = input.next();
            System.out.println("Enter mobile number :");
            patient_mobileNum =input.next();
        }

    }

    // Getters and Setters
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }


    @Override
    public String toString()
    {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
import java.util.Scanner;

public class Patient extends User
{
    private int age;
    private String bloodType;
    private int weight;
    private int height;
    private String mobileNum;


    public String getMobileNum() {
        return mobileNum;
    }


    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getBloodType()
    {
        return bloodType;
    }

    public void setBloodType(String bloodType)
    {
        this.bloodType = bloodType;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    static public void menuPatient(Dentalclinic clinic)
    {
        Scanner input = new Scanner(System.in);
        String serviceName;
        System.out.println("Choose your doctor: \n" +
                "1. Carine bahaa \n " +
                "2. Jennifer hany  \n" +
                "3. Maria ramy  \n");

        int x = input.nextInt();
        if(x == 1 || x==2 || x==3)
        {
          clinic.displayServicesAndPrices();
          System.out.println("Choose your service : ");
          serviceName= input.next();
          System.out.println("Doctor's avilable days :" );
          if(x == 1) {
            //print avialble days of doctor[0]
          }
          else if (x == 2){
              //print avialble days of doctor[1]
          }
          else if( x== 3){
              //print avialble days of doctor[2]
          }
        }

    }

    @Override
    public String toString()
    {
        return "Patient{" +
                "age=" + age +
                ", bloodType='" + bloodType + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", User Info=" + super.toString() +
                '}';
    }
}
import java.util.ArrayList;

public class Patient {
    private int ID;
    private String name;
    private int age;
    private float temp;
    private int o2Level;
    private int admissionStatus;
    private int recoveryDays;
    private ArrayList<Patient> array ;
    private String instName;


    public Patient(){
        this.array = new ArrayList<Patient>();
    }
    public Patient(int ID, String name, float temp , int O2, int age){
        this.ID = ID;
        this.name = name;
        this.temp = temp;
        this.o2Level = O2;
        this.age = age;
        this.instName = "null";
        this.recoveryDays =0;
        this.admissionStatus = 0;

    }

    public int getID(){
        return ID;
    }
    public ArrayList<Patient> getArray(){
        return array;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public float getTemp(){
        return temp;
    }
    public int getO2Level(){
        return o2Level;
    }
    public int getRecoveryDays(){
        return recoveryDays;
    }
    public String getInstName(){return instName;}
    public void setInstName(String n){ instName = n;}
    public int getAdmissionStatus(){
        return admissionStatus;
    }
    public void setRecoveryDays(int i){
        recoveryDays = i;
    }
    public void setAdmissionStatus(int i){
        admissionStatus = i;
    }



    public void detailsOfPatient(int id){
       System.out.println( "ID = " + array.get(id-1).getID() +
                "\nName is " + array.get(id-1).getName() +
                "\nTemperature is " + array.get(id-1).getTemp()+
                "\nOxygen level is " + array.get(id-1).getO2Level() );

       if(array.get(id-1).getAdmissionStatus() == 1)
           System.out.println("Admission status - Admitted");
       else
           System.out.println("Admission status - Not Admitted");

       System.out.println("Admitting Institute - "+array.get(id-1).getInstName());


    }
}

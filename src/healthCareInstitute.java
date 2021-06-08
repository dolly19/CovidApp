import java.util.ArrayList;

public class healthCareInstitute {
    private Patient pat;
    private String name;
    private float temp;
    private int O2;
    private int availableBeds;
    private String status;
    private ArrayList<healthCareInstitute> array ;
    public healthCareInstitute(Patient pat){
        this.pat = pat;
        this.array = new ArrayList<healthCareInstitute>();
    }
    public healthCareInstitute(String name, float temp, int O2, int beds){
        this.name = name;
        this.temp= temp;
        this.O2 = O2;
        this.availableBeds = beds;
        this.status = "OPEN";
    }
    public ArrayList<healthCareInstitute> getArray(){
        return array;
    }
    public void setStatus(String n){
        status = n;
    }
    public String getName(){
        return name;
    }
    public float getTemp(){ return temp;}
    public int getO2(){ return O2;}
    public int getAvailableBeds(){ return availableBeds;}
    public void setAvailableBeds(int i){ availableBeds = i;}
    public String getStatus(){
        return status;
    }

    public int admitPatientToInstitute(Patient pat, int beds , int o2, float temp,String name){
        ArrayList<Patient> arrayPat = pat.getArray();
        if(beds>0) {
            for (int i = 0; i < arrayPat.size(); i++) {
                    if (arrayPat.get(i).getO2Level() >= o2 && beds !=0 && arrayPat.get(i).getAdmissionStatus() == 0) {
                        arrayPat.get(i).setAdmissionStatus(1);
                        pat.getArray().get(i).setInstName(name);
                        beds--;
                    }
            }

            if (beds != 0) {
                for (int i = 0; i < arrayPat.size(); i++) {
                        if (arrayPat.get(i).getTemp() <= temp && beds != 0 && arrayPat.get(i).getAdmissionStatus() == 0) {
                            arrayPat.get(i).setAdmissionStatus(1);
                            arrayPat.get(i).setInstName(name);
                            beds--;

                    }
                }
            }

        }

        return beds;
    }

    public void displayHealthCareInstituteDetails (String name){
        for(int i=0; i<array.size(); i++){
            if(array.get(i).getName().equals(name)){
                System.out.println(name+"\nTemperature should be <= "+array.get(i).getTemp()+
                        "\nOxygen levels should be >= "+array.get(i).getO2()+"\nNumber of Available beds – "+array.get(i).getAvailableBeds()
                        +"\nAdmission Status – "+array.get(i).getStatus());
            }
        }
    }

    public void displayAdmittedPatientDetails(Patient pat, String name) {
        ArrayList<Patient> arrayPat = pat.getArray();
        for (int i = 0; i < arrayPat.size(); i++) {
            if (arrayPat.get(i).getInstName().equals(name)) {
                System.out.println(arrayPat.get(i).getName()+", recovery time is "+
                        arrayPat.get(i).getRecoveryDays()+" days");
            }
            }


        }
    }

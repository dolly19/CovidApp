import java.util.ArrayList;

public class healthCamp {
    private Patient pat;
    private healthCareInstitute inst;
    private ArrayList<healthCareInstitute> arrayInst;
    private ArrayList<Patient> patients;

    public healthCamp(){
        this.pat = new Patient();
        this.inst = new healthCareInstitute(pat);
        this.arrayInst = new ArrayList<healthCareInstitute>();
        this.patients = new ArrayList<Patient>();
    }

    public void selectEligiblePatients(Patient pat){
        patients.add(pat);
    }

    public void addHealthCareInstitute(healthCareInstitute inst){
       arrayInst.add(inst);
    }

    public void displayAdmittingInstitiutes(){
        int count =0;
        for(int i=0; i<arrayInst.size(); i++){
            if(arrayInst.get(i).getStatus().equals("OPEN")){
                count++;
            }
        }
        System.out.println(count+" institutes are admitting patients currently");
    }

    public void NotAdmittedPatient(){
        int count =0;
        for(int i=0; i<patients.size(); i++){
            if(patients.get(i).getAdmissionStatus() == 0){
                count++;
            }
        }
        System.out.println(count+" patients");
    }


    public void removeAdmittedPatient() {
        System.out.println("Account ID removed of admitted patients");
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getAdmissionStatus() == 1) {
                System.out.println(patients.get(i).getID());
            }
        }
    }
    public void removeClosedInstitute() {
        System.out.println("Accounts removed of Institute whose admission is closed");
        for (int i = 0; i <arrayInst.size(); i++) {
            if (arrayInst.get(i).getStatus().equals("CLOSED")) {
                System.out.println(arrayInst.get(i).getName());
            }
        }
    }

    public void displayAllPatients(Patient p){
        for (int i = 0; i < patients.size(); i++) {
            System.out.println(patients.get(i).getID() +" "+patients.get(i).getName());

        }
    }



}

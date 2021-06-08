import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        ArrayList<Patient> arrayPat ;
        ArrayList<healthCareInstitute> arrayInst ;
        Scanner inp = new Scanner(System.in);
        Patient pat = new Patient();
        arrayPat = pat.getArray();
        healthCareInstitute Ins = new healthCareInstitute(pat);
        healthCamp camp= new healthCamp();
        int num = inp.nextInt();
        inp.nextLine();
        for(int i=1; i<=num; i++){
            String data = inp.nextLine();
            String[] use= data.split(" ");
            String name = use[0];
            float temp = Float.parseFloat(use[1]);
            int O2 = Integer.parseInt(use[2]);
            int age = Integer.parseInt(use[3]);
            Patient patient = new Patient(i,name,temp,O2,age);
            arrayPat.add(patient);
            camp.selectEligiblePatients(patient);

        }

        int admitted = 0;
        while(admitted != num){
            int query = inp.nextInt();
            switch(query){
                case 1 :
                    inp.nextLine();
                    System.out.print("Name – ");
                    String name = inp.nextLine();
                    System.out.print("Temperature Criteria – ");
                    float temp = inp.nextFloat();
                    System.out.print("Oxygen Levels – ");
                    int o2 = inp.nextInt();
                    System.out.print("Number of Available beds – ");
                    int beds = inp.nextInt();
                    healthCareInstitute inst = new healthCareInstitute(name,temp,o2,beds);
                    Ins.getArray().add(inst);
                    camp.addHealthCareInstitute(inst);
                    System.out.println(name+"\nTemperature should be <= "+temp+
                            "\nOxygen levels should be >= "+o2+"\nNumber of Available beds – "+beds
                            +"\nAdmission Status – "+inst.getStatus());

                    beds = Ins.admitPatientToInstitute(pat,beds,o2,temp,name);
                    inst.setAvailableBeds(beds);
                    if(beds == 0)
                        inst.setStatus("CLOSED");

                    for(int i=0; i<arrayPat.size(); i++){
                        if(arrayPat.get(i).getAdmissionStatus() == 1 && arrayPat.get(i).getRecoveryDays()==0){
                            System.out.print("Recovery days for admitted patient ID "+arrayPat.get(i).getID()
                                    +" - ");
                            int recov = inp.nextInt();
                            arrayPat.get(i).setRecoveryDays(recov);
                            admitted ++ ;
                    }
                    }
                    break;

                case 2:
                    camp.removeAdmittedPatient();
                    break;

                case 3:
                    camp.removeClosedInstitute();
                    break;

                case 4:
                    camp.NotAdmittedPatient();
                    break;

                case 5:
                    camp.displayAdmittingInstitiutes();
                    break;

                case 6:
                    inp.nextLine();
                    String na = inp.nextLine();
                    Ins.displayHealthCareInstituteDetails(na);
                    break;

                case 7:
                    int id = inp.nextInt();
                    pat.detailsOfPatient(id);
                    break;

                case 8:
                    camp.displayAllPatients(pat);
                    break;

                case 9:
                    inp.nextLine();
                    String Name = inp.nextLine();
                    Ins.displayAdmittedPatientDetails(pat,Name);
                    break;
            }


        }

    }
}

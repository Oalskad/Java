package examinationmanagement;

import data.Doctor;
import data.People;
import list.DepartmentList;
import list.DoctorList;

/**
 *
 * @author hasu
 */
public class ExaminationManagement {
    private static String doctorFilePath = "Doctor.dat";
    private static String deparmentFilePath = "Department.dat";
    private static DoctorList doctorList = new DoctorList(doctorFilePath);
    private static DepartmentList deparmentList = new DepartmentList(deparmentFilePath);

    public static DoctorList getDoctorList() {
        return doctorList;
    }

    public static DepartmentList getDeparmentList() {
        return deparmentList;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        doctorList.load();

//        People d = new Doctor();
//        d.input();
//        doctorList.add(d);
//        System.out.println("Doctor: " + d.toString());
//        
////        People p = new Patient();
////        p.input();
////        System.out.println("Patient: " + p.toString());
//        
//        d.output();
////        p.output();
//        
//        System.out.println("++++++++++++++++++++++++++++");
//        
//        People xx = new Doctor();
//        xx.parseString(d.toString());
//        xx.output();
//        
////        People pp = new Patient();
////        pp.parseString(p.toString());
////        pp.output();
        for (People doctor : doctorList) {
            doctor.output();
        }

//        doctorList.save();
        Doctor dx = new Doctor();
        dx.input();
        doctorList.add(dx);
        doctorList.save();

        for (People doctor : doctorList) {
            doctor.output();
        }
    }

}

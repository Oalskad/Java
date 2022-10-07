package list;

import data.Doctor;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class doctor list
 *
 * @author hasu
 */
public class DoctorList extends ObjectList<Doctor> {

    public DoctorList() {
    }

    public DoctorList(String filePath) {
        super(filePath);
    }

    /**
     * Filter by department's id
     *
     * @param id department's id
     * @return List<Doctor>
     */
    @Override
    public List<Doctor> filter(String id) {
        String depId = id.toUpperCase();
        return stream().filter((doc -> doc.getDepartmentId().toUpperCase().equals(depId))).collect(Collectors.toList());
        
//        List<Doctor> filterList = new ArrayList();
//        for (Doctor doc : this) {
//            if (doc.getDepartmentId().toUpperCase().equals(depId)) {
//                filterList.add(doc);
//            }
//        }
//        return filterList;
    }

    @Override
    public List<Doctor> filter(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected Doctor parseString(String stringObject) {
        Doctor obj = new Doctor();
        obj.parseString(stringObject);
        return obj;
    }
}

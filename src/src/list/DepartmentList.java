package list;

import data.Department;
import java.util.Date;
import java.util.List;

/**
 * Class department list
 *
 * @author hasu
 */
public class DepartmentList extends ObjectList<Department> {

    public DepartmentList() {
    }

    public DepartmentList(String filePath) {
        super(filePath);
    }

    @Override
    public List<Department> filter(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Department> filter(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected Department parseString(String stringObject) {
        Department obj = new Department();
        obj.parseString(stringObject);
        return obj;
    }

}

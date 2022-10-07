/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list;

import data.Department;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hasu
 */
public class DepartmentList extends ArrayList<Department> {

    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public final void setFilePath(String filePath) {
        if (filePath != null && !filePath.isBlank()) {
            this.filePath = filePath;
        }
    }

    public DepartmentList() {
    }

    public DepartmentList(String filePath) {
        setFilePath(filePath);
    }

    public boolean load() {
//        try {
//            File file = new File(this.filePath);
//            try ( Scanner sc = new Scanner(file)) {
//                Doctor obj;
//                String data;
//                while (sc.hasNextLine()) {
//                    data = sc.nextLine();
//                    if (!data.isBlank()) {
//                        obj = new Department();
//                        obj.parseString(data);
//                        add(obj);
//                    }
//                }
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(DoctorList.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return false;
    }

    public boolean save() {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filePath, false));
            for (Department department : this) {
                writer.append(department.toString());
                writer.append("\n");
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(DoctorList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(DoctorList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        if (o instanceof Department d) {
            int idx = -1;
            for (int i = 0; i < size(); i++) {
                if (d.getId().equals(get(i).getId())) {
                    idx = i;
                    break;
                }
            }
            return idx;
        }
        return super.indexOf(o);
    }

    @Override
    public boolean add(Department department) {
        int idx = indexOf(department);
        if (idx >= 0) {
            remove(idx);
        }
        return super.add(department);
    }
}

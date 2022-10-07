package data;

import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Utils;

/**
 * Class department
 *
 * @author hasuA
 */
public class Department {

    private static String ID_PREFIX = "DEP";
    private static String ID_PATTERN = Department.ID_PREFIX + "\\d{5}";
    private static final int ATTRIBUTE_COUNT = 4;

    private String id;
    private String name;
    private Date createDate;
    private Date lastUpdateDate;

    /**
     * Get id pattern
     *
     * @return id pattern
     */
    public static String getIdPattern() {
        return Department.ID_PATTERN;
    }

    public String getId() {
        return id;
    }

    public final void setId(String id) {
        if (Utils.validateString(id, getIdPattern(), true)) {
            this.id = id.toUpperCase();
        }
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        if (!name.isBlank()) {
            this.name = name;
        }
    }

    public Date getCreateDate() {
        return createDate;
    }

    public final void setCreateDate(Date createDate) {
        if (validateDate(createDate, this.lastUpdateDate)) {
            this.createDate = createDate;
        }
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public final void setLastUpdateDate(Date lastUpdateDate) {
        if (validateDate(this.createDate, lastUpdateDate)) {
            this.lastUpdateDate = lastUpdateDate;
        }
    }

    public Department() {
    }

    public Department(String id, String name, Date createDate, Date lastUpdateDate) {
        setId(id);
        setName(name);
        setCreateDate(createDate);
        setLastUpdateDate(lastUpdateDate);
    }

    public boolean setAttribute(String[] attributes) {
        if (attributes != null && attributes.length >= getAttributeCount()) {
            int idx = 0;
            setId(attributes[idx++].trim());
            setName(attributes[idx++].trim());
            try {
                setCreateDate(Utils.toDate(attributes[idx++].trim()));
            } catch (ParseException ex) {
                Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                setLastUpdateDate(Utils.toDate(attributes[idx++].trim()));
            } catch (ParseException ex) {
                Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        return false;
    }

    protected int getAttributeCount() {
        return Department.ATTRIBUTE_COUNT;
    }

    private boolean validateDate(Date createDate, Date lastUpdateDate) {
        return false;
    }

}

package util;

import data.Department;
import examinationmanagement.ExaminationManagement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class utils
 *
 * @author hasu
 */
public final class Utils {

    public static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String IGNORE_CASE_PATTERN = "(?i)";

    public static int inputInteger(String message, int minValue, int maxValue) {
        int age = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(message + ": ");
            try {
                age = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (age < minValue || maxValue < age);
        return age;
    }

    public static String inputString(String message) {
        String inputString;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(message + ": ");
            inputString = sc.nextLine();
        } while (inputString.isBlank());
        return inputString;
    }

    public static Date toDate(String strDate) throws ParseException {
        if (strDate == null) {
            return null;
        }
        SimpleDateFormat df = new SimpleDateFormat(Utils.DATE_FORMAT);
        df.setLenient(false);
        return df.parse(strDate);
    }

    public static String toString(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat df = new SimpleDateFormat(Utils.DATE_FORMAT);
        return df.format(date);
    }

    public static Date inputDate(String message) {
        Scanner sc = new Scanner(System.in);
        Date date = null;
        do {
            System.out.print(message + "(" + Utils.DATE_FORMAT + "): ");
            try {
                date = toDate(sc.nextLine());
            } catch (ParseException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (date == null);
        return date;
    }

    public static boolean inputBoolean(String message) {
        System.out.print(message + "(" + Boolean.TRUE.toString() + "/" + Boolean.FALSE.toString() + "): ");
        Scanner sc = new Scanner(System.in);
        return Boolean.parseBoolean(sc.nextLine());
    }

    public static boolean validateString(String str, String regex, boolean ignoreCase) {
        if (str != null && regex != null) {
            if (ignoreCase) {
                regex = Utils.IGNORE_CASE_PATTERN + regex;
            }
            return str.matches(regex);
        }
        return false;
    }

    public static boolean validateDate(Date createDate, Date lastUpdateDate) {
        Date now = new Date();
        if (createDate == null) {
            return lastUpdateDate != null && !lastUpdateDate.after(now);
        } else if (lastUpdateDate == null) {
            return !createDate.after(now);
        }
        return !createDate.after(lastUpdateDate) && !lastUpdateDate.after(now);
    }

    public static boolean validateDepartmentId(String id) {
        Department obj = new Department();
        obj.setId(id);
        if (obj.getId() != null) {
            return ExaminationManagement.getDeparmentList().contains(obj);
        }
        return false;
    }

    private Utils() {
    }
}

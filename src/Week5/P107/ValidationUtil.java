/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week5.P107;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author tothi
 */
public class ValidationUtil {
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String DATETIME_FORMAT = "dd/MM/yyyy hh:mma"; // e.g. 21/12/2024 10:00AM

    public static boolean isValidID(String id) {
        if (id == null || id.length() != 6) return false;
        for (char c : id.toCharArray()) if (!Character.isDigit(c)) return false;
        return true;
    }

    public static boolean isValidName(String name) {
        if (name == null) return false;
        String trimmed = name.trim();
        if (trimmed.isEmpty()) return false;
        for (char c : trimmed.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') return false;
        }
        return true;
    }

    public static boolean isValidPhone(String phone) {
        if (phone == null || phone.length() != 12) return false;
        for (char c : phone.toCharArray()) if (!Character.isDigit(c)) return false;
        return true;
    }

    public static boolean isValidRoomNumber(String room) {
        if (room == null || room.length() != 4) return false;
        for (char c : room.toCharArray()) if (!Character.isDigit(c)) return false;
        return true;
    }

    public static boolean isValidDate(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            sdf.setLenient(false);
            Date d = sdf.parse(date);
            Date now = new Date();
            return d.after(now);
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isValidDateTime(String dateTime, String bookingDate) {
        if (dateTime == null || bookingDate == null) return false;
        try {
            SimpleDateFormat sdfDT = new SimpleDateFormat(DATETIME_FORMAT);
            sdfDT.setLenient(false);
            Date pickup = sdfDT.parse(dateTime);

            SimpleDateFormat sdfD = new SimpleDateFormat(DATE_FORMAT);
            sdfD.setLenient(false);
            Date bookDate = sdfD.parse(bookingDate);

            Calendar cal = Calendar.getInstance();
            cal.setTime(bookDate);
            cal.add(Calendar.DATE, 1);
            Date bookingEnd = cal.getTime();

            Date now = new Date();
            return pickup.after(now) && pickup.before(bookingEnd);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isIDExists(String id, ArrayList<Reservation> list) {
        if (id == null) return false;
        for (Reservation r : list) {
            if (id.equals(r.getBookingID())) return true;
        }
        return false;
    }

    public static Reservation findByID(String id, ArrayList<Reservation> list) {
        if (id == null) return null;
        for (Reservation r : list) {
            if (id.equals(r.getBookingID())) return r;
        }
        return null;
    }
}
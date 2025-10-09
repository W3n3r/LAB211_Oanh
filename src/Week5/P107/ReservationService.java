/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week5.P107;

/**
 *
 * @author tothi
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ReservationService {
    private final ArrayList<Reservation> reservations;

    public ReservationService() {
        this.reservations = new ArrayList<>();
    }

    public List<Reservation> getAll() {
        return Collections.unmodifiableList(reservations);
    }

    public boolean addReservation(Reservation r) {
        if (r == null) return false;
        if (ValidationUtil.isIDExists(r.getBookingID(), reservations)) return false;
        reservations.add(r);
        return true;
    }

    public Reservation findByID(String id) {
        return ValidationUtil.findByID(id, reservations);
    }

    public boolean updateReservation(Reservation updated) {
        if (updated == null || updated.getBookingID() == null) return false;
        Reservation existing = findByID(updated.getBookingID());
        if (existing == null) return false;
        existing.setCustomerName(updated.getCustomerName());
        existing.setPhoneNumber(updated.getPhoneNumber());
        existing.setRoomNumber(updated.getRoomNumber());
        existing.setDateTime(updated.getDateTime());
        existing.setFlightInformation(updated.getFlightInformation());
        return true;
    }

    public boolean deleteByID(String id) {
        Reservation r = findByID(id);
        if (r == null) return false;
        return reservations.remove(r);
    }

    public List<Reservation> listPickupSorted() {
        ArrayList<Reservation> withPickup = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getFlightInformation() != null && !r.getFlightInformation().isEmpty()) {
                withPickup.add(r);
            }
        }
        Collections.sort(withPickup, new Comparator<Reservation>() {
            @Override
            public int compare(Reservation a, Reservation b) {
                try {
                    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(ValidationUtil.DATETIME_FORMAT);
                    java.util.Date da = sdf.parse(a.getFlightInformation().getTimePickUp());
                    java.util.Date db = sdf.parse(b.getFlightInformation().getTimePickUp());
                    return da.compareTo(db);
                } catch (Exception e) {
                    return 0;
                }
            }
        });
        return withPickup;
    }

    public ArrayList<Reservation> internalList() {
        return reservations;
    }
}
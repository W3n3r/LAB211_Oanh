/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week5.P107;
import java.util.List;

/**
 *
 * @author tothi
 */
public class Printer {
    public static void printReservationDetail(Reservation r) {
        if (r == null) {
            System.out.println("No information to view");
            return;
        }
        System.out.println("ID - Name - Phone - RoomNumbers - BookingDate - Flight - Seat - TimePickUp");
        System.out.printf("%s - %s - %s - %s - %s - %s - %s - %s\n",
                r.getBookingID(),
                r.getCustomerName(),
                r.getPhoneNumber(),
                r.getRoomNumber(),
                r.getDateTime(),
                r.getFlightInformation().getFlightNumber(),
                r.getFlightInformation().getSeatNumber(),
                r.getFlightInformation().getTimePickUp());
    }

    public static void printAll(List<Reservation> list) {
        System.out.println("*** Reservation Information ***");
        if (list == null || list.isEmpty()) {
            System.out.println("No information to view");
            return;
        }
        System.out.println("ID - Name - Phone - RoomNumbers - BookingDate - Flight - Seat - TimePickUp");
        for (Reservation r : list) {
            System.out.printf("%s - %s - %s - %s - %s - %s - %s - %s\n",
                r.getBookingID(),
                r.getCustomerName(),
                r.getPhoneNumber(),
                r.getRoomNumber(),
                r.getDateTime(),
                r.getFlightInformation().getFlightNumber(),
                r.getFlightInformation().getSeatNumber(),
                r.getFlightInformation().getTimePickUp());
        }
    }

    public static void printFlightInformation(List<Reservation> pickups) {
        System.out.println("*** Flight Information ***");
        if (pickups == null || pickups.isEmpty()) {
            System.out.println("No information to view");
            return;
        }
        System.out.println("ID - Name - Phone - Flight - Seat - TimePickUp");
        for (Reservation r : pickups) {
            System.out.printf("%s - %s - %s - %s - %s - %s\n",
                r.getBookingID(),
                r.getCustomerName(),
                r.getPhoneNumber(),
                r.getFlightInformation().getFlightNumber(),
                r.getFlightInformation().getSeatNumber(),
                r.getFlightInformation().getTimePickUp());
        }
    }
}

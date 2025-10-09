/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week5.P107;

import java.util.Scanner;

/**
 *
 * @author tothi
 */

public class Test {
    private final ReservationService service;
    private final InputHelper input;
    private final Scanner scanner;

    public Test() {
        scanner = new Scanner(System.in);
        service = new ReservationService();
        input = new InputHelper(scanner, service);
    }

    private void createReservation() {
        System.out.println("*** Create new reservation ***");
        String bookingID = input.readIDUnique();
        String customerName = input.readName();
        String phoneNumber = input.readPhone();
        String roomNumber = input.readRoomNumber();
        String bookingDate = input.readBookingDate();

        FlightInformation flight = new FlightInformation(); // default empty
        if (input.readYesNo("Need airport pick up?")) {
            System.out.print("Flight: ");
            String flightNumber = scanner.nextLine().trim();
            System.out.print("Seat: ");
            String seat = scanner.nextLine().trim();
            String timePickUp = input.readTimePickUp(bookingDate);
            flight = new FlightInformation(flightNumber, seat, timePickUp);
        }

        Reservation r = new Reservation(bookingID, customerName, phoneNumber, roomNumber, bookingDate, flight);
        if (service.addReservation(r)) {
            System.out.println("Information saved successfully.");
        } else {
            System.out.println("Failed to save information (duplicate ID?).");
        }
    }

    private void updateReservation() {
        System.out.println("*** Update reservation ***");
        String id = input.readExistingIDOrCancel();
        if (id == null) return;

        Reservation existing = service.findByID(id);
        Printer.printReservationDetail(existing);
        System.out.println("If you do not want to change the information, just press enter to skip.");

        String name = input.readNameOptional();
        if (name != null) existing.setCustomerName(name);

        String phone = input.readPhoneOptional();
        if (phone != null) existing.setPhoneNumber(phone);

        String room = input.readRoomNumberOptional();
        if (room != null) existing.setRoomNumber(room);

        String bookingDateOld = existing.getDateTime();
        String bookingDate = input.readBookingDateOptional();
        if (bookingDate != null) existing.setDateTime(bookingDate);

        Boolean needPickup = input.readYesNoOptional("Need airport pick up?");
        if (needPickup != null) {
            if (needPickup) {
                System.out.print("Flight: ");
                String flightNumber = scanner.nextLine().trim();
                System.out.print("Seat: ");
                String seat = scanner.nextLine().trim();
                String effectiveBookingDate = (existing.getDateTime() == null || existing.getDateTime().isEmpty()) ? bookingDateOld : existing.getDateTime();
                String timePickUp = input.readTimePickUp(effectiveBookingDate);
                FlightInformation flight = new FlightInformation(flightNumber, seat, timePickUp);
                existing.setFlightInformation(flight);
            } else {
                existing.setFlightInformation(new FlightInformation());
            }
        }

        service.updateReservation(existing);

        Printer.printReservationDetail(existing);
        System.out.println("Information saved successfully.");
    }

    private void deleteReservation() {
        System.out.println("*** Delete reservation ***");
        String id = input.readExistingIDOrCancel();
        if (id == null) return;
        Reservation r = service.findByID(id);
        Printer.printReservationDetail(r);
        if (input.readYesNo("Are you sure you want to delete this information?")) {
            if (service.deleteByID(id)) {
                System.out.println("Information deleted successfully.");
            } else {
                System.out.println("Delete failed.");
            }
        }
    }

    private void printFlightInformation() {
        Printer.printFlightInformation(service.listPickupSorted());
    }

    private void printAll() {
        Printer.printAll(service.getAll());
    }

    public void run() {
        while (true) {
            System.out.println("*** Reservation Management ***");
            System.out.println("1. Create new reservation");
            System.out.println("2. Update reservation");
            System.out.println("3. Delete reservation");
            System.out.println("4. Print Flight Information");
            System.out.println("5. Print all");
            System.out.println("6. Exit");
            System.out.print("You choose: ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> createReservation();
                case "2" -> updateReservation();
                case "3" -> deleteReservation();
                case "4" -> printFlightInformation();
                case "5" -> printAll();
                case "6" -> {
                    System.out.println("BYE AND SEE YOU NEXT TIME");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public static void main(String[] args) {
        Test app = new Test();
        app.run();
    }
}
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
public class InputHelper {
    private final Scanner scanner;
    private final ReservationService service;

    public InputHelper(Scanner scanner, ReservationService service) {
        this.scanner = scanner;
        this.service = service;
    }

    public String readIDUnique() {
        while (true) {
            System.out.print("ID: ");
            String id = scanner.nextLine().trim();
            if (!ValidationUtil.isValidID(id)) {
                System.out.println("Data input is invalid");
                continue;
            }
            if (ValidationUtil.isIDExists(id, service.internalList())) {
                System.out.println("Data input is invalid");
                continue;
            }
            return id;
        }
    }

    public String readExistingIDOrCancel() {
        while (true) {
            System.out.print("ID: ");
            String id = scanner.nextLine().trim();
            Reservation r = service.findByID(id);
            if (r != null) return id;
            System.out.println("No information found");
            if (!readYesNo("You want to find again?")) return null;
        }
    }

    public String readName() {
        while (true) {
            System.out.print("Name: ");
            String name = scanner.nextLine().trim();
            if (ValidationUtil.isValidName(name)) return name;
            System.out.println("Data input is invalid");
        }
    }

    public String readNameOptional() {
        while (true) {
            System.out.print("Name: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) return null;
            if (ValidationUtil.isValidName(name)) return name;
            System.out.println("Data input is invalid");
        }
    }

    public String readPhone() {
        while (true) {
            System.out.print("Phone: ");
            String phone = scanner.nextLine().trim();
            if (ValidationUtil.isValidPhone(phone)) return phone;
            System.out.println("Data input is invalid");
        }
    }

    public String readPhoneOptional() {
        while (true) {
            System.out.print("Phone: ");
            String phone = scanner.nextLine().trim();
            if (phone.isEmpty()) return null;
            if (ValidationUtil.isValidPhone(phone)) return phone;
            System.out.println("Data input is invalid");
        }
    }

    public String readRoomNumber() {
        while (true) {
            System.out.print("RoomNumbers: ");
            String room = scanner.nextLine().trim();
            if (ValidationUtil.isValidRoomNumber(room)) return room;
            System.out.println("Data input is invalid");
        }
    }

    public String readRoomNumberOptional() {
        while (true) {
            System.out.print("RoomNumbers: ");
            String room = scanner.nextLine().trim();
            if (room.isEmpty()) return null;
            if (ValidationUtil.isValidRoomNumber(room)) return room;
            System.out.println("Data input is invalid");
        }
    }

    public String readBookingDate() {
        while (true) {
            System.out.print("BookingDate: ");
            String date = scanner.nextLine().trim();
            if (ValidationUtil.isValidDate(date)) return date;
            System.out.println("Data input is invalid");
        }
    }

    public String readBookingDateOptional() {
        while (true) {
            System.out.print("BookingDate: ");
            String date = scanner.nextLine().trim();
            if (date.isEmpty()) return null;
            if (ValidationUtil.isValidDate(date)) return date;
            System.out.println("Data input is invalid");
        }
    }

    public String readTimePickUp(String bookingDate) {
        while (true) {
            System.out.print("TimePickUp: ");
            String timePickUp = scanner.nextLine().trim();
            if (ValidationUtil.isValidDateTime(timePickUp, bookingDate)) return timePickUp;
            System.out.println("Data input is invalid");
        }
    }

    public String readTimePickUpOptional(String bookingDate) {
        while (true) {
            System.out.print("TimePickUp: ");
            String timePickUp = scanner.nextLine().trim();
            if (timePickUp.isEmpty()) return null;
            if (ValidationUtil.isValidDateTime(timePickUp, bookingDate)) return timePickUp;
            System.out.println("Data input is invalid");
        }
    }

    public boolean readYesNo(String question) {
        while (true) {
            System.out.print(question + " (Y/N): ");
            String ans = scanner.nextLine().trim().toUpperCase();
            if (ans.equals("Y")) return true;
            if (ans.equals("N")) return false;
            System.out.println("Data input is invalid");
        }
    }

    public Boolean readYesNoOptional(String question) {
        while (true) {
            System.out.print(question + " (Y/N): ");
            String ans = scanner.nextLine().trim();
            if (ans.isEmpty()) return null;
            ans = ans.toUpperCase();
            if (ans.equals("Y")) return true;
            if (ans.equals("N")) return false;
            System.out.println("Data input is invalid");
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week5.P107;

/**
 *
 * @author tothi
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class FlightInformation {
    private String flightNumber;
    private String seatNumber;
    private String timePickUp; // format dd/MM/yyyy hh:mma (e.g. 21/12/2024 10:00AM)

    public FlightInformation(String flightNumber, String seatNumber, String timePickUp) {
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.timePickUp = timePickUp;
    }

    public FlightInformation() {
        this.flightNumber = "";
        this.seatNumber = "";
        this.timePickUp = new SimpleDateFormat(ValidationUtil.DATETIME_FORMAT).format(new Date());
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getTimePickUp() {
        return timePickUp;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setTimePickUp(String timePickUp) {
        this.timePickUp = timePickUp;
    }

    public boolean isEmpty() {
        return (flightNumber == null || flightNumber.trim().isEmpty())
            && (seatNumber == null || seatNumber.trim().isEmpty());
    }

    @Override
    public String toString() {
        return flightNumber + " - " + seatNumber + " - " + timePickUp;
    }
}
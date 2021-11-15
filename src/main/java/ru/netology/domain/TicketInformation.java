package ru.netology.domain;

import java.util.Objects;

public class TicketInformation implements Comparable<TicketInformation> {

    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int travelTimeMinutes;

    public TicketInformation() {
    }

    public TicketInformation(int id, int price, String departureAirport, String arrivalAirport, int travelTimeMinutes) {
        this.id = id;
        this.price = price;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.travelTimeMinutes = travelTimeMinutes;
    }

    public boolean matches(String from, String to) {
        return departureAirport.contains(from) || arrivalAirport.contains(to);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public int getTravelTimeMinutes() {
        return travelTimeMinutes;
    }

    public void setTravelTimeMinutes(int travelTimeMinutes) {
        this.travelTimeMinutes = travelTimeMinutes;
    }

    @Override
    public int compareTo(TicketInformation o) {
        double diff = this.price - o.price;
        if (diff == 0) {
            return 0;
        } else if (diff < 0) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketInformation that = (TicketInformation) o;
        return id == that.id && price == that.price && travelTimeMinutes == that.travelTimeMinutes && departureAirport.equals(that.departureAirport) && arrivalAirport.equals(that.arrivalAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, departureAirport, arrivalAirport, travelTimeMinutes);
    }

    @Override
    public String toString() {
        return "TicketInformation{" +
                "id=" + id +
                ", price=" + price +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", travelTimeMinutes=" + travelTimeMinutes +
                '}';
    }
}

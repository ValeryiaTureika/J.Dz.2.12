package ru.netology.repository;

import ru.netology.domain.TicketInformation;

public class ProductRepository {
    private TicketInformation[] items = new TicketInformation[0];

    public void save(TicketInformation item) {
        int length = items.length + 1;
        TicketInformation[] tmp = new TicketInformation[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public TicketInformation[] findAll() {
        return items;
    }

    public TicketInformation findByAirport(String departureAirport, String arrivalAirport) {
        for (TicketInformation item : items) {
            if (item.getDepartureAirport() == departureAirport || item.getArrivalAirport() == arrivalAirport) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        TicketInformation[] tmp = new TicketInformation[length];
        int index = 0;
        for (TicketInformation item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}

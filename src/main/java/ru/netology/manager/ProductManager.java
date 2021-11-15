package ru.netology.manager;

import ru.netology.domain.TicketInformation;
import ru.netology.repository.ProductRepository;

import java.util.Arrays;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(TicketInformation ticket) {
        repository.save(ticket);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public TicketInformation[] findAll(String departureAirport, String arrivalAirport) {
        TicketInformation[] result = new TicketInformation[0];
        for (TicketInformation ticket : repository.findAll()) {
            if (ticket.matches(departureAirport, arrivalAirport)) {
                TicketInformation[] tmp = new TicketInformation[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
                Arrays.sort(result);
            }
        }
        return result;
    }
}

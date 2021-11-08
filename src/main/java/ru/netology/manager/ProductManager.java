package ru.netology.manager;

import ru.netology.domain.TicketInformation;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repository) {
        this.repo = repository;
    }

    public void add(TicketInformation item) {
        repo.save(item);
    }

    public void removeById(int id) {
        repo.removeById(id);
    }

    public TicketInformation[] searchBy(String from, String to) {
        TicketInformation[] result = new TicketInformation[0];
        TicketInformation[] tickets = repo.findAll();
        for (TicketInformation ticket : tickets) {
            if (matches(ticket, from, to)) {
                TicketInformation[] tmp = new TicketInformation[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(TicketInformation ticket, String from, String to) {
        if (ticket.getDepartureAirport().contains(from) || ticket.getArrivalAirport().contains(to)) {
            return true;
        }
        return false;
    }
}

package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketInformationTest {

    private final ProductManager manager = new ProductManager(new ProductRepository());
    private ProductRepository repo = new ProductRepository();

    private final TicketInformation first = new TicketInformation(1, 2199, "DME", "LED", 95);
    private final TicketInformation second = new TicketInformation(2, 1199, "LED", "KUF", 95);
    private final TicketInformation third = new TicketInformation(3, 3010, "DME", "FRU", 100);
    private final TicketInformation fourth = new TicketInformation(4, 2000, "KUF", "LED", 75);

    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    void shouldTicketSearchMinimumRequest() {
        TicketInformation[] expected = new TicketInformation[]{second, first};
        TicketInformation[] actual = new TicketInformation[]{first, second};

        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldTicketSearchMaximumRequest() {
        TicketInformation[] expected = new TicketInformation[]{second, fourth, first, third};
        TicketInformation[] actual = new TicketInformation[]{first, second, third, fourth};

        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchOneTicket() {

        TicketInformation[] expected = new TicketInformation[]{second};
        TicketInformation[] actual = manager.searchBy("LED", "KUF");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchTwoTickets() {

        TicketInformation[] expected = new TicketInformation[]{second, third};
        TicketInformation[] actual = manager.searchBy("LED", "FRU");

        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchThreeTickets() {

        TicketInformation[] expected = new TicketInformation[]{second, fourth, first};
        TicketInformation[] actual = manager.searchBy("LED", "LED");

        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
}

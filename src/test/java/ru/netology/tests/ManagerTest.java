package ru.netology.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AviaTicket;
import ru.netology.manager.ManagerTicket;
import ru.netology.repository.RepositoryTicket;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    RepositoryTicket repo = new RepositoryTicket();
    ManagerTicket man = new ManagerTicket(repo);
    AviaTicket s7 = new AviaTicket(1, 980, "DME", "AAQ", 300);
    AviaTicket aeroflot = new AviaTicket(2, 950, "VKO", "AAQ", 290);
    AviaTicket ua = new AviaTicket(3, 980, "VKO", "AAQ", 280);
    AviaTicket sma = new AviaTicket(4, 1000, "VKO", "AAQ", 300);
    AviaTicket ural = new AviaTicket(5, 200, "SVO", "MMK", 120);

    @BeforeEach
    public void setUp() {
        repo.save(s7);
        repo.save(aeroflot);
        repo.save(ua);
        repo.save(sma);
        repo.save(ural);
    }

    @Test
    public void managerEntry() {
        AviaTicket[] actual = man.searchBy("SVO");
        AviaTicket[] expected = {ural};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void managerExit() {
        AviaTicket[] actual = man.searchBy("AAQ");
        AviaTicket[] expected = {aeroflot, s7, ua, sma};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void managerNull() {
        AviaTicket[] actual = man.searchBy("VKU");
        AviaTicket[] expected = {};

        assertArrayEquals(expected, actual);

    }

}

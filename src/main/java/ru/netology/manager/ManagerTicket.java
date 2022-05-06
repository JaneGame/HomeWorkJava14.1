package ru.netology.manager;


import ru.netology.repository.RepositoryTicket;
import ru.netology.domain.AviaTicket;

import java.util.Arrays;

public class ManagerTicket {
    private RepositoryTicket repo;


    public ManagerTicket(RepositoryTicket repo) {
        this.repo = repo;
    }


    public AviaTicket[] searchBy(String text) {
        AviaTicket[] result = new AviaTicket[0];
        for (AviaTicket ticket : repo.findAll()) {
            if (matches(ticket, text)) {
                AviaTicket[] tmp = new AviaTicket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }

        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(AviaTicket ticket, String search) {
        AviaTicket Ticket = (AviaTicket) ticket;
        if (ticket.getEntry().contains(search)) {
            return true;
        }
        if (ticket.getExit().contains(search)) {
            return true;
        }
        return false;
    }

}

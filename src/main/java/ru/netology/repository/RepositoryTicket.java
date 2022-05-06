package ru.netology.repository;

import ru.netology.exception.NotFoundException;
import ru.netology.domain.AviaTicket;

public class RepositoryTicket {
    private AviaTicket[] items = new AviaTicket[0];

    public void save(AviaTicket item) {
        int length = items.length + 1;
        AviaTicket[] tmp = new AviaTicket[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public AviaTicket[] findAll() {
        return items;
    }

    public AviaTicket findById(int id) {
        for (AviaTicket item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        int length = items.length - 1;
        AviaTicket[] tmp = new AviaTicket[length];
        int index = 0;
        for (AviaTicket item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}

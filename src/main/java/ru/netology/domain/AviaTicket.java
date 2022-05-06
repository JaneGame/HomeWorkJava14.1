package ru.netology.domain;

public class AviaTicket implements Comparable<AviaTicket>{
    private int id;
    private int price;
    private String entry;
    private String exit;
    private int time;

    public AviaTicket(int id, int price, String entry, String exit, int time) {
        this.id = id;
        this.price = price;
        this.entry = entry;
        this.exit = exit;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getEntry() {
        return entry;
    }

    public String getExit() {
        return exit;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(AviaTicket o) {
        AviaTicket t = o;
        return price - t.price;
    }
}

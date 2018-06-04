package com.pls.me.hire.Touk.Ticket;

import com.pls.me.hire.Touk.Driver.Driver;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_ticket_seq_gen")
    @SequenceGenerator(name="my_ticket_seq_gen", sequenceName="MY_TICKET_SEQ")
    private long id;

    private long startTime;

    private long endTime;

    private double price;

    private boolean isPaid;

    @ManyToOne
    private Driver driver;

    public Ticket() {
    }

    public Ticket(Driver driver) {
        super();
        this.startTime = System.currentTimeMillis();
        this.endTime = 0;
        this.price = 0;
        this.driver = driver;
        this.isPaid = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}

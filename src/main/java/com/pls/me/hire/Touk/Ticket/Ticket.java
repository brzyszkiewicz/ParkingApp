package com.pls.me.hire.Touk.Ticket;

import com.pls.me.hire.Touk.Driver.Driver;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_ticket_seq_gen")
    @SequenceGenerator(name="my_ticket_seq_gen", sequenceName="MY_TICKET_SEQ")
    private long id;

    private ZonedDateTime startTime;

    private ZonedDateTime endTime;

    private double price;

    private boolean isPaid;

    @ManyToOne
    private Driver driver;

    public Ticket() {
    }

    public Ticket(Driver driver) {
        super();
        this.startTime = ZonedDateTime.now();
        this.endTime = null;
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

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
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

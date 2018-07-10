package com.bartek.rzyszkiewicz.driver;

import javax.persistence.*;

@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_driver_seq_gen")
    @SequenceGenerator(name="my_driver_seq_gen", sequenceName="MY_DRIVER_SEQ")
    private long id;

    private String name;

    private DriverType type;

    public Driver(){

    }

    public Driver(String name, DriverType type) {
        super();
        this.name = name;
        this.type = type;
    }

    public long getDriverId() {
        return id;
    }

    public void setDriverId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DriverType getType() {
        return type;
    }

    public void setType(DriverType type) {
        this.type = type;
    }

}

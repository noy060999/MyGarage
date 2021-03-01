package com.example.mylibrary;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private String[] Cars;
    private boolean open;
    private String address;
    private String name;

    public Garage(){}

    public Garage( String [] Cars, boolean open, String address, String name) {
        this.Cars = Cars;
        this.address = address;
        this.name = name;
        this.open = open;
    }

    public String[] getCars() {
        return Cars;
    }

    public void setCars(String[] cars) {
        Cars = cars;
    }

    public void setOpen(boolean open) {
        open = open;
    }
    public String getAddress() {
        return address;
    }

    public boolean getOpen() {
        return open;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

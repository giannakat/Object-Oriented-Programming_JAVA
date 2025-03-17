package com.example.payroll;

public class Employee {
    public String name;
    public double hours;
    public double wage;
    int id;
    static int ID = 25000;


    public Employee(String name, double hours, double wage) {
        this.id = ++ID;
        this.name = name;
        this.hours = hours;
        this.wage = wage;
    }

    public double salary(){
        return hours * wage;
    }

    @Override
    public String toString() {
        return id + " " + name + String.format(" %.2f", salary());
    }
}

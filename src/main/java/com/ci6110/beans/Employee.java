package com.ci6110.beans;

public class Employee {
    private long id; // Might make more sense to generate this, maybe?
    private String name;
    private float salary; // Might make more sense to use BigDecimal here

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}

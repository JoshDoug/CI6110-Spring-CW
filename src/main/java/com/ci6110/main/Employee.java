package com.ci6110.main;

import javax.persistence.*;

@Entity
@Table(name="EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue
    private Long employeeId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private float salary; // Might make more sense to use BigDecimal here

    public Employee() {
        super();
    }

    public Employee(String firstName, String lastName, float salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long id) {
        this.employeeId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getAnnualSalary() {
        return 12 * salary;
    }
}

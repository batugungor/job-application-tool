package com.aego;

public abstract class Employee {
    private int code;
    private String firstname;
    private String lastname;
    private Double salary;
    private Department works;

    public Employee(int code, String firstname, String lastname, Double salary) {
        this.code = code;
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
    }

    public Employee(int code, String firstname, String lastname, Double salary, Department works) {
        this.code = code;
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
        this.works = works;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Department getWorks() {
        return works;
    }

    public void setWorks(Department works) {
        this.works = works;
    }

    public abstract String getFullNameWithExtras ();

}

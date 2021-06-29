package com.aego;

public abstract class Employee extends Person {
    private int code;
    private Double salary;
    private Department works;

    public Employee(int code, String firstname, String lastname, Double salary) {
        this.code = code;
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.salary = salary;
    }

    public Employee(int code, String firstname, String lastname, Double salary, Department works) {
        this.code = code;
        this.setFirstname(firstname);
        this.setLastname(lastname);
        this.salary = salary;
        this.works = works;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

package com.aego;

public class RegularEmployee extends Employee {

    public RegularEmployee(int code, String firstname, String lastname, Double salary) {
        super(code, firstname, lastname, salary);
    }

    public RegularEmployee(int code, String firstname, String lastname, Double salary, Department works) {
        super(code, firstname, lastname, salary, works);
    }

    @Override
    public int getCode() {
        return 997 + super.getCode();
    }

    @Override
    public String getFullNameWithExtras() {
        return this.getFirstname() + " " + this.getLastname() + "met code" + this.getCode();
    }
}

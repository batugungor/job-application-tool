package com.aego;

public class Manager extends Employee {
    private Double bonus;

    public Manager(int code, String firstname, String lastname, Double salary, Double bonus) {
        super(code, firstname, lastname, salary);
        this.bonus = bonus;
    }

    @Override
    public int getCode() {
        return 998 + super.getCode();
    }

    @Override
    public String getFullNameWithExtras() {
        return this.getFirstname() + " " + this.getLastname() + "met code" + this.getCode() + "met bonus" + this.getBonus();
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }
}

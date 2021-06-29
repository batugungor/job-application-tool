package com.aego;

import java.util.ArrayList;

public class HumanResources extends Employee {
    private ArrayList<Employee> recruited = new ArrayList<Employee>();

    public HumanResources(int code, String firstname, String lastname, Double salary) {
        super(code, firstname, lastname, salary);
    }

    @Override
    public int getCode() {
        return 999 + super.getCode();
    }

    @Override
    public String getFullNameWithExtras() {
        return "human resources medewerker" + this.getFirstname() + " " + this.getLastname() + "met code" + this.getCode();
    }

    public ArrayList<Employee> getRecruited() {
        return recruited;
    }

    public void setRecruited(ArrayList<Employee> recruited) {
        this.recruited = recruited;
    }

    public void addToRecruited(Employee add) {
        boolean addToRecruited = true;

        for (Employee recruited: this.getRecruited()) {
            if (recruited.getCode() == add.getCode()) {
                addToRecruited = false;
            }
        }

        if(addToRecruited){
            this.recruited.add(add);
        }
    }
}

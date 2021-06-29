package com.aego;

import java.util.ArrayList;

public class Department {
    private String name;
    private Employee manager;
    private Employee hr;
    private ArrayList<Degree> requires = new ArrayList<Degree>();
    private static int workExperienceMinimum = 5;
    private ArrayList<Applicant> applicants = new ArrayList<Applicant>();

    public Department(String name, Employee manager, Employee hr){
        this.name = name;
        this.manager = manager;
        this.hr = hr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Employee getHr() {
        return hr;
    }

    public void setHr(Employee hr) {
        this.hr = hr;
    }

    public ArrayList<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(ArrayList<Applicant> applicants) {
        this.applicants = applicants;
    }

    public ArrayList<Degree> getRequires() {
        return requires;
    }

    public void setRequires(ArrayList<Degree> requires) {
        this.requires = requires;
    }

    public void addToRequires(Degree add) {
        boolean addToRequires = true;

        for (Degree recruited: this.getRequires()) {
            if (recruited.getType().equals(add.getType())) {
                addToRequires = false;
            }
        }

        if(addToRequires){
            this.requires.add(add);
        }
    }

    public boolean addToApplicants(Applicant add) {
        boolean addToApplicants = true;

        for (Applicant applicant: this.getApplicants()) {
            String name = applicant.getFirstname()+applicant.getLastname();
            String nameNew = add.getFirstname()+add.getLastname();
            if (name.equals(nameNew)) {
                addToApplicants = false;
            }
        }

        if(addToApplicants){
            this.applicants.add(add);
        }

        return addToApplicants;
    }

    public boolean hasRequiredSpecs(Applicant applicant) {
        return applicant.getExperience() >= workExperienceMinimum &&
                applicant.checkIfApplicantHasDegree(this.requires) &&
                applicant.isHasApplied() &&
                applicant.getRequestedSalary() <= 4500;
    }
}

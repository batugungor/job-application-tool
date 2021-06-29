package com.aego;

import java.util.ArrayList;

public class Applicant {
    private String firstname;
    private String lastname;
    private int experience;
    private Degree has;
    private Department applies;
    private boolean passed;
    private boolean appliedBefore;
    private boolean hasApplied;
    private double requestedSalary;

    public Applicant(String firstname, String lastname, int experience, Degree has, Department applies) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.experience = experience;
        this.has = has;
        this.applies = applies;
        this.appliedBefore = true;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Degree getHas() {
        return has;
    }

    public void setHas(Degree has) {
        this.has = has;
    }

    public Department getApplies() {
        return applies;
    }

    public void setApplies(Department applies) {
        this.applies = applies;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public boolean isAppliedBefore() {
        return appliedBefore;
    }

    public void setAppliedBefore(boolean appliedBefore) {
        this.appliedBefore = appliedBefore;
    }

    public boolean isHasApplied() {
        return hasApplied;
    }

    public void setHasApplied(boolean hasApplied) {
        this.hasApplied = hasApplied;
    }

    public double getRequestedSalary() {
        return requestedSalary;
    }

    public void setRequestedSalary(double requestedSalary) {
        this.requestedSalary = requestedSalary;
    }

    public String getJobLevel() {
        if (0 <= this.getExperience() && this.getExperience() < 3) {
            return "Junior";
        } else if (3 <= this.getExperience() && this.getExperience() < 6) {
            return "Medior";
        } else if (this.getExperience() >= 6) {
            return "Senior";
        }
        return "Unknown, error.";
    }



    public boolean checkIfApplicantHasDegree(ArrayList<Degree> degrees) {
        boolean has = false;

        for (Degree degree: degrees) {
            if (degree.getType().equals(this.getHas().getType())) {
                has = true;
            }
        }

        return has;
    }

    public Boolean hasTheInformation() {
        boolean first = false;
        boolean second = false;
        boolean third = false;

        if(this.getFirstname() != null) {
            first = true;
        }

        if(this.getHas() != null){
            second = true;
        }

        if(this.isAppliedBefore()) {
            third = true;
        }

        return first && second;
    }
}

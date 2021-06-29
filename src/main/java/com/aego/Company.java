package com.aego;

public class Company {
    private static Company firstInstance = null;
    private String name = "Aegon B.V.";

    private Company() {
    }

    public static Company getInstance() {
        if (firstInstance == null) {
            synchronized (Company.class) {
                if (firstInstance == null) {
                    firstInstance = new Company();

                }
            }
        }
        return firstInstance;
    }

    public String getCompanyName() {
        return firstInstance.name;
    }
}

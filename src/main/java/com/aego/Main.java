package com.aego;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(Company.getInstance().getCompanyName() + "Sollicitatie systeem");
        // Human Resources
        HumanResources hr = new HumanResources(120,"Human", "Resources", 250.000);

        // Diploma's ICT
        Degree ictDiploma = new Degree("HBO ICT");
        Degree niv4Diploma = new Degree("Niv 4 applicatie en media ontwikkelaar");

        // Manager ICT
        Manager ahmed = new Manager(252, "Ahmed", "Deedad", 300.000, 75.000);

        // Afdeling ICT
        Department ict = new Department("ICT", ahmed, hr);

        // Voeg diploma's toe aan ICT
        ict.addToRequires(ictDiploma);
        ict.addToRequires(niv4Diploma);

        // Voeg medewerkers toe aan ICT
        RegularEmployee kees = new RegularEmployee(254, "Kees", "Jan", 100.000, ict);
        RegularEmployee mahmud = new RegularEmployee(255, "Mahmud", "Test", 120.000, ict);

        // Voegt medewerkers toe aan de Human resources
        hr.addToRecruited(ahmed);
        hr.addToRecruited(kees);

        // Random diploma's die niet overeenkomen
        Degree random1 = new Degree("Zorg");
        Degree random2 = new Degree("Administratie");


        // Testdata andere applicants
        ict.addToApplicants(new Applicant("Applicant", "One", 2, ictDiploma, ict));
        ict.addToApplicants(new Applicant("Two", "Applicant", 5, ictDiploma, ict));

        // Sollicatie proces
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Voornaam:");
        System.out.println("-------------------------------------------------------------------");
        String firstname = scanner.nextLine();
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Achternaam:");
        System.out.println("-------------------------------------------------------------------");
        String lastname = scanner.nextLine();
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Werkervaring:");
        System.out.println("-------------------------------------------------------------------");
        int experience = scanner.nextInt();
        scanner.nextLine();
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Welk diploma heb je? Kies uit de volgende (typ het precies na):");
        System.out.println("-------------------------------------------------------------------");
        System.out.println(ictDiploma.getType());
        System.out.println(niv4Diploma.getType());
        System.out.println(random1.getType());
        System.out.println(random2.getType());
        System.out.println("-------------------------------------------------------------------");
        String degree = scanner.nextLine();
        System.out.println("-------------------------------------------------------------------");


        boolean passed = false;
//         Kijk of hij de benodigde diploma heb, zo wel, maak een nieuwe applicant aan als het zo is, anders negeren
        for (Degree requiredDegrees : ict.getRequires()) {
            if (requiredDegrees.getType().equals(degree)) {
                Applicant applicant = new Applicant(firstname, lastname, experience, requiredDegrees, ict);
                ict.addToApplicants(applicant);
                passed = true;
            }
        }

        if(passed) {
            System.out.println("Succesvol aangemeld");
        } else {
            System.out.println("U heeft niet de juiste diploma");
        }
//
//         Laat zien wie Human Resources allemaal heeft gerekruteerd
//       for (Employee recruited : hr.getRecruited()) {
//           System.out.println(recruited.getFirstname() + recruited.getLastname());
//       }
//
       // Laat zien wie allemaal heeft gesoliciteerd bij de ICT afdeling
//        for (Applicant x: ict.getApplicants()) {
//            System.out.println("Voornaam:" + x.getFirstname() + " Achternaam:" + x.getLastname() + " Werkervaring:" + x.getExperience() + " Diploma:" + x.getHas().getType());
//        }
    }
}


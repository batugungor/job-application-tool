import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @Test
    void addToApplicantsNonExisting() {
        // Human Resources
        HumanResources hr = new HumanResources(120,"Human", "Resources", 250.000);

        // Diploma's ICT
        Degree ictDiploma = new Degree("HBO ICT");
        Degree niv4Diploma = new Degree("Niv 4 applicatie en media ontwikkelaar");

        // Manager ICT
        Manager ahmed = new Manager(252, "Ahmed", "Deedad", 300.000, 75.000);

        // Afdeling ICT
        Department ict = new Department("ICT", ahmed, hr);

        assertTrue(ict.addToApplicants(new Applicant("Applicant", "One", 2, ictDiploma, ict)));
    }

    @Test
    void addToApplicantsExisting() {
        // Human Resources
        HumanResources hr = new HumanResources(120,"Human", "Resources", 250.000);

        // Diploma's ICT
        Degree ictDiploma = new Degree("HBO ICT");
        Degree niv4Diploma = new Degree("Niv 4 applicatie en media ontwikkelaar");

        // Manager ICT
        Manager ahmed = new Manager(252, "Ahmed", "Deedad", 300.000, 75.000);

        // Afdeling ICT
        Department ict = new Department("ICT", ahmed, hr);

        // Voeg applicant toe
        ict.addToApplicants(new Applicant("Applicant", "One", 2, ictDiploma, ict));

        assertFalse(ict.addToApplicants(new Applicant("Applicant", "One", 2, ictDiploma, ict)));
    }

   @Test
   void checkIfHeHasTheDegreeWithTrue() {
       // Human Resources
       HumanResources hr = new HumanResources(120, "Human", "Resources", 250.000);

       // Diploma's ICT
       Degree ictDiploma = new Degree("HBO ICT");
       Degree niv4Diploma = new Degree("Niv 4 applicatie en media ontwikkelaar");
       Degree random1 = new Degree("Zorg");

       // Manager ICT
       Manager ahmed = new Manager(252, "Ahmed", "Deedad", 300.000, 75.000);

       // Afdeling ICT
       Department ict = new Department("ICT", ahmed, hr);
       ict.addToRequires(ictDiploma);
       ict.addToRequires(niv4Diploma);

       // Applicant
       Applicant applicant = new Applicant("Applicant", "One", 2, ictDiploma, ict);

       assertTrue(applicant.checkIfApplicantHasDegree(ict.getRequires()));
   }

    @Test
    void checkIfHeHasTheDegreeWithFalse() {
        // Human Resources
        HumanResources hr = new HumanResources(120, "Human", "Resources", 250.000);

        // Diploma's ICT
        Degree ictDiploma = new Degree("HBO ICT");
        Degree niv4Diploma = new Degree("Niv 4 applicatie en media ontwikkelaar");
        Degree random1 = new Degree("Zorg");

        // Manager ICT
        Manager ahmed = new Manager(252, "Ahmed", "Deedad", 300.000, 75.000);

        // Afdeling ICT
        Department ict = new Department("ICT", ahmed, hr);
        ict.addToRequires(ictDiploma);
        ict.addToRequires(niv4Diploma);

        // Applicant
        Applicant applicant = new Applicant("Applicant", "One", 2, random1, ict);

        assertFalse(applicant.checkIfApplicantHasDegree(ict.getRequires()));
    }
}
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicantTest {

    public static Department testData() {
        Manager ahmed = new Manager(252, "Ahmed", "Deedad", 300.000, 75.000);

        Department ict = new Department("ICT", ahmed, ahmed);

        ict.addToRequires(new Degree("HBO ICT"));
        ict.addToRequires(new Degree("MBO niv 4 ICT"));

        return ict;
    }

    public static Applicant testDataWithDegree(String degree, int experience)  {
       return new Applicant("Batuhan", "Test", experience, new Degree(degree), testData());
    }

    public static Applicant testDataWithExistingDegree(Degree degree, int experience)  {
        return new Applicant("Batuhan", "Test", experience, degree, testData());
    }

    public static Applicant testDataWithoutDegree()  {
        return new Applicant("Batuhan", "Test", 2, null, testData());
    }

    public static Applicant testDataWithoutNameAndDegree()  {
        return new Applicant(null, "Test", 2, null, testData());
    }


    @Test
    void testDegree() {
        assertTrue(testDataWithDegree("HBO ICT", 4).hasTheInformation());
        assertFalse(testDataWithoutDegree().hasTheInformation());
        assertFalse(testDataWithoutNameAndDegree().hasTheInformation());
    }

    @Test
    void testDegreeTypes() {
        Applicant one = testDataWithDegree("HBO ICT", 0);
        Applicant two = testDataWithDegree("HBO ICT", 1);
        Applicant three = testDataWithDegree("MBO niv 4 ICT", 2);
        Applicant four = testDataWithDegree("MBO niv 4 ICT", 3);
        Applicant five = testDataWithDegree("MBO niv 4 zorg", 4);
        Applicant six = testDataWithDegree("MBO niv 4 zorg", 5);
        Applicant seven = testDataWithDegree("MBO niv 4 zorg", 6);
        Applicant eight = testDataWithDegree("MBO niv 4 zorg", 8);
        Applicant nine = testDataWithDegree("MBO niv 4 zorg", 15);

        assertEquals("Junior", one.getJobLevel());
        assertEquals("Junior", two.getJobLevel());
        assertEquals("Junior", three.getJobLevel());

        assertEquals("Medior", four.getJobLevel());
        assertEquals("Medior", five.getJobLevel());
        assertEquals("Medior", six.getJobLevel());

        assertEquals("Senior", seven.getJobLevel());
        assertEquals("Senior", eight.getJobLevel());
        assertEquals("Senior", nine.getJobLevel());
    }

    @Test
    void testDegreeAndExperience() {
        Applicant one = testDataWithDegree("HBO ICT", 7);
        one.setHasApplied(true);
        one.setRequestedSalary(4250.00);

        Applicant two = testDataWithDegree("HBO ICT", 3);
        two.setHasApplied(false);
        two.setRequestedSalary(5750.00);

        Applicant three = testDataWithDegree("MBO niv 4 ICT", 7);
        three.setHasApplied(false);
        three.setRequestedSalary(4250.00);

        Applicant four = testDataWithDegree("MBO niv 4 ICT", 3);
        four.setHasApplied(true);
        four.setRequestedSalary(5750.00);

        Applicant five = testDataWithDegree("MBO niv 4 zorg", 7);
        five.setHasApplied(true);
        five.setRequestedSalary(5750.00);

        Applicant six = testDataWithDegree("MBO niv 4 zorg", 3);
        six.setHasApplied(false);
        six.setRequestedSalary(4250.00);


        assertTrue(testData().hasRequiredSpecs(one));
        assertFalse(testData().hasRequiredSpecs(two));
        assertFalse(testData().hasRequiredSpecs(three));
        assertFalse(testData().hasRequiredSpecs(four));
        assertFalse(testData().hasRequiredSpecs(five));
        assertFalse(testData().hasRequiredSpecs(six));
    }
}

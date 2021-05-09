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
        Applicant testOne = testDataWithDegree("HBO ICT", 4);
        Applicant testTwo = testDataWithDegree("MBO niv 4 ICT", 4);
        Applicant testThree = testDataWithDegree("MBO niv 4 zorg", 4);

        assertTrue(testOne.checkIfApplicantHasDegree(testData().getRequires()));
        assertTrue(testTwo.checkIfApplicantHasDegree(testData().getRequires()));
        assertFalse(testThree.checkIfApplicantHasDegree(testData().getRequires()));
    }

    @Test
    void testDegreeAndExperience() {
        Applicant testOne = testDataWithDegree("HBO ICT", 6);
        Applicant testTwo = testDataWithDegree("MBO niv 4 ICT", 4);

        assertTrue(testData().hasRequiredSpecs(testOne));
        assertFalse(testData().hasRequiredSpecs(testTwo));
    }
}

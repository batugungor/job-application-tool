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
        Manager ahmed = new Manager(252, "Ahmed", "Deedad", 300.000, 75.000);

        Department hboIct = new Department("hbo ict", ahmed, ahmed);
        Department mboNiv4 = new Department("mboNiv4", ahmed, ahmed);
        Department zorg = new Department("zorg", ahmed, ahmed);


        Degree hboIctDegree = new Degree("HBO ict");
        Degree mboNiv4Degree = new Degree("MBO niv 4 ICT");
        Degree zorgDegree = new Degree("MBO niv 4 zorg");

        hboIct.addToRequires(hboIctDegree);
        mboNiv4.addToRequires(mboNiv4Degree);
        zorg.addToRequires(zorgDegree);



        Applicant testOne = testDataWithExistingDegree(hboIctDegree, 4);
        Applicant testTwo = testDataWithExistingDegree(mboNiv4Degree, 4);
        Applicant testThree = testDataWithExistingDegree(zorgDegree, 4);

        assertTrue(testOne.checkIfApplicantHasDegree(hboIct.getRequires()));
        assertTrue(testTwo.checkIfApplicantHasDegree(mboNiv4.getRequires()));
        assertTrue(testThree.checkIfApplicantHasDegree(zorg.getRequires()));

        assertFalse(testTwo.checkIfApplicantHasDegree(hboIct.getRequires()));
        assertFalse(testOne.checkIfApplicantHasDegree(mboNiv4.getRequires()));
        assertFalse(testOne.checkIfApplicantHasDegree(zorg.getRequires()));
    }

    @Test
    void testDegreeAndExperience() {
        Applicant testOne = testDataWithDegree("HBO ICT", 6);
        Applicant testTwo = testDataWithDegree("MBO niv 4 zorg", 6);
        Applicant testThree = testDataWithDegree("HBO ICT", 4);
        Applicant testFour = testDataWithDegree("MBO niv 4 zorg", 4);

        assertTrue(testData().hasRequiredSpecs(testOne));
        assertFalse(testData().hasRequiredSpecs(testTwo));
        assertFalse(testData().hasRequiredSpecs(testThree));
        assertFalse(testData().hasRequiredSpecs(testFour));
    }
}

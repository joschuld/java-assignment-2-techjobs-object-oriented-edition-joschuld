package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    //TODO: Three Tests for Task 4
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //five of each type: assertTrue & assertEquals

        assertTrue(job1 instanceof Job);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(job1.getName(), "Product tester");
        assertEquals(job1.getEmployer().getValue(), "ACME");
        assertEquals(job1.getLocation().getValue(),"Desert");
        assertEquals(job1.getPositionType().getValue(), "Quality control");
        assertEquals(job1.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.getId() == job2.getId());

    }

    //TODO: TDD TO BUILD THE toString() METHOD
    @Test
//    the one failing test, "testTestToStringStartsAndEndsWithNewLineCallsAssertions"
    public void testToStringStartsAndEndsWithNewLine(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String spec = "\n" + "\n";
        int lastCharIndex = job1.toString().length() - 1;
        assertEquals(job1.toString().charAt(0) + String.valueOf(job1.toString().charAt(lastCharIndex)), spec);
}
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String spec =
                "\n" +
                        "ID: " + job1.getId() + "\n" +
                        "Name: " +  job1.getName() + "\n" +
                        "Employer: " + job1.getEmployer() + "\n" +
                        "Location: " + job1.getLocation() + "\n" +
                        "Position Type: " + job1.getPositionType() + "\n" +
                        "Core Competency: " + job1.getCoreCompetency() +
                "\n";
        assertEquals(job1.toString(),spec);
    }

    @Test
    // I made this test handle both empty fields and null
    // -- "" or null --
    public void testToStringHandlesEmptyField(){
        Job job1 = new Job(null, new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String spec =  "\n" +
                "ID: " + job1.getId() + "\n" +
                "Name: " +  "Data not available" + "\n" +
                "Employer: " + "Data not available" + "\n" +
                "Location: " + "Data not available" + "\n" +
                "Position Type: " + "Data not available" + "\n" +
                "Core Competency: " + "Data not available" +
                "\n";

        assertEquals(job1.toString(), spec);

    }

}

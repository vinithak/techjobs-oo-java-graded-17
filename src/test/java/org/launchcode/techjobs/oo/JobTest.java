package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.time.format.FormatStyle;

import static org.junit.Assert.assertNotEquals;
import static org.testng.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class JobTest {
    //TODO: Create your unit tests here


    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(),job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(newJob.getEmployer() instanceof Employer);
        assertEquals(newJob.getEmployer().getValue(),"ACME");
        assertTrue(newJob.getLocation() instanceof Location);
        assertEquals(newJob.getLocation().getValue(),"Desert");
        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertEquals(newJob.getPositionType().getValue(),"Quality control");
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(newJob.getCoreCompetency().getValue(),"Persistence");
        assertTrue(newJob.getName() instanceof String);
        assertEquals(newJob.getName(),"Product tester");
    }
@Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));

}
@Test
    public void testToStringStartsAndEndsWithNewLine(){
    Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    String newLine = System.lineSeparator();
    assertTrue(job1.toString().startsWith("\n"));
    assertTrue(job1.toString().endsWith("\n"));
}

@Test
public void testToStringContainsCorrectLabelsAndData(){
    Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    String newLine = System.lineSeparator();
    String expectedOutput =  String.format( "\nID: %d\n" +
            "Name: %s\n" +
            "Employer: %s\n" +
            "Location: %s\n" +
            "Position Type: %s\n" +
            "Core Competency: %s\n", job1.getId(),job1.getName(), job1.getEmployer(),job1.getLocation(),job1.getPositionType(),job1.getCoreCompetency());
    assertEquals(job1.toString(),expectedOutput);
}

@Test
public void testToStringHandlesEmptyField(){
    Job job1 = new Job("Web Developer", new Employer(""), new Location("StL"), new PositionType(""), new CoreCompetency("Java"));
    String newLine = System.lineSeparator();
    String name = (job1.getName().isEmpty()) ? "Data not available" : job1.getName();
    String employer = (job1.getEmployer().toString().isEmpty()) ? "Data not available" : job1.getEmployer().toString();
    String location = (job1.getLocation().toString().isEmpty()) ? "Data not available" : job1.getLocation().toString();
    String positionType = (job1.getPositionType().toString().isEmpty()) ? "Data not available" : job1.getPositionType().toString();
    String coreCompetency = (job1.getCoreCompetency().toString().isEmpty()) ? "Data not available" : job1.getCoreCompetency().toString();

    String expectedOutput =  String.format( "\nID: %d\n" +
            "Name: %s\n" +
            "Employer: %s\n" +
            "Location: %s\n" +
            "Position Type: %s\n" +
            "Core Competency: %s\n", job1.getId(),name, employer,location,positionType,coreCompetency);
    assertEquals(job1.toString(),expectedOutput);
}

@Test
public void testToStringContainsNoField(){
    Job job1 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
    assertEquals(job1.toString(),"OOPS! This job does not seem to exist.");
}
}

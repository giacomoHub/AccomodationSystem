/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accomodationsystem;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juanestebanvargassalamanca
 */
public class StudentTest {
    
    public StudentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getStudentNumber method, of class Student.
     */
    @Test
    public void testGetStudentNumber() {
        System.out.println("getStudentNumber");
        Student instance = new Student(17028089, "Count", "Dracula");
        int expResult = 17028089;
        int result = instance.getStudentNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstName method, of class Student.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Student instance = new Student(17028089, "Count", "Dracula");
        String expResult = "Count";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getLastName method, of class Student.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Student instance = new Student(17028089, "Count", "Dracula");
        String expResult = "Dracula";
        String result = instance.getLastName();
        assertEquals(expResult, result);

    }
    
    /**
     * Test of setFirstName method, of class Student.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "John";
        Student instance = new Student(17028089, "", "");
        instance.setFirstName(firstName);
        System.out.println(instance.toString());
        
        
    }

    /**
     * Test of setLastName method, of class Student.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "McQuack";
        Student instance = new Student(17028089, "", "");
        instance.setLastName(lastName);
        System.out.println(instance.toString());
    }

    /**
     * Test of getFullName method, of class Student.
     */
    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        Student instance = new Student(17028089, "Count", "Dracula");
        String expResult = "Count Dracula";
        String result = instance.getFullName();
        assertEquals(expResult, result);

    }
    
}

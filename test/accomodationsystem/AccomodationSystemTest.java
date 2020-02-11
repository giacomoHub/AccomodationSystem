/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accomodationsystem;

import java.util.ArrayList;
import javafx.stage.Stage;
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
public class AccomodationSystemTest {
    
    public AccomodationSystemTest() {
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
     * Test of start method, of class AccomodationSystem.
     */
//    @Test
//    public void testStart() throws Exception {
//        System.out.println("start");
//        Stage stage = null;
//        AccomodationSystem instance = new AccomodationSystem();
//        instance.start(stage);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    
    @Test
    public void testHall() {
        
        Address address_test = new Address( "frenchay", "Fr_block", 3, "BR10", "Bristol", "Somerset", "England");
        Telephone tel_tes = new Telephone("+44", "0103", "64645");
        Room room_test = new Room(1, true, 300, 0);
        Hall hall_test = new Hall("Wallscourt",address_test , tel_tes );
        Student stu_test = new Student(0010, "juju", "rogers");
        Lease lease_test = new Lease(stu_test, 300, 4);
        
        room_test.setLease(lease_test);
        hall_test.addRoom(room_test);
        
        
        System.out.println(hall_test.toString());
        
    }
    
    @Test
    public void testGenerateData() {
        
//        Hall h1 = new Hall("Walls Court", new Address("Coldharbour Ln", "Campus, Wallscourt Park - UWE Bristol Frenchay, , Bristol BS16 1QY", buildingName, 0, postcode, city, county, country) , telephone);
//        Hall h2 = new Hall("Victoria Accommodation", new Address(streetName, buildingName, 0, postcode, city, county, country), telephone);
//        Hall h3 = new Hall("Francis Drake", address, telephone);
//        Hall h4 = new Hall("Robbins Hall", address, telephone);
        
    }
}

//4 different hall - 100 rooms for loop for roomms

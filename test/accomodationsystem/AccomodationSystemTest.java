/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accomodationsystem;

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
        
        Address address_test = new Address("frenchay Road", "Fr_block", 3, "BR10", "Bristol", "Somerset", "England");
        Telephone tel_tes = new Telephone(+44, 0103, 64645);
        Room room_test = new Room(1, true, 300, 0, new Lease(new Student(10102, "Mohamed", "Kadir"), 3, 01));
        Hall hall_test = new Hall("Wallscourt",address_test , tel_tes, room_test );
        
        System.out.println("this is the value of address object: " + ' ' + address_test.toString());
        
        System.out.println(hall_test.toString());
        
    }
    
}

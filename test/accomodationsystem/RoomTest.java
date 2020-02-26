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
public class RoomTest {
    
    public RoomTest() {
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
     * Test of setMontlyRentRate method, of class Room.
     */
    @Test
    public void testSetMontlyRentRate() {
        System.out.println("setMontlyRentRate");
        int monthlyRent = 120;
        Room instance = new Room(10, true, 0, 3);
        instance.setMontlyRentRate(monthlyRent);
        instance.toString();
    }

    /**
     * Test of setRoomCleanliness method, of class Room.
     */
    @Test
    public void testSetRoomCleanliness() {
        System.out.println("setRoomCleanliness");
        int roomCleanliness = 2;
        Room instance = new Room(10, true, 100, 0);
        instance.setRoomCleanliness(roomCleanliness);
        instance.toString();
    }

    /**
     * Test of setLease method, of class Room.
     */
    @Test
    public void testSetLease() {
        System.out.println("setLease");
        Room instance = new Room(10, true, 100, 0);
        instance.setLease(new Lease());
        instance.toString();
    }

    /**
     * Test of setRoomStatus method, of class Room.
     */
    @Test
    public void testSetRoomStatus() {
        System.out.println("setRoomStatus");
        boolean roomStatus = false;
        Room instance = new Room(10, true, 100, 0);
        instance.setRoomStatus(roomStatus);
        instance.toString();
    }

    /**
     * Test of getRoomStatus method, of class Room.
     */
    @Test
    public void testGetRoomStatus() {
        System.out.println("getRoomStatus");
        Room instance = new Room(10, true, 100, 0);
        String expResult = "Occupied";
        String result = instance.getRoomStatus();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getMonthlyRentRate method, of class Room.
     */
    @Test
    public void testGetMonthlyRentRate() {
        System.out.println("getMonthlyRentRate");
        Room instance = new Room(10, true, 100.30F, 0);
        float expResult = 100.30F;
        float result = instance.getMonthlyRentRate();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getRoomCleanliness method, of class Room.
     */
    @Test
    public void testGetRoomCleanliness() {
        System.out.println("getRoomCleanliness");
        Room instance = new Room(10, true, 50, 2);
        String expResult = "Offline";
        String result = instance.getRoomCleanliness();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of deleteLease method, of class Room.
     */
    @Test
    public void testDeleteLease() {
        System.out.println("deleteLease");
        Room instance = new Room(10, true, 50, 2);
        instance.deleteLease();
        assertEquals(instance.getLease(), null);
    }

    /**
     * Test of getRoomNumber method, of class Room.
     */
    @Test
    public void testGetRoomNumber() {
        System.out.println("getRoomNumber");
        Room instance = new Room(10, true, 50, 2);
        int expResult = 10;
        int result = instance.getRoomNumber();
        assertEquals(expResult, result);
    }
    
}

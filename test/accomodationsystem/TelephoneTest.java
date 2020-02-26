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
public class TelephoneTest {
    
    public TelephoneTest() {
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
     * Test of getCountryCode method, of class Telephone.
     */
    @Test
    public void testGetCountryCode() {
        System.out.println("Testing Telephone Class");
        
        Telephone telTest = new Telephone("+44", "0117", "9656261");
        
        String expCountryCode = "+44";
        
        String resultCountryCode = telTest.getCountryCode();
        
        System.out.println("Testing country code number");
        assertEquals(expCountryCode, resultCountryCode);
    }

    /**
     * Test of getAreaCode method, of class Telephone.
     */
    @Test
    public void testGetAreaCode() {
        Telephone telTest = new Telephone("+44", "0117", "9656261");

        String expAreaCode = "0117";
        
        String resultAreaCode = telTest.getAreaCode();
       
        System.out.println("Testing area number");
        assertEquals(expAreaCode, resultAreaCode);

    }

    /**
     * Test of getTelephoneNumber method, of class Telephone.
     */
    @Test
    public void testGetTelephoneNumber() {
        Telephone telTest = new Telephone("+44", "0117", "9656261");
        
        String expTel = "9656261";
        
        String resultTel = telTest.getTelephoneNumber();
       
        System.out.println("Testing tel number");
        assertEquals(expTel, resultTel);

    }
}

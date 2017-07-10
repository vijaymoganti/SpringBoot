package com.vijay.boot;

import static org.junit.Assert.assertEquals;

import com.vijay.boot.controller.HomeController;

import org.junit.Test;


public class AppTest {
    
    @Test
    public void testApp() {
		
		HomeController hc = new HomeController();
		String result = hc.home();
		assertEquals(result, "Spring boot working!!");
        
    }
}

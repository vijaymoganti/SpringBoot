package com.vijay.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("running");
        SpringApplication.run(App.class, args);
    }
}

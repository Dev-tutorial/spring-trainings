package com.dev.springaop;

import com.dev.springaop.demo.DemoClass;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	DemoClass demoClass = new DemoClass();
    	System.out.println( "call to example method" );
    	demoClass.example();
        
    }
}

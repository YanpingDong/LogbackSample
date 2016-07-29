package com.dyp.logback.lbsample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	static Logger LOG = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
    	LOG.trace("======trace");  
    	LOG.debug("======debug");  
    	LOG.info("======info");  
    	LOG.warn("======warn");  
    	LOG.error("======error");  
    }
}

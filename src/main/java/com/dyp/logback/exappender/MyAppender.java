package com.dyp.logback.exappender;

import static ch.qos.logback.core.CoreConstants.CODES_URL;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.Layout;
import ch.qos.logback.core.encoder.Encoder;
import ch.qos.logback.core.status.ErrorStatus;

public class MyAppender<E> extends AppenderBase<E> {

	protected Encoder<E> encoder;
	
    /**
     * All synchronization in this class is done via the lock object.
     */
    protected final ReentrantLock lock = new ReentrantLock(true);
	
    public Encoder<E> getEncoder() {
        return encoder;
    }

    public void setEncoder(Encoder<E> encoder) {
        this.encoder = encoder;
    }
	
	/**
     * Checks that requires parameters are set and if everything is in order,
     * activates this appender.
     * this function will be invoked by logback framwork when do auto configuration
     */
    public void start() {
        int errors = 0;
        if (this.encoder == null) {
            addStatus(new ErrorStatus("No encoder set for the appender named \"" + name + "\".", this));
            errors++;
        }

        // only error free appenders should be activated
        if (errors == 0) {
            super.start();
        }
    }
	
    
	@Override
	protected void append(E event) {
		 if (!isStarted()) {
	            return;
	        }
		 
		 lock.lock();
	
		 try {
			encoder.doEncode(event);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}   
         
	}

}

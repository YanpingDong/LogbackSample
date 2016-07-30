package com.dyp.logback.exappender;

import ch.qos.logback.core.encoder.Encoder;
import ch.qos.logback.core.spi.ContextAwareBase;

abstract public class MyPatternEncoderBase<E> extends ContextAwareBase implements Encoder<E>{

    protected boolean started;

    String pattern;

    // due to popular demand outputPatternAsHeader is set to false by default
    protected boolean outputPatternAsHeader = false;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
    
    public boolean isStarted() {
        return started;
    }

    public void start() {
        started = true;
    }

    public void stop() {
        started = false;
    }

}

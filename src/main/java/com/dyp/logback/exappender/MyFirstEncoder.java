package com.dyp.logback.exappender;

import java.io.IOException;
import java.io.OutputStream;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Layout;

public class MyFirstEncoder extends MyPatternEncoderBase<ILoggingEvent> {

	protected Layout<ILoggingEvent> layout;
	
    public Layout<ILoggingEvent> getLayout() {
        return layout;
    }

    public void setLayout(Layout<ILoggingEvent> layout) {
        this.layout = layout;
    }
    
    @Override
    public void start() {
        PatternLayout patternLayout = new PatternLayout();
        patternLayout.setContext(context);
        patternLayout.setPattern(getPattern());
        patternLayout.setOutputPatternAsHeader(outputPatternAsHeader);
        patternLayout.start();
        this.layout = patternLayout;
        super.start();
    }
	@Override
	public void init(OutputStream os) throws IOException {
		// Don't use Stream to do output 
		// this function will be automatic invoked by logback framwork 
	}

	@Override
	public void doEncode(ILoggingEvent event) throws IOException {
		if( null != layout)
		{
			System.out.println("invoke MyFirstEncoder doEncode");
			String txt = layout.doLayout(event);
			System.out.println(txt);
			System.out.println("===============end================");
		}
		else
		{
			System.out.println( ((ILoggingEvent)event).getMessage());
		}
		
	}

	@Override
	public void close() throws IOException {
		// nothing to close
	}

}

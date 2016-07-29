package com.dyp.logback.exappender;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;

public class MyAppender extends AppenderBase<LoggingEvent> {

	@Override
	protected void append(LoggingEvent eventObject) {
		 System.out.println(eventObject.getMessage() + " === ");
	}

}

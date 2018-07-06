package by.serge.logger.impl;

import by.serge.Event;
import by.serge.logger.EventLogger;

public class ConsoleEventLogger implements EventLogger {

	@Override
	public void logEvent(Event event) {
		System.out.println(event.getMsg());

	}

}

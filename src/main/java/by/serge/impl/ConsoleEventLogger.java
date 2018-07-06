package by.serge.impl;

import by.serge.Event;
import by.serge.EventLogger;

public class ConsoleEventLogger implements EventLogger {

	@Override
	public void logEvent(Event event) {
		System.out.println(event.getMsg());

	}

}

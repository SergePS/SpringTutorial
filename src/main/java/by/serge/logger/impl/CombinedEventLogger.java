package by.serge.logger.impl;

import java.util.List;

import by.serge.Event;
import by.serge.logger.EventLogger;

public class CombinedEventLogger implements EventLogger {

	private List<EventLogger> loggers;


	public CombinedEventLogger() {
	}


	public CombinedEventLogger(List<EventLogger> loggers) {
		this.loggers = loggers;
	}


	@Override
	public void logEvent(Event event) {

		for (EventLogger logger : loggers) {
			logger.logEvent(event);
		}

	}

}

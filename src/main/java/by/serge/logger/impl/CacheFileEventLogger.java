package by.serge.logger.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.serge.Event;

public class CacheFileEventLogger extends FileEventLogger {

	private static Logger logger = LogManager.getFormatterLogger(CacheFileEventLogger.class);

	private int cacheSize;
	private List<Event> cache = new ArrayList<>();


	CacheFileEventLogger() {
	}


	public CacheFileEventLogger(int cacheSize, String fileName) {
		super(fileName);
		this.cacheSize = cacheSize;
	}


	public void logEvent(Event event) {
		cache.add(event);
		if (cache.size() == cacheSize) {
			writeEventsFromCache(cache);
			cache.clear();
		}
	}


	private void writeEventsFromCache(List<Event> cache) {
		StringBuilder sb = new StringBuilder();
		for (Event evnt : cache) {
			sb.append(evnt.getMsg());
		}
		super.logEvent(sb.toString());
	}


	@SuppressWarnings("unused")
	private void destroy() {
		logger.log(Level.DEBUG, "Destroy method preparing");
		if (cache.size() > 0) {
			logger.log(Level.DEBUG, "Destroy method has been called");
			writeEventsFromCache(cache);
		}
	}

}

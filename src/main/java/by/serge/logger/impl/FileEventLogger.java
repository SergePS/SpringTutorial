package by.serge.logger.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.serge.Event;
import by.serge.logger.EventLogger;

public class FileEventLogger implements EventLogger {

	private static Logger logger = LogManager.getLogger(FileEventLogger.class);
	private final static String ENCODING = "UTF-8";
	private final static boolean APPEND = true;
	private final static String NEXT_LINE = "\n";

	private String fileName;
	private File file;


	public FileEventLogger() {

	}


	public FileEventLogger(String fileName) {
		this.fileName = fileName;
	}


	@Override
	public void logEvent(Event event) {
		eventWtiteToFile(event.getMsg());
	}


	public void logEvent(String msg) {
		eventWtiteToFile(msg);
	}


	private void eventWtiteToFile(String msg) {
		try {
			FileUtils.writeStringToFile(file, NEXT_LINE + msg, ENCODING, APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@SuppressWarnings("unused")
	private void init() throws IOException {
		this.file = new File(fileName);
		logger.log(Level.DEBUG, "Init method: File access - " + this.file.canWrite());
	}

}

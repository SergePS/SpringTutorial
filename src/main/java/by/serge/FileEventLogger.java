package by.serge;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

	private String fileName;
	private File file;

	public FileEventLogger(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void logEvent(Event event) {
		// appends to file

	}

	public void init() throws IOException {
		this.file = new File(fileName);
		this.file.canWrite();
	}

}

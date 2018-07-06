package by.serge;

public class IdGenerator {

	private static int id = 1;

	private IdGenerator() {
	}

	public static int getId() {
		return id++;
	}

}

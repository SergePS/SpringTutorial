package by.serge;

public class Client {

	private String id;
	private String fullName;
	private String title;


	Client() {
	}


	public Client(String id, String fullName) {
		super();
		this.id = id;
		this.fullName = fullName;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}

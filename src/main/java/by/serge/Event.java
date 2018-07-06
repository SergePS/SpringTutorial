package by.serge;

import java.text.DateFormat;
import java.util.Date;

public class Event {

	private int id;
	private String msg;
	private Date date;
	private DateFormat df;

	public Event() {
		id = IdGenerator.getId();
	}

	public Event(Date date, DateFormat df) {
		id = IdGenerator.getId();
		this.date = date;
		this.df = df;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", msg=" + msg + ", date=" + date + "]";
	}

}

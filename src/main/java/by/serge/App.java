package by.serge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.serge.logger.EventLogger;

public class App {

	private Client client;
	private EventLogger eventLogger;


	App() {
	}


	public App(Client client, EventLogger eventLogger) {
		super();
		this.client = client;
		this.eventLogger = eventLogger;
	}


	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("AppContext.xml");
		Object obj = appContext.getBean("app");
		if (obj instanceof App) {
			App app = (App) obj;
			Event event = (Event) appContext.getBean("event");
			event.setMsg("Some events for User 1");
			app.logEvent(event);
		}
		((ConfigurableApplicationContext) appContext).close();
	}


	private void logEvent(Event event) {
		String message = event.getMsg().replaceAll(client.getId(), client.getFullName());
		event.setMsg(message);
		eventLogger.logEvent(event);
	}

}

package by.serge;

import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.serge.logger.EventLogger;

public class App {

	private static Logger logger = LogManager.getLogger(App.class);

	private Client client;
	private EventLogger defaultLogger;
	private Map<EventType, EventLogger> loggerMap;


	App() {
	}


	public App(Client client, EventLogger defaultLogger, Map<EventType, EventLogger> loggerMap) {
		super();
		this.client = client;
		this.defaultLogger = defaultLogger;
		this.loggerMap = loggerMap;
	}


	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("AppContext.xml");
		Object obj = appContext.getBean("app");
		if (obj instanceof App) {
			App app = (App) obj;
			Event event = (Event) appContext.getBean("event");

			event.setMsg("Some INFO events for User 1");
			app.logEvent(event, EventType.INFO);

			event.setMsg("Some ERROR events for User 1");
			app.logEvent(event, EventType.ERROR);

			event.setMsg("Some null events for User 1");
			app.logEvent(event, null);
		}
		((ConfigurableApplicationContext) appContext).close();
	}


	private void logEvent(Event event, EventType type) {
		String message = event.getMsg().replaceAll(client.getId(), client.getTitle() + " " + client.getFullName());
		event.setMsg(message);

		if (type == null) {
			defaultLogger.logEvent(event);
		} else {
			logger.log(Level.DEBUG, "loggerMap size = " + loggerMap.size());
			loggerMap.get(type).logEvent(event);
		}
	}

}

package quotesservice.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("sdelab/resources")
public class MotivationalQuotesConfig extends ResourceConfig {
	public MotivationalQuotesConfig() {
		packages("quotesservice.rest.resources"); // Jersey will load all the resources under this package
	}
}
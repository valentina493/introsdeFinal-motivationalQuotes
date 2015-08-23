package quotesservice.rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class MotivationalQuotesApp {
	private static final URI BASE_URI = URI.create("http://localhost:9090/motivationalquotes/sport/");    
    public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException{
        System.out.println("Starting quotes service HTTP server...");
        JdkHttpServerFactory.createHttpServer(BASE_URI, createApp());
        System.out.println("Server started on " + BASE_URI + "\n[kill the process to exit]");
    }

    public static ResourceConfig createApp() {
        System.out.println("Starting REST quotes services...");
        return new MotivationalQuotesConfig();
    }
}

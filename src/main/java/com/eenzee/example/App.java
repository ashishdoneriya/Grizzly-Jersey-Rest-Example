package com.eenzee.example;
import com.eenzee.example.rest.resource.ExampleResource;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final String BASE_URI = "http://0.0.0.0:8081";
    private static HttpServer server;

    public static void main( String[] args )
    {
        System.out.println("Starting server");
        server = startServer();
        System.out.println("server starting, continuing forever");
        Runtime.getRuntime().addShutdownHook(new ShutdownThread());
        for(;;){}

    }

    public static HttpServer startServer() {
        ResourceConfig resourceConfig = new ResourceConfig(JacksonJsonProvider.class);
        resourceConfig.register(new ExampleResource());
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), resourceConfig);
    }

    public static class ShutdownThread extends Thread {
        public void run() {
            server.shutdownNow();
        }
    }
}

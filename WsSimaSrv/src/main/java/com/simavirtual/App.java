package com.simavirtual;

import javax.xml.ws.Endpoint;
import com.simavirtual.ws.UnWebService;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println("Paso");
        Endpoint.publish("http://localhost:8080/UnWebService", new UnWebService());
    }
}
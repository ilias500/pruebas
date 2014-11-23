package com.simavirtual;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import com.simavirtual.ws.UnWebService;
import com.simavirtual.ws.UnWebServiceService;

/**
 * Hello world!
 *
 */

public class App{
    public static void main( String[] args ) throws MalformedURLException{

      // Obtencion del cliente

      UnWebServiceService unWebServiceService = new UnWebServiceService(
            new URL("http://localhost:8080/WsSimaCli-1.0.0-beta/UnWebService?wsdl"),    // URL real del web service.
            new QName("http://ws.simavirtual.com/",           // copiado del código generado por wsimport
                  "UnWebServiceService"));

      UnWebService unWebService = unWebServiceService.getUnWebServicePort();

      // Ya podemos usarlo
      System.out.println(unWebService.codigo("91300215"));

    }
}

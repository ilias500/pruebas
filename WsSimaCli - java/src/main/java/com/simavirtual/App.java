package com.simavirtual;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import com.simavirtual.ws.UnWebService;
import com.simavirtual.ws.UnWebService_Service;


/**
 * Hello world!
 *
 */

public class App{
    public static void main( String[] args ) throws MalformedURLException{

      // Obtencion del cliente
      
      UnWebService_Service unWebServiceService = new UnWebService_Service(
            new URL("http://192.168.0.15:8080/WsSimaSvr/UnWebService?wdsl"),    // URL real del web service.
            new QName("http://ws.simavirtual.com/",           // copiado del código generado por wsimport
                  "UnWebServiceService"));

      UnWebService unWebService = unWebServiceService.getUnWebServicePort();

      // Ya podemos usarlo
      System.out.println(unWebService.codigo("91300215"));

    }
}

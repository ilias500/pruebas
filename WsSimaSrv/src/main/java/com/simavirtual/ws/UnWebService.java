package com.simavirtual.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class UnWebService {
   @WebMethod
   public String codigo(String documento) {
      String codigo;
      codigo = documento+"-5";
      return codigo;
   }
}
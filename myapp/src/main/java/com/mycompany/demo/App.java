package com.mycompany.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.mycompany.demo.Persona;

public class App
{
    public static void main( String[] args ){

      EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadOGM");

      System.out.println(emf);
      EntityManager em = emf.createEntityManager();
      List<Persona> lista=em.createQuery("select p from Persona p",Persona.class).getResultList();

      for(Persona p :lista) {
        System.out.println(p.getNombre());
        System.out.println(p.getApellidos());
      }
      em.close();

      System.out.println( "Hello World!" );
    }
}
